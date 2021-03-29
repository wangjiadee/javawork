package com.ralph.dao;

import com.ralph.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends BaseDao<User> {
    @Override
    public void save() {
        System.out.println("save user for userdao");
    }
}
