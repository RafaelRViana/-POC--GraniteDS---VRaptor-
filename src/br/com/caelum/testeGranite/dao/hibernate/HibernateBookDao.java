package br.com.caelum.testeGranite.dao.hibernate;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import br.com.caelum.testeGranite.dao.BookDao;
import br.com.caelum.testeGranite.model.Book;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class HibernateBookDao implements BookDao 
{

	private Session session;
	
	public HibernateBookDao(Session session)
	{
		this.session = session;
	}
	
	public List<Book> list()
	{
		List<Book> books = session.createQuery("from Book").list();
		Book one = books.get(0);
		Hibernate.initialize(one);
		System.out.println(one.getAuthors().get(0).getFirstName());
		return books;
	}
	
	@Transactional
	public Book save(Book book)
	{
		session.saveOrUpdate(book);
		return book;
	}

	@Transactional
	public void remove(Book book)
	{
		session.delete(book);
	}
	
}