package tms.business.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Context {

	private static ApplicationContext appctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	public static Object getContextBean(String givenBean) {
		return appctx.getBean(givenBean);
	}
}
