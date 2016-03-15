package com.vector.study.spring;

import com.vector.study.spring.di.UserService;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * author: vector.huang
 * date：2016/3/14 15:12
 */
public class DiTest {

    private static final String CONFIG_FILE_NAME = "bean-di.xml";

    private ApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_FILE_NAME);

    @Before
    public void before(){

    }

    @Test
    public void addTest(){
        UserService service = (UserService) context.getBean("userService");
        service.add();
    }

}
