package com.bigdata2017.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent)  { 
    	String contextConfigLocation = 
    		servletContextEvent.
    		getServletContext().
    		getInitParameter( "contextConfigLocation" );

    	System.out.println( "Container Starts....." + contextConfigLocation );
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent)  { 
    }
}
