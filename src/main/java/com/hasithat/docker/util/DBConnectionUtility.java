package com.hasithat.docker.util;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public class DBConnectionUtility {

	public static Connection getDBConnection() {

		Connection conn = null;
		try {


			Class.forName ("com.mysql.cj.jdbc.Driver").newInstance();
			//conn = DriverManager.getConnection("jdbc:mysql://localhost/school", "root", "root123");
			//Here we can access school database using  mysql container name (app-db) since we have connected both web application and mysql container to a seperate network.
			conn = DriverManager.getConnection("jdbc:mysql://app-db/school", "root", "root123");


			return conn;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private static void log(Object aObject) {
		System.out.println(aObject);
	}
}
