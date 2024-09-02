package tms.persistence.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//import training.iqgateway.entities.DepartmentEO;

public class Util {
	
	private static final SessionFactory sessionFactoryRef;
	
	static {
		//if you want to use hibernate.properties
//		Configuration cfg = new Configuration();
//		cfg.configure(DepartmentEO.class);
//		sessionFactoryRef = cfg.buildSessionFactory();
		
		//If you want to use hibernate.cfg.xml
		Configuration cfg = new Configuration();
		cfg.configure();
		sessionFactoryRef = cfg.buildSessionFactory();
		
		//If you have change the file name as myconfig.cfg.xml
//		Configuration cfg = new Configuration();
//		cfg.configure("myConfig.cfg.xml");
//		sessionFactoryRef = cfg.buildSessionFactory();
		
		
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactoryRef;
	}

}

