package com.vector.study.spring;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * author: vector.huang
 * date：2016/3/15 10:07
 */
public class C3P0Test {


    private static final String CONFIG_FILE_NAME = "bean-c3p0.xml";
    private ApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_FILE_NAME);
    private JdbcTemplate jdbcTemplate;

    {
        jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
    }

    @Before
    public void before(){
    }

    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSources = context.getBean(DataSource.class);
        System.out.println(dataSources);
        System.out.println(dataSources.getConnection());
    }

    @Test
    public void testUpdate(){
        String sql = "UPDATE User SET password = ? WHERE id = ?";
        int result = jdbcTemplate.update(sql, "Jack", 1);
        System.out.println(result);
    }

}
