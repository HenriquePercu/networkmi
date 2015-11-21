package com.networkmi.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.stat.Statistics;

public class HibernateUtil {
	private static SessionFactory factory;

	private static ThreadLocal<Session> sessions = new ThreadLocal<Session>();

	static {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure();

		factory = cfg.buildSessionFactory();
	}

	public static Session openSession() {
		sessions.set(factory.openSession());
		return sessions.get();
	}

	public static void closeCurrentSession() {
		sessions.get().close();
		sessions.set(null);
	}

	public static Session currentSession() {
		return sessions.get();
	}

	public static Statistics getStatistics() {
		return factory.getStatistics();
	}
}
