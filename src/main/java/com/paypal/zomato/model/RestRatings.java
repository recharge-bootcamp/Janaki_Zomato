package com.paypal.zomato.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "restratings")

public class RestRatings implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 219706652525662381L;
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
		
	@ManyToOne
	@JoinColumn(name="res_Id")
	private Restaurants resId;
	
	public Restaurants getResId() {
		return resId;
	}
	public void setResId(Restaurants resId) {
		this.resId = resId;
	}
	@Column(name="ambience_rating")
	private String ambience;
	
	@Column(name="food_rating")
	private String food;
	
	@Column(name="service_rating")
	private String service;
	
	@Column(name="comments")
	private String comments;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAmbience() {
		return ambience;
	}
	public void setAmbience(String ambience) {
		this.ambience = ambience;
	}
	public String getFood() {
		return food;
	}
	public void setFood(String food) {
		this.food = food;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	

}
