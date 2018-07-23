package cn.lanqiao.service;

import java.util.List;

import cn.lanqiao.model.TbClass;

public interface TbClassService {
	public List<TbClass> getAllTbClass();
	public void insertTbClass(TbClass tbclass);
	public void removeTbClass(TbClass tbclass);
	public void updateTbClass(TbClass tbclass);
}
