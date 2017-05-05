package com.paypal.zomato.service;

import java.util.List;

import com.paypal.zomato.model.RestRatings;
import com.paypal.zomato.model.Restaurants;
import com.paypal.zomato.model.TestRestRatings;

public interface RestaurantService {
	public List<Restaurants> viewRestaurants() throws Exception;
	public List<TestRestRatings> viewRatings(int resId)throws Exception;
	public List<RestRatings> searchRestaurants(String food,String service,String ambience)throws Exception;
	public List<TestRestRatings> searchRestaurants(int food,int service,int ambience)throws Exception;
	public void rateRestaurants()throws Exception;
	public void submitRating(RestRatings restRatings)throws Exception;
	public void submitRating(TestRestRatings restRatings)throws Exception;

}
