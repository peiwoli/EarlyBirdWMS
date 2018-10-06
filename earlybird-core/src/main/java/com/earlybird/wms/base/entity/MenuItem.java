/**
 * 
 */
package com.earlybird.wms.base.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Peili Zhou
 *
 */
@Entity
@DiscriminatorColumn(name = "CLASS_TYPE", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("MENU_ITEM")
public class MenuItem extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7872875595783958162L;
	
	
	@Column(nullable=false,unique=true) 
	String name;
	
	@Column
	String action;
	
	@Column
	String link;
	
	@Column
	String url;
	
	@Column
	String icon;
	
	@Column(nullable=false,columnDefinition="INT NOT NULL DEFAULT 0")
	int level = 0;
	
	@Column(nullable=false,columnDefinition="BOOLEAN NOT NULL DEFAULT TRUE")
	boolean render = true;
	
	@ManyToMany(mappedBy = "menuItems")
    private Set<Role> roles = new HashSet<>();
	
	@Column
	private String description ;
	
	@ManyToOne
	MenuItem parent;
	
	@OneToMany(mappedBy="parent")
	Set<MenuItem> children = new HashSet<>();
	/**
	 * 
	 */
	public MenuItem() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}



	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}



	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}



	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}



	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}



	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}



	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}



	/**
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}



	/**
	 * @param icon the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}




	/**
	 * @return the render
	 */
	public boolean isRender() {
		return render;
	}



	/**
	 * @param render the render to set
	 */
	public void setRender(boolean render) {
		this.render = render;
	}



	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}



	/**
	 * @return the parent
	 */
	public MenuItem getParent() {
		return parent;
	}



	/**
	 * @param parent the parent to set
	 */
	public void setParent(MenuItem parent) {
		this.parent = parent;
	}



	/**
	 * @return the children
	 */
	public Set<MenuItem> getChildren() {
		return children;
	}



	/**
	 * @param children the children to set
	 */
	public void setChildren(Set<MenuItem> children) {
		this.children = children;
	}


	

	/**
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}



	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MenuItem ["+super.toString()+",action=" + action + ", link=" + link + ", level=" + level + ", reander=" + render + "]";
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		result = prime * result + ((icon == null) ? 0 : icon.hashCode());
		result = prime * result + level;
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuItem other = (MenuItem) obj;
		if (action == null) {
			if (other.action != null)
				return false;
		} else if (!action.equals(other.action))
			return false;
		if (icon == null) {
			if (other.icon != null)
				return false;
		} else if (!icon.equals(other.icon))
			return false;
		if (level != other.level)
			return false;
		return true;
	}
	
	
	
	

	
}
