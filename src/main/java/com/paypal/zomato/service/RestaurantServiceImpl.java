/**
 * 
 */
package com.paypal.zomato.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.paypal.zomato.dao.RestaurantDao;
import com.paypal.zomato.model.RestRatings;
import com.paypal.zomato.model.Restaurants;
import com.paypal.zomato.model.TestRestRatings;

/**
 * @author janaki
 *
 */
public class RestaurantServiceImpl implements RestaurantService {
	
	private static final Log LOGGER = LogFactory.getLog(RestaurantServiceImpl.class);
	@Autowired	
	RestaurantDao restaurantDao;
	/* (non-Javadoc)
	 * @see com.paypal.zomato.service.RestaurantService#viewRestaurants()
	 */
	@Override
	public List<Restaurants>  viewRestaurants() throws Exception{
		// TODO Auto-generated method stub
		return restaurantDao.viewRestaurants();
		//return null;
	}

	@Override
	public List<TestRestRatings> viewRatings(int resId) throws Exception{
		// TODO Auto-generated method stub
		return restaurantDao.viewRatings(resId);
	}

	/* (non-Javadoc)
	 * @see com.paypal.zomato.service.RestaurantService#viewRestaurants(int, int, int)
	 */
	@Override
	public List<RestRatings>  searchRestaurants(String food, String service,
			String ambience) throws Exception{
		// TODO Auto-generated method stub
		return restaurantDao.searchRestaurants(food, service, ambience);
		
	}

	/* (non-Javadoc)
	 * @see com.paypal.zomato.service.RestaurantService#rateRestaurants()
	 */
	@Override
	public void rateRestaurants() throws Exception{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<TestRestRatings> searchRestaurants(int food, int service,
			int ambience) throws Exception{
		// TODO Auto-generated method stub
		return restaurantDao.searchRestaurants(food, service, ambience);
	}


	@Override
	public void submitRating(TestRestRatings restRatings) throws Exception{
		// TODO Auto-generated method stub
		restaurantDao.submitRating(restRatings);
	}

	@Override
	public void submitRating(RestRatings restRatings)throws Exception {
		// TODO Auto-generated method stub
		
		//restaurantDao.submitRating(restRatings);
	}

}
