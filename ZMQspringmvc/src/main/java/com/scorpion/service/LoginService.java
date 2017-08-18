package com.scorpion.service;

import com.scorpion.pojo.adminInfo;

/**
 * Created by Scorpion on 2017/8/18.
 */
public interface LoginService {
    public adminInfo checkLogin(String username, String password);
}
