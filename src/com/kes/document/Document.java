package com.kes.document;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.kes.database.AccessDatabase;

public abstract class Document {	
	protected static final File databaseFile = new File("KES.accdb");  
	protected static Connection conn = null;
	protected Logger log;	
	
	@SuppressWarnings("static-access")
	public Document() throws SQLException{
		AccessDatabase kms = new AccessDatabase(databaseFile);
		this.conn = kms.getConnection();
	}
	
}
