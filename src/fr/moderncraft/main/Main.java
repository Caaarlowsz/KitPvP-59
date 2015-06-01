package fr.moderncraft.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectTypeWrapper;

import fr.moderncraft.config.Config;
import fr.moderncraft.inventory.Kit;
import fr.moderncraft.inventory.KitInventory;
import fr.moderncraft.inventory.SpecialObject;
import fr.moderncraft.sql.Main_Sql;

public class Main extends JavaPlugin{
	
	private Listener listener;
	private Main_Sql sql;
	private Config config;
	private KitInventory kitInventory;
	private SpecialObject specialObject;

	@Override
	public void onEnable(){
		this.specialObject = new SpecialObject();
		this.config = new Config(this);
		listener = new Plugin_Listener(this);
		this.getServer().getPluginManager().registerEvents(listener, this);
		this.kitInventory = new KitInventory(this);
		sql = new Main_Sql("localhost", "root", "","kitpvp");
	}

	@Override
	public void onDisable(){
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(label.equalsIgnoreCase("kitpvp")){
			Player player = null;
			if(sender instanceof Player){
				player = (Player)sender;
			}else{
				return false;
			}
			if(args[0].equalsIgnoreCase("kit")){
				config.getConfigKit().getKitList().get(Integer.parseInt(args[1])-1).equipPlayer(player);
				return true;
			}else{
				player.sendMessage("Commande fausse");
			}
		}
		return false;
	}
	
	public Config getConfiguration(){
		return config;
	}
	
	public KitInventory getKitInventory() {
		return kitInventory;
	}

	public SpecialObject getSpecialObject() {
		return specialObject;
	}

	public Main_Sql getSql() {
		return sql;
	}
}
