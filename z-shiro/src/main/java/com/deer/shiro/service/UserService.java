package com.deer.shiro.service;

import com.deer.shiro.config.base.BaseServiceShiro;
import com.deer.shiro.mapper.shiro.UserMapper;
import com.deer.shiro.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseServiceShiro<User,UserMapper> {


}
