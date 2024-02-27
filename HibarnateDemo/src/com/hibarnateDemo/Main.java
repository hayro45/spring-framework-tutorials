package com.hibarnateDemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(City.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			//HQL -> Hybernate Query Language
			//select * from city
			//from city c where c.countryCode='TUR' AND c.district='Ankara'
			//from city c where c.name LIKE '%kar%'
			//ASC -> Ascending
			//DESC -> Descenting
			
			/*
			 * List<String> countryCodes = session
			 * .createQuery("select c.countryCode from City c GROUP BY c.countryCode")
			 * .getResultList();
			 * 
			 * for(String countryCode : countryCodes) { System.out.println(countryCode); }
			 */
			
			//INSERT
			/*
			 * City city = new City(); 
			 * city.setName("Düzce 1"); 
			 * city.setCountryCode("TUR");
			 * city.setDistrict("Karedeniz"); 
			 * city.setPopulation(100000);
			 * 
			 * session.save(city); 
			 * //unit of work 
			 * session.getTransaction().commit();
			 * System.out.println("Şehir eklendi");
			 */
			
			//UPDATE
			//City city = session.get(City.class, 4080);
			//System.out.println(city.getPopulation());
			
			
			//CRUD Create Read Update Delete
			
			//DELETE
			City city = session.get(City.class, 4080);
			session.delete(city);
			System.out.println("şehir silindi");
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
		
	}

}
