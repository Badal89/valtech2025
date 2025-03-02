package com.valtech.training.first.entities;
 
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
 
@Entity
public class Author {
 
	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "authorseq")
	@SequenceGenerator(name = "authorseq",sequenceName ="author_seq",allocationSize = 1)
	private long id;
	private String name;
	private String address;
	
	@ManyToMany(targetEntity = Book.class,mappedBy  = "authors")
	private Set<Book> books;
	
	
	public Author() {}
	public Author(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	
	
	
	
	
}
 
 