package com.ecweblab.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

///----------------------------------
///Date: 2012-8-3
///Author: Derick 
///Memo: 
///----------------------------------
public class DB {
	public static void attemptClose(ResultSet o) {
		try {
			if (o != null)
				o.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void attemptClose(Statement o) {
		try {
			if (o != null)
				o.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void attemptClose(Connection o) {
		try {
			if (o != null)
				o.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private DB() {
	}
}
