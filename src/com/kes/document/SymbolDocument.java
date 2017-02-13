package com.kes.document;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.kes.character.Symbol;

public class SymbolDocument extends Document{
	private final String tableName = "Symbol";
	private final String searchAllSymbolSql = "SELECT * FROM " + tableName;
	private PreparedStatement stmt;
	
	public SymbolDocument() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<Symbol> searchAllSymbol() throws SQLException{
		List<Symbol> symbols = null;
		
		stmt = conn.prepareStatement(searchAllSymbolSql);		
		ResultSet rs = stmt.executeQuery();

		while(rs.next()){
			Symbol symbol = null;
			symbol.setTerm(rs.getString("Term"));			
			symbols.add(symbol);
		}
		
		return symbols;
	}
}
