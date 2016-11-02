package com.mingxiu.apptest.data.entity;


import com.mingxiu.apptest.base.BaseEntity;

/**
 * Created by baixiaokang on 16/4/29.
 */
public class _User extends BaseEntity.BaseBean {
    public String username;
    public String password;
    public String face;
    public String sessionToken;

    public _User() {
    }

    public _User(String name, String pass) {
        this.username = name;
        this.password = pass;
    }
}
