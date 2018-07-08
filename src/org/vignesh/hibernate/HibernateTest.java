package org.vignesh.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.vignesh.dto.Address;
import org.vignesh.dto.UserDetails;

public class HibernateTest {
	public static void main(String[] args){
	
		UserDetails user= new UserDetails();
		Address addr= new Address();
		addr.setCity("City Name");
		addr.setPincode("Pincode");
		addr.setState("State Name");
		addr.setStreet("Street Name");
		
		user.setAddress(addr);
		//user.setUserId(1);
		user.setUserName("First User");
		//user.setAddress("First User's Address");
		user.setJoinedDate(new Date());
		user.setDescription("First User Description goes here");
		
		
		UserDetails user1= new UserDetails();
		user1.setAddress(addr);
		//user.setUserId(1);
		user1.setUserName("First User");
		//user1.setAddress("First User's Address");
		user1.setJoinedDate(new Date());
		user1.setDescription("First User Description goes here");
		
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(user1);
		session.getTransaction().commit();
		//sessionFactory.close();
		session.close();
		/*user=null;
		
		session=sessionFactory.openSession();
		session.beginTransaction();
		user= (UserDetails)session.get(UserDetails.class, 1);
		System.out.println("User Name Retrived is "+user.getUserName());
		*/
	}
	
}
