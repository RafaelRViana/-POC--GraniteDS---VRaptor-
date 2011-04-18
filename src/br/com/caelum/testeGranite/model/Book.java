package br.com.caelum.testeGranite.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
	
}