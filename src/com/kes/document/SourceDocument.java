package com.kes.document;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.kes.article.Article;

public class SourceDocument extends Document{
	private final String tableName = "SourceDocument";
	private final String selectAllContentSql 	= "SELECT * FROM " + tableName;	
	private final String selectContentByIdSql = "SELECT * FROM " + tableName + " where id = ?";
	private PreparedStatement stmt;
	private Logger log;
	
	public SourceDocument() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	public Article searchContentById(String id) throws SQLException{
		Article article = null;
		int checkAmount = 0;
		
		stmt = conn.prepareStatement(selectContentByIdSql);
		stmt.setString(1, id);		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()){
			if (checkAmount > 1)
			{
				log.debug("[Amount of article id " + id + " more than one!]");
			}
			checkAmount++;
			article.setId(rs.getString("Id"));
			article.setContent(rs.getString("Content"));
		}

		// TODO Auto-generated method stub
		return article;
	}
	
	public List<Article> searchAllContent() throws SQLException{
		List<Article> articles = null;
		
		stmt = conn.prepareStatement(selectAllContentSql);		
		ResultSet rs = stmt.executeQuery();

		while(rs.next()){
			Article article = null;
			article.setId(rs.getString("Id"));
			article.setContent(rs.getString("Content"));
			
			articles.add(article);
		}
		
		return articles;
	}
}
