package com.test.db;

import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Session;

public class DBtest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String relativelyPath=System.getProperty("user.dir"); 
		PropertyConfigurator.configure( relativelyPath + "/config/log4j.properties" );
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();  
        session.beginTransaction();  
  
        User u = new User();  
        u.setName("Íõxiaoming");  
        session.save(u);  
  
        session.getTransaction().commit();        

        HibernateUtil.getSessionFactory().close();  
	}

}
