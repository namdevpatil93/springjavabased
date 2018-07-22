package com.godrej.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppIntializer implements WebApplicationInitializer /*extends AbstractAnnotationConfigDispatcherServletInitializer*/
{

	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext anconwebapplicationcontext=new AnnotationConfigWebApplicationContext();
		anconwebapplicationcontext.register(AppConfig.class);
		
		AnnotationConfigWebApplicationContext anconwebapplicationcontext1=new AnnotationConfigWebApplicationContext();
		anconwebapplicationcontext.register(HibernateConfig.class);
		
		servletContext.addListener(new ContextLoaderListener(anconwebapplicationcontext1));
		
		System.out.println("on startup");		
		ServletRegistration.Dynamic dispatcher=servletContext.addServlet("dispatcher",new DispatcherServlet(anconwebapplicationcontext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}

/*	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {HibernateConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		System.out.println("in getservletconfigclass");
		return  new Class[] {AppConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		System.out.println("in getservlet mapping");
		return new String[] {"/"};
	}*/

	
}
