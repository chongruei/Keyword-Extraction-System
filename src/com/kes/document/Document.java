package com.kes.document;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.kes.dbmanage.AccessDB;
import com.kms.article.Article;

public abstract class Document {	
	protected Connection conn = null;
	
	
	public Document(File dbFile) throws SQLException{
		AccessDB kms = new AccessDB(dbFile);
		this.conn = kms.getConnection();
	}
	
	public abstract Article searchContentById(String id) throws SQLException;
	public abstract List<Article> searchAllContent() throws SQLException;
}
