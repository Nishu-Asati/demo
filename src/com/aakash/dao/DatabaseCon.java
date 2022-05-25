package com.aakash.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseCon {
public static Connection getCon()
{
Connection con=null;
try {
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3305/db","root","root");
	
} catch (Exception e) {
	e.printStackTrace();
}
return con;
}
}
