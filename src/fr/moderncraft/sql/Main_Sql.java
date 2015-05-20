package fr.moderncraft.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main_Sql {
	private Connection connection;
	
	public Main_Sql(String url,String user,String passw,String bdd){
		try{
		   Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		   e.printStackTrace();
		}
		
		try {
			connection = DriverManager.getConnection(url+"/"+bdd, user, passw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		return connection;
	}
}
