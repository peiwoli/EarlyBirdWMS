/**
 * 
 */
package com.earlybird.wms.base.dataloader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.earlybird.wms.base.entity.BaseEntity;

/**
 * Triggered when application started successfully.
 * @author Peili Zhou
 *
 */
@Component
@Order(value = 1)
@ConfigurationProperties(prefix = "dataloader")
@Transactional
public class DataLoader implements ApplicationRunner {

	Logger logger = LoggerFactory.getLogger(DataLoader.class);

	@PersistenceContext
	private EntityManager em;

	@Value("classpath*:dataloader/**/*.csv")
	private Resource[] files;

	private List<String> packages = new ArrayList<String>();

	/**
	 * @return the packages
	 */
	public List<String> getPackages() {
		return packages;
	}

	/**
	 * @param packages the packages to set
	 */
	public void setPackages(List<String> packages) {
		this.packages = packages;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.boot.ApplicationRunner#run(org.springframework.boot.
	 * ApplicationArguments)
	 */
	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info("###########################  DataLoader application started #############################");

		for (int i = 0; i < files.length; i++) {
			startLoadingPrimitiveFieldsForEachEntity(files[i]);

		}
		for (int i = 0; i < files.length; i++) {

			startLoadingAssociatedFieldsForEachEntity(files[i]);
		}

