package com.kes.character;

public abstract class Character {
	protected String pos 	= ""; 
	protected String term	= "";
		
	public abstract String getTerm();	
	public abstract void setTerm(String term);	
	public abstract String getPos();	
	public abstract void setPos(String pos);
}
