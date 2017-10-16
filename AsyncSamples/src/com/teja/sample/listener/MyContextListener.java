package com.teja.sample.listener;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyContextListener
 *
 */
@WebListener
public class MyContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MyContextListener() {
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent event)  { 
    	System.out.println("Context destroyed");
    	ExecutorService executor = (ExecutorService) event.getServletContext().getAttribute("executor");
    	executor.shutdown();
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
    	System.out.println("Context intialized");
    	ExecutorService executor = Executors.newCachedThreadPool();
    	event.getServletContext().setAttribute("executor", executor);
    	System.out.println(executor);
    }
	
}
