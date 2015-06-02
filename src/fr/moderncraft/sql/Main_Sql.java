package fr.moderncraft.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.entity.Player;

public class Main_Sql {
	
	private Connection conn;
	private Map_Sql map;

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
		map = new Map_Sql(this);

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
	
	public int getKills(Player p){
		Statement state;
		try {
			state = conn.createStatement();
			ResultSet result = state.executeQuery("SELECT kills FROM stats WHERE player = '"+p.getUniqueId().toString()+"'");
			result.next();
			return result.getInt("kills");
		} catch (SQLException e) {
		}
		return 0;
	}
	
	public int getDeaths(Player p){
		Statement state;
		try {
			state = conn.createStatement();
			ResultSet result = state.executeQuery("SELECT death FROM stats WHERE player = '"+p.getUniqueId().toString()+"'");
			result.next();
			return result.getInt("death");
		} catch (SQLException e) {
		}
		return 0;
	}
	
	public void playerKilled(Player p){
		Statement state;
		String uuid = p.getUniqueId().toString();
		int score = p.getScoreboard().getObjective("stats").getScore("kills").getScore();
		try {
			state = conn.createStatement();
			state.executeUpdate("UPDATE stats SET kills = "+getKills(p)+score+" WHERE player = '"+uuid+"'");
			state.executeUpdate("UPDATE stats SET death = "+getDeaths(p)+1+" WHERE player = '"+uuid+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Map_Sql getMap() {
		return map;
	}
	
	public Connection getConn() {
		return conn;
	}

}
