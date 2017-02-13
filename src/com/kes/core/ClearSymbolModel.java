package com.kes.core;

import java.sql.SQLException;
import java.util.List;

import com.kes.article.Article;
import com.kes.character.Symbol;
import com.kes.document.SourceDocument;
import com.kes.document.SymbolDocument;

public class ClearSymbolModel implements KeywordExtractionModel{
	private static String modelName = "Clear Symbol";
	
	@Override
	public String getFunctionModelName() {
		// TODO Auto-generated method stub
		return modelName;
	}

	@Override
	public void start() throws SQLException {
		// TODO Auto-generated method stub
		List<Article> articles = new SourceDocument().searchAllContent();
		List<Symbol> symbols = new SymbolDocument().searchAllSymbol();
	}

}
