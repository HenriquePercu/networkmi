package com.networkmi.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
   private static final SessionFactory sessionFactory = buildSessionFactory();

  private static SessionFactory buildSessionFactory()
  {
      try
      {
    	  Configuration configuration = new Configuration().configure();
    	  ServiceRegistryBuilder builder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
    	  
          return configuration.buildSessionFactory(builder.buildServiceRegistry());
      }
      catch (Throwable ex) {
          System.err.println("Initial SessionFactory creation failed." + ex);
          throw new ExceptionInInitializerError(ex);
      }
  }

  public static SessionFactory getSessionFactory() {
      return sessionFactory;
  }

  public static void shutdown() {
      // Close caches and connection pools
      getSessionFactory().close();
  }
}
