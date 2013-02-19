package com.ecweblab.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


///----------------------------------
///Date: 2012-8-3
///Author: Derick 
///Memo: 
///----------------------------------
public interface SqlActionDao {
	/**
	 * 查询列表
	 * @param sqlobj
	 * @return
	 */
	public ArrayList<HashMap> getSqlList(String sql)throws SQLException;
	
	/*
	 * 查询对象
	 */
	public HashMap getObjMap(String sql);

	/*
	 * 插入
	 */
	public int insert(String sql);
	
	/*
	 * 更新操作
	 */
	public int update(String sql);
	
	/*
	 * 删除操作
	 */
	public int delete(String sql);
}