		logger.info("###########################  DataLoader application ended #############################");

	}

	/**
	 * @param resource the *.csv of current BaseEntity
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws InvocationTargetException
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	private void startLoadingAssociatedFieldsForEachEntity(Resource resource) throws FileNotFoundException, IOException,
			IllegalArgumentException, IllegalAccessException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, SecurityException {
		logger.info("-----------------------------------------------------------------------");
		logger.info("----LOADING {} FOR ASSOCIATE FIELDS------------------------------------", resource.getFilename());

		Class<? extends BaseEntity> classToInstantiate = getClassObj(resource);
		if (classToInstantiate == null)
			return;

		Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader()
				.parse(new FileReader(resource.getFile().getAbsolutePath()));
		for (CSVRecord record : records) {
			// now find the entity already persisted
			String entityId = record.get("id");
			BaseEntity entity = fetchEntityById(entityId, classToInstantiate);
			logger.info("Found {}", entity);
			populateAssociatedFields(record, entity);
		}

	}

	/**
	 * @param record
	 * @param entity
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws ClassNotFoundException
	 * @throws InvocationTargetException
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	@SuppressWarnings("unchecked")
	private void populateAssociatedFields(CSVRecord record, BaseEntity entity)
			throws IllegalArgumentException, IllegalAccessException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, SecurityException {
		// iterate all member fields of current entity
		for (Field field : getAllFields(entity.getClass())) {

			if (isRecordFieldValueEmpty(record, field)) {
				continue;
			}
			// handle OneToOne , or ManyToOne
			if (BaseEntity.class.isAssignableFrom(field.getType())) {
				logger.info("PEILI   entity:{}  fieldName:{},cvs record column value[{}], field genericType:{}...",
						entity.getId(), field.getName(), record.get(field.getName()),
						field.getGenericType().getTypeName());
				BaseEntity foreignObj = fetchEntityById(record.get(field.getName()),
						(Class<? extends BaseEntity>) Class.forName(field.getGenericType().getTypeName()));
				if (foreignObj == null) {
					continue;
				}
				field.setAccessible(true);
				field.set(entity, foreignObj);
				em.persist(entity);
				logger.info("populateAssociatedFields:: entity:{} field:{} is updated to foreignObj:{}", entity.getId(),
						field.getName(), foreignObj.getId());
			} else if (isAssociatedListType(field)) {
				// handle OneToMany or ManyToMany relations
				addAssociatedEntity(field, entity, record);
			}
		}

	}

	/**
	 * @param record
	 * @param field
	 * @return
	 */
	private boolean isRecordFieldValueEmpty(CSVRecord record, Field field) {
		try {
			if (record.get(field.getName()).trim().isEmpty()) {
				return true;
			}
		} catch (Exception e) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param id
	 * @param cls
	 * @return
	 */
	protected BaseEntity fetchEntityById(String id, Class<? extends BaseEntity> cls) {
		if (id == null || id.trim().isEmpty()) {
			return null;
		}
		String query = "SELECT o FROM " + cls.getCanonicalName() + " o WHERE o.id= :id";
		logger.info("fetch Entity query:{},param:{}", query, id);
		return em.createQuery(query, cls).setParameter("id", id).getSingleResult();
	}

	/**
	 * 
	 * @param resource
	 */
	private void startLoadingPrimitiveFieldsForEachEntity(Resource resource) {
		logger.info("-----------------------------------------------------------------------");
		logger.info("---------LOADING {} FOR PRIMITIVE FIELDS----------------", resource.getFilename());

		Class<?> classToInstantiate = getClassObj(resource);
		if (classToInstantiate == null)
			return;

		populatePrimtiveFields(resource, classToInstantiate);
	}


	/**
	 * add entity to my association of entities
	 * 
	 * @param field
	 * @param entity
	 * @param record
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	private void addAssociatedEntity(Field field, BaseEntity entity, CSVRecord record)
			throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException {
		if ( isRecordFieldValueEmpty(record, field)) {
			return;
		}
		ParameterizedType pType = (ParameterizedType) field.getGenericType();
		String className = pType.getActualTypeArguments()[0].getTypeName();
		for (String foreignId : record.get(field.getName()).split(",")) {
			if (foreignId.trim().isEmpty())
				continue;
			logger.info("addAssociatedEntity param [{}] to entity {}", foreignId, entity.getId());
			@SuppressWarnings("unchecked")
			BaseEntity foreignEntity = fetchEntityById(foreignId,
					(Class<? extends BaseEntity>) Class.forName(className));
			
			field.setAccessible(true);
			Method addMethodToField = field.getType().getDeclaredMethod("add", Object.class);
			addMethodToField.invoke(field.get(entity), foreignEntity);
			em.persist(entity);
		}
	}

	/**
	 * Create and persist entities with primitive members
	 * 
	 * @param resource
	 * @param classToInstantiate
	 */
	private BaseEntity populatePrimtiveFields(Resource resource, Class<?> classToInstantiate) {
		try {
			Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader()
					.parse(new FileReader(resource.getFile().getAbsolutePath()));
			for (CSVRecord record : records) {

				BaseEntity entity = (BaseEntity) classToInstantiate.newInstance();
				for (Field field : getAllFields(entity.getClass())) {
					if (!record.toMap().containsKey(field.getName())) {
						continue;
					}
					if (isPrimitiveFieldType(field)) {
						String fieldValueInString = getPrimitiveFieldValueInString(record, field);
						logger.info("Field Name {}, record column value {}", field.getName(), fieldValueInString);
						setPrimitiveFieldValue(field, entity, fieldValueInString);
					} else {
						logger.info("{} is not primitive field", field.getName());
					}

				}
				em.merge(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Is field type associated to a set of entities. The association must be
	 * annotated because it is JPA entity
	 * 
	 * @param field
	 * @return
	 */
	private boolean isAssociatedListType(Field field) {
		// TODO : not working fix me.
		// logger.info("Field {} , getType {} is List {}, is Set {}, is Map {}",
		// field.getName(),field.getGenericType().getTypeName(),
		// field.getGenericType().getTypeName().contains("List") ,
		// field.getGenericType().getTypeName().contains("Set")
		// , field.getGenericType().getTypeName().contains("Map"));

		return field.getGenericType().getTypeName().contains("List")
				|| field.getGenericType().getTypeName().contains("Set")
				|| field.getGenericType().getTypeName().contains("Map");
	}

	/**
	 * Is field type primitive
	 * 
	 * @param field
	 * @return
	 */
	private boolean isPrimitiveFieldType(Field field) {
		return field.getType().isPrimitive() 
				|| field.getType().equals(String.class) 
				|| field.getType().isEnum()
				|| field.getType().equals(Date.class) 
				|| field.getType().equals(Calendar.class)
				|| Integer.TYPE.equals(field.getType()) 
				|| Boolean.class.equals(field.getType())
				|| Double.class.equals(field.getType()) 
				|| Float.class.equals(field.getType())
				|| Long.class.equals(field.getType())
				|| int.class.equals(field.getType())
				|| long.class.equals(field.getType())
				|| boolean.class.equals(field.getType())
				|| double.class.equals(field.getType())
				|| float.class.equals(field.getType());
	}

	/**
	 * Set primitive type field values. eg Integer, Long, String etc.
	 * 
	 * @param field
	 * @param entity
	 * @param value
	 */
	private void setPrimitiveFieldValue(Field field, BaseEntity entity, String value) {
		field.setAccessible(true);
		try {

			if (!Modifier.isStatic(field.getModifiers()))
				field.set(entity, castStringValueToClassValue(value, field.getType()));
		} catch (IllegalArgumentException | IllegalAccessException e) {
			logger.error(e.getMessage());
		}
	}

	/**
	 * convert String value to other primitive type
	 * 
	 * @param value
	 * @param targetClsToCast
	 * @return
	 */
	private Object castStringValueToClassValue(final String value, final Class<?> targetClsToCast) {
		if (Long.class.equals(targetClsToCast) || long.class.equals(targetClsToCast)) {
			return Long.parseLong(value);
		} else if (Integer.class.equals(targetClsToCast) || targetClsToCast.equals(int.class)) {
			return Integer.parseInt(value);
		} else if (Float.class.equals(targetClsToCast) || float.class.equals(targetClsToCast)) {
			return Float.parseFloat(value);
		} else if (Double.class.equals(targetClsToCast) || double.class.equals(targetClsToCast)) {
			return Double.parseDouble(value);
		} else if (Boolean.class.equals(targetClsToCast) || boolean.class.equals(targetClsToCast)) {
			return Boolean.parseBoolean(value);
		}
		
		return value;
	}

	/**
	 * 
	 * @param record
	 * @param field
	 * @return
	 */
	private String getPrimitiveFieldValueInString(CSVRecord record, Field field) {
		try {
			return record.get(field.getName());
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * Get all private public fields of a class with reflection including its parent
	 * classes.
	 * 
	 * @param type
	 * @return
	 */
	public List<Field> getAllFields(Class<?> type) {
		List<Field> fields = new ArrayList<Field>();
		for (Class<?> c = type; c != null; c = c.getSuperclass()) {
			fields.addAll(Arrays.asList(c.getDeclaredFields()));
		}
		return fields;
	}

	/**
	 * Get all methods and parents's classes methods
	 * 
	 * @param cls
	 * @return
	 */
	public List<Method> getAllMethods(Class<?> cls) {
		List<Method> methods = new ArrayList<>();
		for (Class<?> c = cls; c != null; c = c.getSuperclass()) {
			methods.addAll(Arrays.asList(c.getDeclaredMethods()));
		}
		return methods;
	}

	/**
	 * 
	 * @param resource
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Class<? extends BaseEntity> getClassObj(Resource resource) {
		String simpleClassName = getClassName(resource.getFilename());
		for (String p : packages) {
			String fullClassName = p.concat("." + simpleClassName);
			logger.info("returning class obj for {} ", fullClassName);
			try {
				return (Class<? extends BaseEntity>) Class.forName(fullClassName);
			} catch (ClassNotFoundException e) {
				logger.error(" Skip !!! {} ", e.getMessage());
			}
		}
		logger.error("Unable to find a class for {}", simpleClassName);
		return null;
	}

	/**
	 * 
	 * @param fileClassPath
	 * @return the class name of the csv file represents
	 */
	public String getClassName(String fileName) {
		String className = fileName.substring(0, fileName.lastIndexOf("."));
		logger.info("Class Name :{}", className);

		return className;
	}

	/**
	 * 
	 * @param fileClassPath
	 * @return the file absolute path
	 */
	public String getFileAbsolutePath(String fileClassPath) {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResource(fileClassPath).getFile();
	}

}
