package com.epam.ogoltsov.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        SpringContextSingleton.getContext();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
