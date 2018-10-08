/**
 * 
 */
package com.earlybird.wms.base.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;

import com.earlybird.wms.base.api.util.DateTimeUtil;
import com.earlybird.wms.base.entity.constants.TaskStatus;

/**
 * @author Peili Zhou
 *
 */
@Entity
public class Task extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7197028394076985949L;

	@Column(nullable = false, columnDefinition = "INT NOT NULL DEFAULT 0")
	@Min(0)
	int priority = 0;

	@Column(nullable = false, columnDefinition = "INT NOT NULL DEFAULT 0")
	int sequence = 0;

	@Column
	@Enumerated(EnumType.STRING)
	protected TaskStatus status = TaskStatus.UNPROC;

	@Column
	protected String taskType = this.getClass().getSimpleName();

	/**
	 * The inventory move from this Shipper
	 */
	@ManyToOne
	protected Shipper sourceShipper;

	/**
	 * The inventory move to this shipper
	 */
	@ManyToOne
	protected Shipper targetShipper;

	/**
	 * Stock moves from this inventory
	 */
	@ManyToOne
	protected Inventory sourceInventory;

	/**
	 * Stock moves to this inventory
	 */
	@ManyToOne
	protected Inventory targetInventory;

	/**
	 * Inventory moves from this location
	 */
	@ManyToOne
	protected Location sourceLocation;

	/**
	 * Stock moves to this location
	 */
	@ManyToOne
	protected Location targetLocation;



	@Column(nullable = false, columnDefinition = "INT NOT NULL DEFAULT 0")
	int quantity = 0;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable = false)
	protected Date startDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable = false)
	protected Date endDate;

	@Column(nullable = false, columnDefinition = "BIGINT NOT NULL DEFAULT 0")
	long duration = 0;

	/**
	 * 
	 */
	public Task() {

	}
	
	

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the duration
	 */
	public long getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(long duration) {
		this.duration = duration;
	}

	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * @return the sequence
	 */
	public int getSequence() {
		return sequence;
	}

	/**
	 * @param sequence the sequence to set
	 */
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	/**
	 * @return the status
	 */
	public TaskStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	/**
	 * @return the taskType
	 */
	public String getTaskType() {
		return taskType;
	}

	/**
	 * @param taskType the taskType to set
	 */
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	/**
	 * @return the sourceShipper
	 */
	public Shipper getSourceShipper() {
		return sourceShipper;
	}

	/**
	 * @param sourceShipper the sourceShipper to set
	 */
	public void setSourceShipper(Shipper sourceShipper) {
		this.sourceShipper = sourceShipper;
	}

	/**
	 * @return the targetShipper
	 */
	public Shipper getTargetShipper() {
		return targetShipper;
	}

	/**
	 * @param targetShipper the targetShipper to set
	 */
	public void setTargetShipper(Shipper targetShipper) {
		this.targetShipper = targetShipper;
	}

	/**
	 * @return the sourceInventory
	 */
	public Inventory getSourceInventory() {
		return sourceInventory;
	}

	/**
	 * @param sourceInventory the sourceInventory to set
	 */
	public void setSourceInventory(Inventory sourceInventory) {
		this.sourceInventory = sourceInventory;
	}

	/**
	 * @return the targetInventory
	 */
	public Inventory getTargetInventory() {
		return targetInventory;
	}

	/**
	 * @param targetInventory the targetInventory to set
	 */
	public void setTargetInventory(Inventory targetInventory) {
		this.targetInventory = targetInventory;
	}

	/**
	 * @return the sourceLocation
	 */
	public Location getSourceLocation() {
		return sourceLocation;
	}

	/**
	 * @param sourceLocation the sourceLocation to set
	 */
	public void setSourceLocation(Location sourceLocation) {
		this.sourceLocation = sourceLocation;
	}

	/**
	 * @return the targetLocation
	 */
	public Location getTargetLocation() {
		return targetLocation;
	}

	/**
	 * @param targetLocation the targetLocation to set
	 */
	public void setTargetLocation(Location targetLocation) {
		this.targetLocation = targetLocation;
	}

	

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * activate task
	 */
	public void activate() {
		setStatus(TaskStatus.ACTIVE);
		setStartDate(DateTimeUtil.newDate());
	}

	/**
	 * complete the task
	 */
	public void complete() {
		setStatus(TaskStatus.COMPLETED);
		setEndDate(DateTimeUtil.newDate());
	}

	/**
	 * suspend the task
	 */
	public void suspend() {
		setStatus(TaskStatus.SUSPENDED);
	}

	/**
	 * resume the task
	 */
	public void resume() {
		if (getStatus().equals(TaskStatus.SUSPENDED))
			setStatus(TaskStatus.ACTIVE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + priority;
		result = prime * result + quantity;
		result = prime * result + sequence;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((taskType == null) ? 0 : taskType.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		Task other = (Task) obj;
		if (priority != other.priority)
			return false;
		if (quantity != other.quantity)
			return false;
		if (sequence != other.sequence)
			return false;
		if (status != other.status)
			return false;
		if (taskType == null) {
			if (other.taskType != null)
				return false;
		} else if (!taskType.equals(other.taskType))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Task [quantity=" + quantity + ", id=" + id + "]";
	}

}
