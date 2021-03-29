package com.ralph.service;

import com.ralph.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T> {

    @Autowired
    BaseDao<T> baseDao;

    public void save(){
        baseDao.save();
    }
}
