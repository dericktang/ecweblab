package com.ecweblab.db;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

///----------------------------------
///Date: 2012-8-3
///Author: Derick 
///Memo: 
///----------------------------------
public class DBConnection {

	private static DBConnection ds;

	public static Connection getConnection() throws SQLException {
		if (ds == null)
			new DBConnection();
		return ds.getConnection();
	}

}
