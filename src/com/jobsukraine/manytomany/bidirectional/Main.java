package com.jobsukraine.manytomany.bidirectional;

import com.jobsukraine.Connection;

public class Main {
	public static void main(String[] args) {
		Connection conn = new Connection("root", "admin", "192.168.1.107", "relations");
		System.out.println(conn.isConnected());
	} 
}
