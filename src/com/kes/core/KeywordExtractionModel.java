package com.kes.core;

import java.sql.SQLException;

public interface KeywordExtractionModel {
	
	public String getFunctionModelName();
	public void start() throws SQLException;
}
