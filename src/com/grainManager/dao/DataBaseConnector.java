package com.grainManager.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBaseConnector {
	String[] tableNames = { "ss_mandi_customer_master",
			"ss_mandi_dealer_master" };

	String ss_mandi_customer_master = "create table ss_mandi_customer_master(customer_id INTEGER PRIMARY KEY AUTOINCREMENT, customer_code varchar(40) NOT NULL UNIQUE, first_name varchar(100) NOT NULL, last_name varchar(100) NOT NULL, mobile_no char(12) NOT NULL, email_id varchar(30) NULL, location_id int NOT NULL, registration_date	DATETIME NOT NULL, status CHECK( status IN ('ACTIVE','INACTIVE','TERMINATE') ) NOT NULL DEFAULT 'ACTIVE', termination_date	DATETIME NOT NULL) ";
	String ss_mandi_dealer_master = "create table ss_mandi_dealer_master(dealer_id INTEGER PRIMARY KEY AUTOINCREMENT, firm_name varchar(200) NOT NULL, proprieter_name varchar(200) NOT NULL, tin_no varchar(50) NOT NULL UNIQUE, contact_no varchar(12) NOT NULL, email_id varchar(50), address varchar(200), location_id INTEGER, registration_date	DATETIME NOT NULL, status TEXT CHECK( status IN  ('ACTIVE','INACTIVE','TERMINATE') ) NOT NULL DEFAULT 'ACTIVE', termination_date DATETIME)";

	String[] tableQueries = { ss_mandi_customer_master, ss_mandi_dealer_master };

	public boolean createTable() {
		boolean isSuccess = false;

		Statement stmt = null;
		Connection conn = null;
		conn = getSqlLiteConnection();

		DatabaseMetaData dbMetaDat = null;
		ResultSet res = null;
		if (conn != null) {
			try {
				stmt = conn.createStatement();
				dbMetaDat = conn.getMetaData();

				for (int iLoop = 0; iLoop < tableNames.length; iLoop++) {
					res = dbMetaDat.getTables(null, null, tableNames[iLoop],
							null);

					if (res.next()) {
						System.out.println(tableNames[iLoop] + " Exists");
					} else {
						System.out.println(tableNames[iLoop]
								+ " Doesn't Exists");
						stmt.executeUpdate(tableQueries[iLoop]);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return isSuccess;
	}

	private Connection getSqlLiteConnection() {
		String dataBaseName = "grainManager.db";
		Connection conn = null;

		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:" + dataBaseName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
