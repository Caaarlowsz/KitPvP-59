package fr.moderncraft.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.Location;

public class Map_Sql {
	private Main_Sql sql;	
	
	public Map_Sql(Main_Sql sql) {
		this.sql = sql;
	}
	
	public boolean isExist(String name){
		try {
			Statement state = sql.getConn().createStatement();
			ResultSet result;
			result = state.executeQuery("SELECT map FROM maps WHERE map = '"+name+"'");
			return result.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean createMap(String name){
		if(isExist(name)){
			return false;
		}else{
			try {
				Statement state = sql.getConn().createStatement();
				state.executeUpdate("INSERT INTO maps VALUES ('"+name+"')");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
	}
	
	public boolean addSpawnLocation(String map, Location loc){
		if(isExist(map)){
			try {
				Statement state = sql.getConn().createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

}
