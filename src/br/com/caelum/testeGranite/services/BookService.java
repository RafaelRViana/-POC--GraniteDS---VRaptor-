package br.com.caelum.testeGranite.services;

import java.util.List;

import br.com.caelum.testeGranite.dao.BookDao;
import br.com.caelum.testeGranite.model.Book;
import br.com.caelum.vraptor.Resource;

@Resource
public class BookService 
{

	private final BookDao books;
	
	public BookService(BookDao books)
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