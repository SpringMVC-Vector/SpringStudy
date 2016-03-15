package com.vector.study.spring.di;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * author: vector.huang
 * date：2016/3/14 15:01
 */
public class BaseService<T> {

    @Resource(name = "user2Dao")
    private BaseDao<T> baseDao;

    public void add(){
        System.out.println("add ... ");
        System.out.println(baseDao);
    }

}
