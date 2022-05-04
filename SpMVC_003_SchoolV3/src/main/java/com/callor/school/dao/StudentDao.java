package com.callor.school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.callor.school.dbconfig.DBConnection;
import com.callor.school.dbconfig.DBContract;
import com.callor.school.domain.StudentVO;

/*
 * Dao 클래스
 * Data Access Object
 * DB와 연동하여 SQL 을 보내고, 데이터를 수신하는 기능 수행한다
 */
public class StudentDao {

	private final Connection dbConn;
	public StudentDao() {
		dbConn = DBConnection.getDBConnection();
	}
	
	public List<StudentVO> selectAll() {
		
		PreparedStatement pStr = null;
		String sql = DBContract.ST.SELECT;
		
		return null;
	}
	
	
	
	
	
}
