package cn.lanqiao.service.impl;

import java.util.List;

import cn.lanqiao.dao.UserMnagerDao;
import cn.lanqiao.dao.impl.UserMnagerDaoImpl;
import cn.lanqiao.model.UserMnager;
import cn.lanqiao.service.UserMnagerService;

public class UserMnagerServiceImpl implements UserMnagerService {
		UserMnagerDao um = new UserMnagerDaoImpl();
	@Override
	public List<UserMnager> getAllusers() {
		return um.list();
	}
	@Override
	public void insertUser(UserMnager usermnager) {
		um.insert(usermnager);
	}

}
