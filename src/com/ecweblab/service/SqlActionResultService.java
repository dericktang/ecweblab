package com.ecweblab.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import com.ecweblab.dao.SqlActionDao;
import com.ecweblab.db.DB;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class SqlActionResultService implements SqlActionDao {

	@Override
	public ArrayList<HashMap> getSqlList(String sql) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		String[] columns = null;
		try {
			con = new ComboPooledDataSource().getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			ResultSetMetaData metaData = rs.getMetaData();
			int rowCount = metaData.getColumnCount();

			columns = new String[rowCount];
			// 读取字段名到数组
			for (int i = 1; i <= rowCount; i++){
				columns[i - 1] = metaData.getColumnName(i);
				System.out.print(metaData.getColumnName(i)+',');
			}System.out.println();
			HashMap map = new HashMap();
			map.put("total", rowCount);
			list.add(map);
			while (rs.next()) {
				map = new HashMap();
				for (int i = 0; i < rowCount; i++) {
					// System.out.print(rs.getString(i+1) );
					map.put(i, rs.getString(i + 1));
				}
				list.add(map);
			}
			map = null;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.attemptClose(rs);
			DB.attemptClose(stmt);
			DB.attemptClose(con);
		}
		return list;
	}

	@Override
	public HashMap getObjMap(String sql) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String[] columns = null;
		HashMap map = new HashMap();
		try {
			con = new ComboPooledDataSource().getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			ResultSetMetaData metaData = rs.getMetaData();
			int rowCount = metaData.getColumnCount();
			columns = new String[rowCount];
			// 读取字段名到数组
			for (int i = 1; i <= rowCount; i++)
				columns[i - 1] = metaData.getColumnName(i);
			map.put("total", rowCount);
			while (rs.next()) {
				for (int i = 0; i < rowCount; i++) {
					// System.out.print(rs.getString(i+1) );
					map.put(i, rs.getString(i + 1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.attemptClose(rs);
			DB.attemptClose(stmt);
			DB.attemptClose(con);
		}
		return map;
	}

	@Override
	public int insert(String sql) {
		Connection con = null;
		Statement stmt = null;
		int result=0;
		try {
			con = new ComboPooledDataSource().getConnection();
			stmt = con.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.attemptClose(stmt);
			DB.attemptClose(con);
		}
		return result;
	}

	@Override
	public int update(String sql) {
		Connection con = null;
		Statement stmt = null;
		int result=0;
		try {
			con = new ComboPooledDataSource().getConnection();
			stmt = con.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.attemptClose(stmt);
			DB.attemptClose(con);
		}
		return result;
	}

	@Override
	public int delete(String sql) {
		Connection con = null;
		Statement stmt = null;
		int result=0;
		try {
			con = new ComboPooledDataSource().getConnection();
			stmt = con.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.attemptClose(stmt);
			DB.attemptClose(con);
		}
		return result;
	}

}
