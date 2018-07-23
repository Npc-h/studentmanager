package cn.lanqiao.service;

import java.util.List;

import cn.lanqiao.model.UserMnager;

public interface UserMnagerService {
   public List<UserMnager> getAllusers();
   public void insertUser(UserMnager usermnager);
}
