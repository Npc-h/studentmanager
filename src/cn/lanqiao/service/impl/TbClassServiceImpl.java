package cn.lanqiao.service.impl;

import java.util.List;

import cn.lanqiao.dao.TbClassDao;
import cn.lanqiao.dao.impl.TbClassDaoImpl;
import cn.lanqiao.model.TbClass;
import cn.lanqiao.service.TbClassService;

public class TbClassServiceImpl implements TbClassService {
			TbClassDao td = new TbClassDaoImpl();
	@Override
	public List<TbClass> getAllTbClass() {
		// TODO Auto-generated method stub
		return td.list();
	}

	@Override
	public void insertTbClass(TbClass tbclass) {
		td.insert(tbclass);

	}

	@Override
	public void removeTbClass(TbClass tbclass) {
		td.remove(tbclass);

	}

	@Override
	public void updateTbClass(TbClass tbclass) {
			td.update(tbclass);
	}

}
