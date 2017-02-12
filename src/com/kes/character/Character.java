package com.kes.character;

public abstract class Character {
	
	private String pos 	= ""; 
	private String term	= "";
	
	public String getTerm() {
		return term;
	}
	
	public void setTerm(String term) {
		this.term = term;
	}
	
	public String getPos() {
		return pos;
	}
	
	public void setPos(String pos) {
		this.pos = pos;
	}
	
}
