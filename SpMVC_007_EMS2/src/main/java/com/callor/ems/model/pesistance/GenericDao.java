package com.callor.ems.model.pesistance;

import java.util.List;

public interface GenericDao<VO, PK> {

	public List<VO> SelectAll();
	public VO findById(PK id);
	public int insert(VO vo);
	public int update(VO vo);
	public int delete(PK id);
	
}
