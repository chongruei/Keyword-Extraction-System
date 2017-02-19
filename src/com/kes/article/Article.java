package com.kes.article;

public class Article {
	private String id;
	private String content;
	private int sequence;
	
	public Article(){		
	}
	
	public Article(String id, String content){
		this.id = id;
		this.content = content;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	

}
