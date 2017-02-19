package com.kes.database;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDatabaseConnection {

	static final String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
	static final File dbf1 = new File("db/symbol.accdb");
	static final String url1 = dbf1.getAbsolutePath();
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Connection conn = null;
		
		 System.out.println(url1);
		 
		 
		 try {
			 Class.forName(driver);
			 conn = DriverManager.getConnection("jdbc:ucanaccess://" + url1);
			 
			 Statement s = conn.createStatement();
             ResultSet rs = s.executeQuery("SELECT * FROM symbol");
             while (rs.next()) {
            	 System.out.print(rs.getString("id"));
                 System.out.print (rs.getString("symbol"));
                 try {
					String e = new String(rs.getString("symbol").getBytes("Big5"));
					System.out.println(e);
                 } catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
             }
	            				 
			 System.out.println("success");
		 } catch (ClassNotFoundException e1) {
			 System.out.println(e1.getStackTrace());
		 } catch (SQLException e2) {
			 System.out.println(e2.getStackTrace());
		 }
         //Statement s = conn.createStatement();
		
	}

}
