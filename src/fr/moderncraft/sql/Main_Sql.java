package fr.moderncraft.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.entity.Player;

public class Main_Sql {
	
	private Connection conn;

	public Main_Sql(String url, String user, String passwd, String bdd) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://"+url+"/"+bdd, user, passwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}
	
	public boolean isNewPlayer(Player p){
		Statement state;
		try {
			state = conn.createStatement();
			ResultSet result = state.executeQuery("SELECT player FROM stats WHERE player = '"+p.getUniqueId().toString()+"'");
			if(!result.next()){
				return true;
			}
		} catch (SQLException e) {
		}
		return false;
	}
	
	public void addPlayer(Player p){
		Statement state;
		try {
			state = conn.createStatement();
			state.executeUpdate("INSERT INTO `stats` (`player`, `kills`, `deaths`) VALUES ('"+p.getUniqueId().toString()+"', '0', '0')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
