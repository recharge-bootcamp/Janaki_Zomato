package com.paypal.zomato.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.paypal.zomato.model.Restaurants;
import com.paypal.zomato.model.TestRestRatings;
import com.paypal.zomato.service.RestaurantService;

@Component
@ManagedBean
@RequestScoped

public class RestaurantBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8156359569190497507L;
	private static final Log LOGGER = LogFactory.getLog(RestaurantBean.class);
	@Autowired
	RestaurantService restaurantService;
	List<Restaurants> restaurantList=new ArrayList<Restaurants>();
	List<TestRestRatings> restRatingsList=new ArrayList<TestRestRatings>();
	List<TestRestRatings> searchRestRatingsList=new ArrayList<TestRestRatings>();
	
	public List<TestRestRatings> getSearchRestRatingsList() {
		return searchRestRatingsList;
	}
	public void setSearchRestRatingsList(List<TestRestRatings> searchRestRatingsList) {
		this.searchRestRatingsList = searchRestRatingsList;
	}
	TestRestRatings restRating=new TestRestRatings();
	
	private String username;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private int resId;
	public int getResId() {
		return resId;
	}
	public void setResId(int resId) {
		this.resId = resId;
	}
	//@Autowired
	private int food;
	//@Autowired
	private int ambience;
	//@Autowired
	private int service;
	//@Autowired
	private String comments;
	
	public List<TestRestRatings> getRestRatingsList() {
		return restRatingsList;
	}
	public void setRestRatingsList(List<TestRestRatings> restRatingsList) {
		this.restRatingsList = restRatingsList;
	}
	public int getFood() {
		return food;
	}
	public void setFood(int food) {
		this.food = food;
	}
	public int getAmbience() {
		return ambience;
	}
	public void setAmbience(int ambience) {
		this.ambience = ambience;
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
	
	public List<Restaurants> getRestaurantList() {
		return restaurantList;
	}
	public void setRestaurantList(ArrayList<Restaurants> restaurantList) {
		this.restaurantList = restaurantList;
	}
	public RestaurantService getRestaurantService() {
		return restaurantService;
	}
	public void setRestaurantService(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}
	
	/*
	 * This method is called to view the restaurants which are available in the system
	 */
	public String viewRestaurants(){
		try{
			LOGGER.info("I am in viewRestaurants");
		restaurantList=restaurantService.viewRestaurants();
		
		
		}
		catch(Exception e){
			LOGGER.error(e.getMessage());
			
		}
		LOGGER.info("I am out viewRestaurants");
		return "ShowRestaurants";
		}
	public String searchRestaurants(){
			return "search";
	}
	/*
	 * This method is called to search the restaurants with the given criteria 
	 */
	public String searchSubmitRestaurants(){
		try{
			LOGGER.info("search in.........");
			searchRestRatingsList=restaurantService.searchRestaurants(food, service, ambience);
			
		}
		catch(Exception e){
			LOGGER.error(e.getMessage());
		}
		return "success";
		
	}
	public String rateRestaurant(){
		return "giveRating";
	}
	/*
	 * This method is called to submit the ratings of a particular restaurant 
	 */
	public String submitRating(){
		try{
		Restaurants rest=new Restaurants();
		rest.setId(resId);
		restRating.setResId(rest);
		restRating.setFood(food);
		restRating.setService(service);
		restRating.setAmbience(ambience);
		restRating.setComments(comments);
		restRating.setUsername(username);
		restaurantService.submitRating(restRating);
		}
		catch(Exception e){
			
			LOGGER.error(e.getMessage());
		}
		return "message";
		
	}
	/*
	 * This method is called to get the ratings of a particular restaurant 
	 */
	public String viewRatings(){
		try{
			LOGGER.info("viewRatings in.........");
			restRatingsList=restaurantService.viewRatings(resId);	
			LOGGER.info("rating list size="+restRatingsList.size());
		}
		catch(Exception e){
			LOGGER.error(e.getMessage());
		}
		return "viewRatings";
		}

}
