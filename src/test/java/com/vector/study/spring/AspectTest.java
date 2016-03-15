package com.vector.study.spring;

import com.vector.study.spring.aspect.PersonFuck;
import com.vector.study.spring.di.UserService;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * author: vector.huang
 * date：2016/3/14 15:56
 */
public class AspectTest {

    private static final String CONFIG_FILE_NAME = "bean-aspect.xml";

    private ApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_FILE_NAME);

    @Before
    public void before(){
    }

    @Test
    public void addTest(){
        PersonFuck fuck = context.getBean(PersonFuck.class);
        int result = fuck.add(1,1);
        System.out.println(result);
    }


}
