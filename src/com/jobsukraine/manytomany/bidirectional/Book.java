package com.jobsukraine.manytomany.bidirectional;


import java.util.List;


import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	public Book() {
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

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "books")
	private List<Author> autors;
	
	public List<Author> getAuthors() {
		return autors;
	}

	public void setAuthors(List<Author> autors) {
		this.autors = autors;
	}
}