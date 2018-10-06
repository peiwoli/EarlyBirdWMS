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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.earlybird.wms.base.entity.constants.RoleStatus;

/**
 * @author Peili Zhou
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="CLASS_TYPE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("ROLE")
public class Role extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5804791317344792171L;
	
	
	@ManyToMany(mappedBy = "roles")
    protected Set<User> users = new HashSet<>();
	
	
	@Column
	@Enumerated(EnumType.STRING)
	protected RoleStatus status = RoleStatus.ENABLED;
	
	@ManyToMany
    @JoinTable(
        name = "Role_2_MenuItem", 
        joinColumns = { @JoinColumn(name = "menu_item_key") }, 
        inverseJoinColumns = { @JoinColumn(name = "role_key") }
    )
	protected Set<MenuItem> menuItems = new HashSet<>();
	
	
	/**
	 * 
	 */
	public Role() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the users
	 */
	public Set<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	public void addUser(User user) {
		this.users.add(user);
	}

	/**
	 * @return the status
	 */
	public RoleStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(RoleStatus status) {
		this.status = status;
	}
	
	
	

}
