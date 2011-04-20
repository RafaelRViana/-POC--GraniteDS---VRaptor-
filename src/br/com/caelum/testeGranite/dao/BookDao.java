package br.com.caelum.testeGranite.dao;

import java.util.List;

import br.com.caelum.testeGranite.model.Book;

public interface BookDao 
{

	public List<Book> list();

	public Book save(Book book);

	public void remove(Book book);

}