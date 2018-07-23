package cn.lanqiao.service.impl;

import java.util.List;

import cn.lanqiao.dao.TbScoreDao;
import cn.lanqiao.dao.impl.TbScoreDaoImpl;
import cn.lanqiao.model.TbScore;
import cn.lanqiao.service.TbScoreService;

public class TbScoreServiceImpl implements TbScoreService {
	TbScoreDao  td = new TbScoreDaoImpl();
	@Override
	public List<TbScore> getAllTbScore() {
		// TODO Auto-generated method stub
		return td.list();
	}

	@Override
	public void insertTbScore(TbScore tbscore) {
		td.insert(tbscore);
	}

	@Override
	public void removeTbScore(TbScore tbscore) {
		// TODO Auto-generated method stub
		td.remove(tbscore);
	}

	@Override
	public void updateTbScore(TbScore tbscore) {
		// TODO Auto-generated method stub
			td.update(tbscore);
	}

}
