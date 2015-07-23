package com.jobsukraine.manytomany.unidirectional;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.jobsukraine.Connection;



public class Main {

	public static void main(String[] args) {

		Connection conn = new Connection("root", "admin", "192.168.1.107", "relations");
	    EntityManager em = conn.getManager();
		Service serv = new Service(em);

	    User user = new User("Vasa", 20, "vasa@i.ua");
        User user1 = new User("Peta", 32,"peta@i.ua");
        User user2 = new User("Pipa", 42,"pipa@i.ua");
        User user3 = new User("Mupa", 21,"mupa@i.ua");
	        
        Program office = new Program("Office", 235.0);
        Program photoshop = new Program("PhotoShop", 340.0);
        Program paint = new Program("Paint", 34.0);
        

	        List<User> officeList = new ArrayList<User>();
	        officeList.add(user1);
	        officeList.add(user2);
	        office.setUsers(officeList);
	        
	        List<User> photoShopList = new ArrayList<User>();
	        photoShopList.add(user);
	        photoShopList.add(user2);
	        photoshop.setUsers(photoShopList);
	        
	        List<User> paintList = new ArrayList<User>();
	        paintList.add(user);
	        paintList.add(user1);
	        paintList.add(user3);
	        paint.setUsers(paintList);

	    
	    serv.saveUser(user);
	    serv.saveUser(user1);
	    serv.saveUser(user2);
	    serv.saveUser(user3);
       
	    serv.saveProgram(office);
	    serv.saveProgram(photoshop);
	    serv.saveProgram(paint);

        
	}

}
