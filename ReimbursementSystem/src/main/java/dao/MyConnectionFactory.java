package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * I've created a utility class that contains static members.
 * 
 * This way the connection create is contained within a single entity. And you
 * can pass it your connections to close the connections; this will assist with
 * allowing us to only have a SINGLE connection for the whole httpRequest.
 */
public class MyConnectionFactory {

	// IF YOU WANT TO USE JDBC WITH A WAR PROJECT YOU NEED TO DO THE FOLLOWING:
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Static block has failed me");
		}
	}
//	/// Environment Variables
	public static String url = "jdbc:postgresql://"
			+System.getenv("DB_URL")+"/"+System.getenv("DB_DBNAME");
	public static String username= System.getenv("DB_USERNAME");
	public static String password=System.getenv("DB_PASSWORD");
	// Actual database
	
	/// H2 Database
	public static String h2url = "jdbc:h2:./h2Data/theData";
	public static String h2username = "sa";
	public static String h2password = "sa";

}