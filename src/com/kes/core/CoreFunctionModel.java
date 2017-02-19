package com.kes.core;

import java.sql.SQLException;

public interface CoreFunctionModel {
	public String getFunctionModelName();
	public void start() throws SQLException;
}
