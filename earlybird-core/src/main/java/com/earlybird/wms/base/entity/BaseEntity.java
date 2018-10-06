/**
 * 
 */
package com.earlybird.wms.base.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * @author Peili Zhou
 *
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="CLASS_TYPE", discriminatorType = DiscriminatorType.STRING)
public class BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4581906089375853995L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "key", updatable = false, nullable = false)
	Long key;
	
	@Column(unique=true)
	String id;
	
	@Column
	String createdBy = "system";
	
	@Column
	String updatedby;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column( insertable = false)
	Date createdDate = new Date();
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	Date updatedDate ;

	@Version
	@Column(nullable=false,columnDefinition="INT NOT NULL DEFAULT 0")
	Integer version = 0;
	
	@Column(nullable=false,columnDefinition="BOOLEAN NOT NULL DEFAULT FALSE")
	Boolean softDeleted = false;
	/**
	 * 
	 */
	public BaseEntity() {
		
	}
	/**
	 * @return the key
	 */
	public long getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(long key) {
		this.key = key;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @return the updatedby
	 */
	public String getUpdatedby() {
		return updatedby;
	}
	/**
	 * @param updatedby the updatedby to set
	 */
	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}
	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * @return the updatedDate
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}
	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
	}
	/**
	 * @return the softDeleted
	 */
	public boolean isSoftDeleted() {
		return softDeleted;
	}
	/**
	 * @param softDeleted the softDeleted to set
	 */
	public void setSoftDeleted(boolean softDeleted) {
		this.softDeleted = softDeleted;
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (int) (key ^ (key >>> 32));
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseEntity other = (BaseEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (key != other.key)
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BaseEntity [key=" + key + ", id=" + id + "]";
	}
	
	
	

}
