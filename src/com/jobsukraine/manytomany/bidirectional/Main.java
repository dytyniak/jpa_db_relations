package com.jobsukraine.manytomany.bidirectional;

import java.util.*;

import javax.persistence.EntityManager;

import com.jobsukraine.Connection;

// I dont have a service yet... I will do it later. 
public class Main {
	public static void main(String[] args) {
		Connection conn = new Connection("root", "admin", "192.168.1.107", "relations");
		EntityManager entitymanager = conn.getManager();
		System.out.println(conn.isConnected());
		entitymanager.getTransaction().begin();

		//create books
		Book puzzlers = new Book();
		puzzlers.setName("Java puzzlers");
		Book hipo = new Book();
		hipo.setName("hipo");

		//create authors
		Author Bloch = new Author();
		Bloch.setName("Joshua");
		Bloch.setLastName("Bloch");
		Author Gafter = new Author();
		Gafter.setName("Neal");
		Gafter.setLastName("Gafter");
		
		// create list of co-autors	+
		ArrayList<Author> autors = new ArrayList<Author>();
		autors.add(Gafter);
		autors.add(Bloch);
		
		// create list of books having same author +
		ArrayList<Book> books = new ArrayList<Book>();
		books.add(puzzlers);
		books.add(hipo);
		
		//send a authors to books
		puzzlers.setAuthors(autors);
		hipo.setAuthors(autors);
		
		//sent a books to authors
		Bloch.setBooks(books);
		Gafter.setBooks(books);
		
		//persist objects
		entitymanager.persist(puzzlers);
		entitymanager.persist(Bloch);
		entitymanager.persist(hipo);
		entitymanager.persist(Gafter);

		entitymanager.getTransaction().commit();
		entitymanager.close();

	}
}
