package com.kes.core;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

import com.kes.article.Article;
import com.kes.character.Symbol;
import com.kes.document.SourceDocument;
import com.kes.document.SymbolDocument;
import com.kes.document.FilteredDocument;

public class ClearSymbolModel extends FunctionModel implements CoreFunctionModel{
	private static String modelName = "Clear Symbol";
	//private List<FilteredArticle> filteredArticle = new ArrayList<FilteredArticle>();
	
	@Override
	public String getFunctionModelName() {
		// TODO Auto-generated method stub
		return modelName;
	}

	@Override
	public void start() throws SQLException {
		// TODO Auto-generated method stub		
		List<Article> articles = SourceDocument.searchAllContent();
		List<Symbol> symbols = SymbolDocument.searchAllSymbol();
		List<Article> filtered = new ArrayList<Article>();
		
		filtered = filterSymbols(articles, symbols);
		
		FilteredDocument.insertDocument(filtered);		
	}

	public List<Article> filterSymbols(List<Article> articles, List<Symbol> symbols){
		List<Thread> threads = new ArrayList<Thread>();
		List<Article> filteredArticles = new ArrayList<Article>();
		
		IntStream.range(0, articles.size()).parallel().forEach(i -> {			
			Runnable run = () -> { filteredArticles.add(cleanSymbols(articles.get(i), symbols)); };
			
			threads.add(new Thread(run));		
		});
				
		log.debug("The source documents have been filtering by back ground program. Please wait a moment.");
		
		Iterator<Thread> it = threads.iterator(); 
		
		IntStream.range(0, threads.size()).parallel().forEach(j -> {			
			it.next().start();

			switch(j){
				case 0 :
					log.debug("Filter the " + (j+1) + "st document now");
				case 1 :
					log.debug("Filter the " + (j+1) + "nd document now");
				case 2 :
					log.debug("Filter the " + (j+1) + "rd document now");
				default :
					log.debug("Filter the " + (j+1) + "th document now");
			}
			
		});
		
		return filteredArticles;
	}
	
	
	public Article cleanSymbols(Article article, List<Symbol> symbols){				
		String id = article.getId();
		String content = new String();
		
		IntStream.range(0, symbols.size()).forEach(i -> {
			String symbol = symbols.get(i).getTerm();			
			article.getContent().replaceAll(symbol, "");				
		});
		
		content = article.getContent().replaceAll(" ", "");										
		return new Article(id,content);
	}
	
}
