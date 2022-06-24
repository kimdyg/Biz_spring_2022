package com.callor.memo.persistance;

import com.callor.memo.model.BBsVO;

public interface BbsDao extends GenericDao<BBsVO, Long> {
	
	public void create_bbs_table();

}
