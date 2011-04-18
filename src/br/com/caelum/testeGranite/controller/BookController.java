package br.com.caelum.testeGranite.controller;

import java.util.List;

import br.com.caelum.testeGranite.dao.BooksDao;
import br.com.caelum.testeGranite.model.Book;
import br.com.caelum.vraptor.Resource;

@Resource
public class BookController 
{

	private final BooksDao books;
	
	public BookController(BooksDao books)
	{
		this.books = books;
	}
	
	public List<Book> list()
	{
		return books.list();
	}
	
	public Book save(Book book)
	{
		return books.save(book);
	}
	
	public void remove(Book book)
	{
		books.remove(book);
	}
	
}