package com.epam.ogoltsov.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class SpringContextSingleton {

    private static final String SPRING_CONTEXT_INIT = "Spring context init";
    private static final String GET_SPRING_CONTEXT = "Get spring context";
    private static ClassPathXmlApplicationContext context = null;
    private static final Logger log = LoggerFactory.getLogger(SpringContextSingleton.class);


    private SpringContextSingleton() {
//        context = new ClassPathXmlApplicationContext("WEB-INF/applicationContext.xml");
        log.debug(SPRING_CONTEXT_INIT);
    }

    public static synchronized ClassPathXmlApplicationContext getContext(){
        if (context==null) new SpringContextSingleton();
        log.debug(GET_SPRING_CONTEXT);
        return context;
    }
}
