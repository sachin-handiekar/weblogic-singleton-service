package com.sachinhandiekar.service;

import java.util.Date;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import weblogic.cluster.singleton.SingletonService;

public class SingletonServiceEntryPoint implements SingletonService {

    private ApplicationContext context;

    private static final String CLASS_NAME = SingletonServiceEntryPoint.class.getName();

    public void activate() {
        context = new ClassPathXmlApplicationContext("classpath:com/sachinhandiekar/config/beans.xml");

        System.out.println("Context Started At : " + new Date(context.getStartupDate()).toString());

        DataSource ds = (DataSource) context.getBean("dataSource");
        System.out.println("Class : " + ds.getClass().getName());

        System.out.println(CLASS_NAME + " class activated()");
    }

    public void deactivate() {

        ((ClassPathXmlApplicationContext) context).close();
        System.out.println(CLASS_NAME + " class deactivated()");

    }
}
