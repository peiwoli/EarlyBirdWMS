/**
 * 
 */
package com.earlybird.wms.base.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.earlybird.wms.base.entity.constants.UserStatus;

/**
 * @author Peili Zhou
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="CLASS_TYPE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("USER")
public class User extends BaseEntity {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4411076076602061249L;

	@Column
	protected String password;
	
	@Column
	@Enumerated(EnumType.STRING)
	protected UserStatus status = UserStatus.ENABLED;
	
	@ManyToMany
    @JoinTable(
        name = "User_2_Role", 
        joinColumns = { @JoinColumn(name = "user_key") }, 
        inverseJoinColumns = { @JoinColumn(name = "role_key") }
    )
	protected Set<Role> roles = new HashSet<>();
	
	/**
	 * 
	 */
	public User() {
		// TODO Auto-generated constructor stub
		
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the status
	 */
	public UserStatus getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(UserStatus status) {
		this.status = status;
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
	
	public void addRole(Role role) {
		this.roles.add(role);
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (status != other.status)
			return false;
		return true;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString();
	}


	

	
}
