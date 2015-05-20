package fr.moderncraft.config;

import org.bukkit.configuration.file.FileConfiguration;

import fr.moderncraft.main.Main;

public class Config {
	
	private Main main;
	private FileConfiguration fileConfig;
	
	public Config(Main main){
		this.main = main;
		if(this.main.getConfig() == null){
			this.main.saveDefaultConfig();
		}
		fileConfig = this.main.getConfig();
	}
	
	public String getUrl(){
		return fileConfig.getString("url");
	}
	
	public String getUser(){
		return fileConfig.getString("user");
	}
	
	public String getPassw(){
		return fileConfig.getString("passw");
	}
	
	public String getBdd(){
		return fileConfig.getString("bdd");
	}
}
