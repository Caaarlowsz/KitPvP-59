package fr.moderncraft.config;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.moderncraft.main.Main;

public class Config {
	
	private Main main;
	private FileConfiguration fileConfig;
	private Config_Kit configKit;
	private Config_Potion configPotion;
	private ItemStack kitItem;
	
	public Config(Main main){
		this.main = main;
		this.main.saveDefaultConfig();
		fileConfig = this.main.getConfig();
		configPotion = new Config_Potion(this);
		configKit = new Config_Kit(this);
		ItemStack item = new ItemStack(Material.getMaterial(fileConfig.getInt("kititem.id")),1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('$',(fileConfig.getString("kititem.name"))));
		if(fileConfig.isSet("kititem.description")){
			ArrayList<String> list = new ArrayList<String>();
			list.add(ChatColor.translateAlternateColorCodes('$',(fileConfig.getString("kititem.description"))));
			meta.setLore(list);
		}
		item.setItemMeta(meta);
		this.kitItem = item;
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
	
	public Config_Potion getConfigPotion(){
		return configPotion;
	}
	
	public ItemStack getKitItem(){
		return kitItem;
	}
	
	public Main getMain(){
		return main;
	}
}