package com.jobsukraine.manytomany.bidirectional;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "author")
public class Author {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "last_name")
	private String lastName;

	public Author() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@ManyToMany
	@JoinTable(name = "author_book", 
	joinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id") , 
	inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id") )
	private List<Book> books;

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}