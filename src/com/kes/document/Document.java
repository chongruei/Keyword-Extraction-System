package com.kes.document;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

import com.kes.database.AccessDatabase;

public abstract class Document {	
	protected static final File databaseFile = new File("KES.accdb");  
	protected Connection conn = null;
		
	public Document() throws SQLException{
		AccessDatabase kms = new AccessDatabase(databaseFile);
		this.conn = kms.getConnection();
	}
	
}
