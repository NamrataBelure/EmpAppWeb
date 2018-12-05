package com.scp.java.app.main;

import javax.servlet.ServletContext;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppinitializer implements WebApplicationInitializer{

	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext cxt=new AnnotationConfigWebApplicationContext();
		cxt.register(AppConfig.class);
		servletContext.addListener(new ContextLoaderListener(cxt));
		ServletRegistration.Dynamic dispatcher=servletContext.addServlet("dispatcher", new DispatcherServlet(cxt));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}

}
