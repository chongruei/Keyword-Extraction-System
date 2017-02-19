package com.kes.document;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kes.character.Symbol;

public class SymbolDocument extends Document{
	private final static String tableName = "Symbols";
	private final static String searchAllSymbolSql = "SELECT * FROM " + tableName;
	private static PreparedStatement stmt;
	
	public SymbolDocument() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static List<Symbol> searchAllSymbol() throws SQLException{
		List<Symbol> symbols = new ArrayList<Symbol>();
		
		stmt = conn.prepareStatement(searchAllSymbolSql);		
		ResultSet rs = stmt.executeQuery();

		while(rs.next()){
			Symbol symbol = new Symbol();
			symbol.setTerm(rs.getString("Symbol"));			
			symbol.setPos(rs.getString("Pos"));
			
			symbols.add(symbol);
		}
		
		return symbols;
	}
}
