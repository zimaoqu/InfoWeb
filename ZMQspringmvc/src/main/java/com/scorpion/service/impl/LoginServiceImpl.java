package com.scorpion.service.impl;

import com.scorpion.dao.adminInfoMapper;
import com.scorpion.pojo.adminInfo;
import com.scorpion.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Scorpion on 2017/8/18.
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private adminInfoMapper adminInfoMapper;

    @Override
    public adminInfo checkLogin(String username, String password) {
        adminInfo admin = adminInfoMapper.findUserByName(username);
        if (admin != null && admin.getPassword().equals(password)) {
            return admin;
        } else {
            return null;
        }
    }
}
