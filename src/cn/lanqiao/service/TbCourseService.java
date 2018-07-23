package cn.lanqiao.service;

import java.util.List;

import cn.lanqiao.model.TbCourse;

public interface TbCourseService {
	public List<TbCourse> getAllTbCourse();
	public void insertTbCourse(TbCourse tbcourse);
	public void removeTbCourse(TbCourse tbcourse);
	public void updateTbCourse(TbCourse tbcourse);
}
