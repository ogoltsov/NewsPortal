package com.epam.ogoltsov.servlet;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class SpringContextSingleton {

    private static ClassPathXmlApplicationContext context = null;

    private SpringContextSingleton() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    public static synchronized ClassPathXmlApplicationContext getContext(){
        if (context==null) new SpringContextSingleton();
        return context;
    }
}
