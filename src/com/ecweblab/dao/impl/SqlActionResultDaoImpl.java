package com.ecweblab.dao.impl;


import java.util.ArrayList;
import java.util.HashMap;
import com.ecweblab.Common.SessionMap;
import com.ecweblab.dao.SqlActionDao;
import com.ecweblab.service.SqlActionResultService;


///----------------------------------
///Date: 2012-8-3
///Author: Derick 
///Memo: 
///----------------------------------
public class SqlActionResultDaoImpl implements SqlActionDao {

	@Override
	public ArrayList<HashMap> getSqlList(String sql) {
		// 这里可以放入缓存了
		ArrayList<HashMap> list = (ArrayList<HashMap>) new SessionMap()
				.get("list");
		if (list == null) {
			list = new SqlActionResultService().getSqlList(sql);
			new SessionMap().set("list", list);
		}
		return list;
	}

	@Override
	public HashMap getObjMap(String sql) {
		HashMap map = (HashMap) new SessionMap().get("objmap");
		if (map == null) {
			map = new SqlActionResultService().getObjMap(sql);
			new SessionMap().set("objmap", map);
		}
		return map;
	}

	@Override
	public int insert(String sql) {
		return  new SqlActionResultService().insert(sql);
	}

	@Override
	public int update(String sql) {
		return  new SqlActionResultService().update(sql);
	}

	@Override
	public int delete(String sql) {
		return  new SqlActionResultService().delete(sql);
	}

}
