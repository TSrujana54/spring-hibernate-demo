package com.stackroute.spring.hibernate.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//web.xml file
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	//bean configuration classes
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {ApplicationConfig.class};
    }

    //dispatcher-servlet.xml
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { MyWebConfig.class };
    }

    //url mapping
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

}