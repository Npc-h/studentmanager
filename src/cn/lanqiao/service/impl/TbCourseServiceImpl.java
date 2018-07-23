package cn.lanqiao.service.impl;

import java.util.List;

import cn.lanqiao.dao.TbCourseDao;
import cn.lanqiao.dao.impl.TbCourseDaoImpl;
import cn.lanqiao.model.TbCourse;
import cn.lanqiao.service.TbCourseService;

public class TbCourseServiceImpl implements TbCourseService {
			TbCourseDao td = new TbCourseDaoImpl();
	@Override
	public List<TbCourse> getAllTbCourse() {
		// TODO Auto-generated method stub
		return td.list();
	}

	@Override
	public void insertTbCourse(TbCourse tbcourse) {
		td.insert(tbcourse);
	}

	@Override
	public void removeTbCourse(TbCourse tbcourse) {
		td.remove(tbcourse);

	}

	@Override
	public void updateTbCourse(TbCourse tbcourse) {
		td.update(tbcourse);
	}

}
