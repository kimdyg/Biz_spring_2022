package com.callor.memo.dao;

import com.callor.memo.vo.MemoVO;

public interface MemoDao extends GenericDao<MemoVO, Integer>{
	
	public void create_memo_table();

}
