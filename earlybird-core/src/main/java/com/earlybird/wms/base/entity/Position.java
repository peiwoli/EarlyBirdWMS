/**
 * 
 */
package com.earlybird.wms.base.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The position of a {@link Location} inside storage or on the conveyor
 * @author Peili Zhou
 *
 */
@Embeddable
public class Position implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8158910599108905383L;

	@Column(nullable=false,columnDefinition="int NOT NULL DEFAULT 0")
	protected int x = 0;
	
	@Column(nullable=false,columnDefinition="int NOT NULL DEFAULT 0")
	protected int y = 0;
	
	@Column(nullable=false,columnDefinition="int NOT NULL DEFAULT 0")
	protected int z = 0;
	
	@Column(nullable=false,columnDefinition="int NOT NULL DEFAULT 0")
	protected int depth = 0;
	
	/**
	 * 
	 */
	public Position() {
		
	}
	
	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param z
	 * @param depth
	 */
	public Position(int x, int y, int z, int depth) {
		this.x= x;
		this.y = y;
		this.z = z;
		this.depth = depth;
	}
	
	/**
	 * 
	 * @return
	 */
	public static Position getNoPosition() {
		return new Position(0,0,0,0);
	}
	
	/**
	 * 
	 * @return Positon
	 */
	public static Position getDefaultPosition() {
		return new Position(1,1,1,1);
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the z
	 */
	public int getZ() {
		return z;
	}

	/**
	 * @param z the z to set
	 */
	public void setZ(int z) {
		this.z = z;
	}

	/**
	 * @return the depth
	 */
	public int getDepth() {
		return depth;
	}

	/**
	 * @param depth the depth to set
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	
	
}
