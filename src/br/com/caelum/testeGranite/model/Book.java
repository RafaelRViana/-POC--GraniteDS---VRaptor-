package br.com.caelum.testeGranite.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Book 
{
	
	@Deprecated
	public Book() { } //Required by Hibernate
	
	public Book(String title)
	{
		this.title = title;
	}
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String title;

	@OneToMany(mappedBy="book", fetch=FetchType.LAZY, cascade=CascadeType.ALL) 
	private List<Author> authors;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public List<Author> getAuthors() {
		return authors;
	}
	
}