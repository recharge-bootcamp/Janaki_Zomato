/**
 * 
 */
package com.paypal.zomato.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author janaki
 *
 */
@Entity
@Table(name = "restaurants")
public class Restaurants implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4288891596060794212L;
	@Id
	@GeneratedValue
	@Column(name = "id")
	private  long id;
	
	@Column(name = "name")
	private  String name;
	
	@Column(name = "LOCATION")
	private String areaName;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	

}
