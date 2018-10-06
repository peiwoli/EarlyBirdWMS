/**
 * 
 */
package com.earlybird.wms.base.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Peili Zhou
 *
 */
@Embeddable
public class Dimension implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -774692439691197512L;


	@Column(nullable=false,columnDefinition="double NOT NULL DEFAULT 0")
	protected double width = 0.0;
	
	@Column(nullable=false,columnDefinition="double NOT NULL DEFAULT 0")
	protected double height = 0.0;
	
	@Column(nullable=false,columnDefinition="double NOT NULL DEFAULT 0")
	protected double length = 0.0;
	
	@Column(nullable=false,columnDefinition="double NOT NULL DEFAULT 0")
	protected double weight = 0.0;
	
	@Column(nullable=false,columnDefinition="double NOT NULL DEFAULT 0")
	protected double volumn = 0.0;

	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * @return the length
	 */
	public double getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(double length) {
		this.length = length;
	}

	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * @return the volumn
	 */
	public double getVolumn() {
		return volumn;
	}

	/**
	 * @param volumn the volumn to set
	 */
	public void setVolumn(double volumn) {
		this.volumn = volumn;
	}
	
	
}
