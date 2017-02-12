package com.kes.dbmanage;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class AccessDB implements Database{
	private String driver 	= "jdbc:ucanaccess://";
	private Connection conn = null;
	Logger log = Logger.getLogger(AccessDB.class);
	
	public AccessDB(File dbFile){
		try {
			connect(dbFile.getAbsolutePath());
			log.info("[DB connect successful][" + dbFile.getName() + "]");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			log.error("[Class Not Found][" + AccessDB.class.getClass().getName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error("[DB connect failure][" + dbFile.getName() + "]");
		}
	}
		
	@Override
	public Connection getConnection(){
		return this.conn;
	}
	
	@Override
	public void connect(String fileUrl) throws ClassNotFoundException,SQLException {
		// TODO Auto-generated method stub		
		 Class.forName(driver);
		 this.conn = DriverManager.getConnection(driver + fileUrl);
	}
	
	@Override
	public void connect(String fileUrl, String user, String password) throws ClassNotFoundException,SQLException {
		// TODO Auto-generated method stub		
		 Class.forName(driver);
		 this.conn = DriverManager.getConnection(driver + fileUrl,user,password);
	}
	
	@Override
	public void closeConnection() throws SQLException{
		this.conn.close();
	}

}
