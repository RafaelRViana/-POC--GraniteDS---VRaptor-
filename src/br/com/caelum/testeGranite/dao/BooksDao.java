package br.com.caelum.testeGranite.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.caelum.testeGranite.model.Book;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class BooksDao 
{

	private final Session session;
	
	public BooksDao(Session session)
	{
		this.session = session;
	}
	
	public List<Book> list()
	{
		return session.createQuery("from Book").list();
	}
	
	public Book save(Book book)
	{
		session.saveOrUpdate(book);
		return book;
	}
	
	public void remove(Book book)
	{
		session.delete(book);
	}
	
}