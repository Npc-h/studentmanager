package cn.lanqiao.service.impl;

import java.util.List;

import cn.lanqiao.dao.TbStudentDao;
import cn.lanqiao.dao.impl.TbStudentDaoImpl;
import cn.lanqiao.model.TbStudent;
import cn.lanqiao.service.TbStudentService;

public class TbStudentServiceImpl implements TbStudentService {
	TbStudentDao td = new TbStudentDaoImpl();
	@Override
	public List<TbStudent> getAllTbStudent() {
		return td.list();
	}

	@Override
	public void insertTbStudent(TbStudent tbstudent) {
		td.insert(tbstudent);
	}

	@Override
	public void removeTbStudent(TbStudent tbstudent) {
		td.remove(tbstudent);
	}

	@Override
	public void updateTbStudent(TbStudent tbstudent) {
		td.update(tbstudent);
	}

	@Override
	public List<TbStudent> getvaguaSearch(String name) {
		return td.vaguaSearch(name);
	}

}
