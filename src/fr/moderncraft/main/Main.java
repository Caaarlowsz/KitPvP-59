package fr.moderncraft.main;

import java.sql.Connection;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectTypeWrapper;

import fr.moderncraft.config.Config;
import fr.moderncraft.sql.Main_Sql;

public class Main extends JavaPlugin{
	
	private Listener listener;
	private Main_Sql sql;
	private Config config;
	
	@Override
	public void onEnable(){
		listener = new Plugin_Listener(this);
		this.getServer().getPluginManager().registerEvents(listener, this);
		this.config = new Config(this);
		sql = new Main_Sql(config.getUrl(), config.getUser(), config.getPassw(),config.getBdd());
	}

	@Override
	public void onDisable(){
		
	}
	
	public boolean onCommand(CommandSender sender,Command cmd, String label, String[] args){
	
		return false;
	}
}
