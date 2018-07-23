package cn.lanqiao.dao;

import java.util.List;

import cn.lanqiao.model.UserMnager;

public interface UserMnagerDao {
	//查询所有用户
	public List<UserMnager> list();
	//增加用户
	public void insert(UserMnager usermnager);
}
