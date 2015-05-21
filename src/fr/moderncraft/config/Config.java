package fr.moderncraft.config;

import org.bukkit.configuration.file.FileConfiguration;

import fr.moderncraft.main.Main;

public class Config {
	
	private Main main;
	private FileConfiguration fileConfig;
	private Config_Kit configKit;
	private Config_Potion configPotion;
	
	public Config(Main main){
		this.main = main;
		if(this.main.getConfig() == null){
			this.main.saveDefaultConfig();
		}
		fileConfig = this.main.getConfig();
		configPotion = new Config_Potion(this.getFileConfig());
		configKit = new Config_Kit(this.fileConfig);
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
	
	public Config_Kit getConfigKit(){
		return configKit;
	}
	
	public FileConfiguration getFileConfig(){
		return fileConfig;
	}
}
