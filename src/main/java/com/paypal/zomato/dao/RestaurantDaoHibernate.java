/**
 * 
 */
package com.paypal.zomato.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

import com.paypal.zomato.model.RestRatings;
import com.paypal.zomato.model.Restaurants;
import com.paypal.zomato.model.TestRestRatings;



/**
 * @author janaki
 *
 */
public class RestaurantDaoHibernate  implements RestaurantDao {
	 
	private static final Log LOGGER = LogFactory.getLog(RestaurantDaoHibernate.class);
	//SessionFactory sessionsFactory;
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	Session session = null;
	Transaction tx = null;
 
	/* (non-Javadoc)
	 * @see com.paypal.zomato.dao.RestaurantDao#viewRestaurants()
	 * To Retrieve all the restaurants 
	 */
	@Override
	@SuppressWarnings("unchecked")
	public  List<Restaurants>  viewRestaurants() throws Exception{
		
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Restaurants> restList = session.createCriteria(Restaurants.class).list();
		tx.commit();
		session.close();
		return restList;

	}

	/* (non-Javadoc)
	 * @see com.paypal.zomato.dao.RestaurantDao#viewRestaurants(int, int, int)
	 * To Search restaurant with the given criteria
	 */
	@Override
	public  List<RestRatings>  searchRestaurants(String food, String service,
			String ambience)throws Exception {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<RestRatings> restList=session.createQuery("from RestRatings rt where rt.food='"+food+"' and rt.service='"+service+"' and rt.ambience='"+ambience+"'").list();
		tx.commit();
		session.close();
		return restList;
		
	}

	
	@Override
	public List<TestRestRatings> searchRestaurants(int food, int service,
			int ambience)throws Exception {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<TestRestRatings> newList=new ArrayList<TestRestRatings>();
		
		String hqueryString=" from TestRestRatings ts where ts.ambience>="+ambience+" and ts.food>="+food+" and ts.service>="+service;
		List<TestRestRatings> restList=session.createQuery(hqueryString).list();
		
		//String hqueryString=" select rt.resId.name,rt.resid.areaname,AVG(rt.ambience),AVG(rt.food),AVG(rt.service) from TestRestRatings rt GROUP BY rt.resId.id";
		//List<Object[]> restList=session.createQuery(hqueryString).list();
		
		
		LOGGER.info("Search restaurant list size="+restList.size());
		/*Criteria c = session.createCriteria(TestRestRatings.class)  
			    			.setProjection(Projections.projectionList()
			    					.add(Projections.property("resId"))
			    					.add(Projections.groupProperty("resId.id"))
			    					.add(Projections.avg("food"))
		                            .add(Projections.avg("service"))
		                            .add(Projections.avg("ambience")));
		 c.setResultTransformer(Transformers.aliasToBean(TestRestRatings.class));
		 List<TestRestRatings> restList = c.list(); 
		if(restList.size()>0){
			
		for(TestRestRatings ts:restList){
			if(ts.getAmbience()>=ambience && ts.getFood()>=food && ts.getService()>=service){
			newList.add(ts)	;
			}
		}
		}*/
				
		tx.commit();
		session.close();
		return restList;
		//return newList;
	}

	@Override
	public List<TestRestRatings> viewRatings(int resId) throws Exception{
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<TestRestRatings> restList=session.createQuery("from TestRestRatings rt where rt.resId.id="+resId).list();
		tx.commit();
		session.close();
		return restList;
	}

	/* (non-Javadoc)
	 * @see com.paypal.zomato.dao.RestaurantDao#rateRestaurants()
	 * 
	 */
	@Override
	public Restaurants rateRestaurants() throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void submitRating(TestRestRatings restRatings) throws Exception{
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(restRatings);
		tx.commit();
		session.close();

	}

}
