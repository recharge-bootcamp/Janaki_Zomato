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
@Table(name = "testrestratings")
public class TestRestRatings implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8717834320798327450L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
		
	@ManyToOne
	@JoinColumn(name="resId")
	private Restaurants resId;
	
	@Column(name="ambience")
	private int ambience;
	
	@Column(name="food")
	private int food;
	
	@Column(name="service")
	private int service;
	
	@Column(name="comments")
	private String comments;
	
	@Column(name="username")
	private String username;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAmbience() {
		return ambience;
	}
	public void setAmbience(int ambience) {
		this.ambience = ambience;
	}
	public int getFood() {
		return food;
	}
	public void setFood(int food) {
		this.food = food;
	}
	public int getService() {
		return service;
	}
	public void setService(int service) {
		this.service = service;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Restaurants getResId() {
		return resId;
	}
	public void setResId(Restaurants resId) {
		this.resId = resId;
	}
}
