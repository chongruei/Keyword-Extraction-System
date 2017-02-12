package com.kes.dbmanage;

import java.sql.Connection;
import java.sql.SQLException;

public interface Database {		
	Connection getConnection();
	void connect(String fileUrl) throws ClassNotFoundException,SQLException;	
	void connect(String fileUrl, String user, String password) throws ClassNotFoundException,SQLException;
	
	void closeConnection() throws SQLException;
}
