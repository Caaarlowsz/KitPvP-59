package fr.thejulix.kitpvp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_7_R4.Material;
import net.minecraft.server.v1_7_R4.Scoreboard;

import org.apache.logging.log4j.core.Logger;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.libs.org.ibex.nestedvm.util.Seekable.File;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.ScoreboardManager;


public class Main extends JavaPlugin implements Listener {
	
	public String prefixe = ChatColor.BLUE + "[KitPvP] " + ChatColor.RESET;
	
	public String sc = ChatColor.BLUE + "[Staff Channel] ";
		
	public Inventory inv;
	
	private String url0 = this.getConfig().getString("mysql.url");
	private String bdd0 = this.getConfig().getString("mysql.bdd");
	private String url = "jdbc:mysql://" + url0 + "/" + bdd0;
	private String user = this.getConfig().getString("mysql.user");
	private String passwd = this.getConfig().getString("mysql.password");
	private static Connection conn;
	
	public static Connection getConn() {
		return conn;
	}
	
	public void connect(){
		 try 
		  {
		   Class.forName("com.mysql.jdbc.Driver");
		  } catch (ClassNotFoundException e) {
		   e.printStackTrace();
		  }

		  try {
		   conn = DriverManager.getConnection(url, user, passwd);
		   this.getServer().getConsoleSender().sendMessage(prefixe + "Connecte a la base de donnees !");
	            try {
	        	Statement statement = conn.createStatement();
	        	statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + "kitpvp");
	            statement.executeUpdate("CREATE TABLE IF NOT EXISTS " +  "players ("
	            		+"uuid VARCHAR(255) NOT NULL, "
	            		+"kills INT(10) NOT NULL DEFAULT 0, "
	            		+"deaths INT(10) NOT NULL DEFAULT 0, "
	            		+"economie INT(10) NOT NULL DEFAULT 0, "
	            		+"fullkills INT(10) NOT NULL DEFAULT 0);" )  ;
	            } catch (SQLException e) {
	            	e.printStackTrace();
	            }
	           
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
	
	public void loadConfig()
	 {
	  getConfig().options().copyDefaults(true);
	  saveConfig();
	 }
	
	public void onEnable(){
		Bukkit.getServer().getPluginManager().registerEvents( this, this);
		File config = new File(getDataFolder(), "config.yml");
		  if (!config.exists()) {
		loadConfig();
		  } else {
				connect();
				this.getServer().getConsoleSender().sendMessage(prefixe + "La connexion avec la base de donnees SQL a reussi");
		   saveConfig();
		   }
		   Bukkit.getServer().getPluginManager().registerEvents(new inv(this), this);
		   inv = Bukkit.createInventory(null, 54, ChatColor.GOLD + "SELECTIONNE UN KIT" + ChatColor.DARK_BLUE + "       4.0");
		  
	}

	public static Main instance;
	 public static Main getInstance() {
	  return instance;
	 }
	
	public void setupConfig() {}
	
	@EventHandler
	public void onDisconnectedPlayer (PlayerQuitEvent e) {
		Player p = e.getPlayer();
		String d =p.getName();
		e.setQuitMessage(prefixe + ChatColor.RED + " " + d + ChatColor.RESET + " s'est déconnecté.");
		score.resetKill(p);	
	}
		 
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent join){
		Player player = join.getPlayer();
		
		ScoreboardManager manager1 = Bukkit.getScoreboardManager();
	    Scoreboard board1 = manager1.getNewScoreboard();
	    board1.registerNewObjective("showhealth", "health");
	 
	    Objective objective1 = board1.getObjective("showhealth");
	    objective1.setDisplaySlot(DisplaySlot.BELOW_NAME);
	    objective1.setDisplayName("/ 20");
	 
	    for(Player online1 : Bukkit.getOnlinePlayers()){
	        online1.setScoreboard(board1);
	    }
		ItemStack is2 = new ItemStack(getItemStackByID(Material.CHEST, ChatColor.GREEN + "Coffre des Kits " + ChatColor.GRAY + ChatColor.ITALIC + "(Clic Droit)", "Sélectionnez un kit", 1,(short) 0));
		ItemStack is3 = new ItemStack(getItemStackByID(Material.REDSTONE, ChatColor.GREEN + "Stats " + ChatColor.GRAY + ChatColor.ITALIC + "(Clic Droit)", "Affiche vos Stats", 1, (short) 0));
		if(!player.getInventory().contains(Material.CHEST)) {
		player.getInventory().addItem(new ItemStack(is2));
		} else {}
		if(!player.getInventory().contains(Material.REDSTONE)) {
			player.getInventory().addItem(new ItemStack(is3));
		}
		else {}
		try {
			String p = join.getPlayer().getUniqueId().toString();
			
			Connection conn;
			try {
				conn = DriverManager.getConnection(url, user, passwd);
				Statement state = conn.createStatement();
				 state.executeUpdate("INSERT INTO players (players, kills, deaths, economie, TopKill, fullkills) VALUES ('"+p+"', '"+0+"', "+0+", "+0+", "+0+", "+0+")");

			} catch (SQLException e) {}
			
		}catch (IllegalArgumentException e) {
		}
		String d = player.getName();
		if(!player.hasPermission("kitpvp.vanishcon")) {
			join.setJoinMessage(prefixe + ChatColor.AQUA + " " + d + ChatColor.RESET + " s'est connecté.");
		} else {}
	}
		
		

	@EventHandler
	public void OnPlayerRespawn(PlayerRespawnEvent e) {
		Player p = e.getPlayer();
		ItemStack is2 = new ItemStack(getItemStackByID(Material.CHEST, ChatColor.GREEN + "Coffre des Kits " + ChatColor.GRAY + ChatColor.ITALIC + "(Clic Droit)", "Sélectionnez un kit", 1,(short) 0));
		ItemStack is3 = new ItemStack(getItemStackByID(Material.REDSTONE, ChatColor.GREEN + "Stats " + ChatColor.GRAY + ChatColor.ITALIC + "(Clic Droit)", "Affiche vos Stats", 1, (short) 0));

		p.getInventory().addItem(new ItemStack(is2));
		p.getInventory().addItem(new ItemStack(is3));
		score.resetKill(p);
	}
	
			
	public void onDisable(){
		
	}
		
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		String prefixe = ChatColor.BLUE + "[KitPvP] " + ChatColor.RESET;
		String red = ChatColor.DARK_RED + "/kitpvp ";
		
		if (cmd.getName().equalsIgnoreCase("addeco")) {
			Player p = Bukkit.getPlayer(args[0]);
			String u = args[1];
			score.addEcoC(p, u);
			p.sendMessage(prefixe + "Vous avez été crédité de " + u + "mc.");
		}
		Player player = (Player) sender;
		String y = player.getName();
		if (sender instanceof Player) {
			
		if (cmd.getName().equalsIgnoreCase("stats")) {
			if (player.hasPermission("kitpvp.statsother")) {
				if (args.length == 0) {
					score.getStats(player);
				}
				else {
					Player o = Bukkit.getPlayer(args[0]);
					score.getStatsOther(player, o);
				}
		}
			else if (!player.hasPermission("kitpvp.statsother")){
				score.getStats(player);
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("st")) {
				    if (player.hasPermission("kitpvp.st.send")) {
				     if (args.length >= 0) {
				         for (Player staff : Bukkit.getOnlinePlayers()) {
				          if (staff.hasPermission("kitpvp.st.receive")) {
				           StringBuilder message = new StringBuilder();
				           for (int i = 0; i < args.length; i++) {
				            message.append(" ");
				            message.append(args[i]);
				           }
				           staff.sendMessage(sc + ChatColor.DARK_PURPLE + y + ChatColor.BLUE + " :" + message);
				          }
				         }
				     }
				    }
				  return false;
				 }
		}
		if(cmd.getName().equalsIgnoreCase("kitpvp")){
			if((args.length == 0) && (!player.hasPermission("kitpvp.admin"))){
				player.sendMessage(red + "info : Affiche les informations du Plugin.");
			return false;
			}
			else if(args.length == 0 && player.hasPermission("kitpvp.admin")){
				player.sendMessage(red + "info : Affiche les informations du Plugin.");
				player.sendMessage(red + "setkill <pseudo> <valeur> : Set valeur comme Kill");
				player.sendMessage(red + "settopkill <pseudo> <valeur> : Set valeur comme TopKill");
				player.sendMessage(red + "resettop : Reset le top de TOUS les joueurs");
				player.sendMessage(red + "seteco <pseudo> <valeur> : Set valeur comme economie");
				player.sendMessage(red + "addteco <pseudo> <valeur> : Ajoute valeur à l'economie du joueur");
				player.sendMessage(red + "resetdeath : Reset les morts de TOUS les joueurs");
			return false;
			}
			String arg = args[0];
			if(arg.equals("info")){
				player.sendMessage("--------------------------------");
					player.sendMessage(prefixe + "Plugin KitPvP"); 
					player.sendMessage("by TheJulix");
					player.sendMessage("Version : kitpvp 4.0");
					player.sendMessage("Unique propriété de" + ChatColor.GOLD + " Moderncraft");
					player.sendMessage("© Tous droits réservés");
					player.sendMessage("--------------------------------");
			} else if(arg.equals("setkill") && player.hasPermission("kitpvp.admin")) {
				Player p = Bukkit.getPlayer(args[1]);
				String j = args[1];
				String u = args[2];
				score.setKill(p, u);
				player.sendMessage(prefixe + "Vous avez ajouté " + u + " kill(s) à " + j);
				p.sendMessage(prefixe + u + " kills t'ont été ajoutés.");
			} else if (arg.equals("settopkill") && player.hasPermission("kitpvp.admin")) {
				Player p = Bukkit.getPlayer(args[1]);
				String j = args[1];
				String u = args[2];
				score.setTopKill(p, u);
				player.sendMessage(prefixe + "Vous avez ajusté à " + u + " le TopKill de " + j);
				p.sendMessage(prefixe + "Ton TopKill a été ajusté à " + u);
			}else if (arg.equals("resettop") && player.hasPermission("kitpvp.admin")) {
				Player p = (Player) sender;
				score.resetTopKill(p);
				player.sendMessage(prefixe + "Vous avez reset le TopKill de tous les joueurs");
			} else if (arg.equals("seteco") && player.hasPermission("kitpvp.admin")) {
				Player p = Bukkit.getPlayer(args[1]);
				String j = args[1];
				String u = args[2];
				score.setEco(p, u);
				player.sendMessage(prefixe + "Vous avez ajusté à " + u + " l'économie de " + j);
				p.sendMessage(prefixe + "Ton économie a été ajusté à " + u);
			} else if (arg.equals("addeco") && player.hasPermission("kitpvp.admin")) {
				Player p = Bukkit.getPlayer(args[1]);
				String j = args[1];
				String u = args[2];
				score.addEco(p, u);
				player.sendMessage(prefixe + "Vous avez ajouté " + u + " l'économie de " + j);
				p.sendMessage(prefixe + u + "mc t'ont été donnés.");
			} else if (arg.equals("resetdeath") && player.hasPermission("kitpvp.admin")) {
				Player p = (Player) sender;
				score.resetTopKill(p);
				player.sendMessage(prefixe + "Vous avez reset les morts de tous les joueurs");
				
			} else {
			player.sendMessage(red + "La commande n'a pu aboutir : Erreur syntax / La commande n'éxiste pas / Vous n'avez pas la permission.");
			}
		}
		return false;
			} 

	@EventHandler
	public void onPlayerKilled(EntityDeathEvent e) {
		
		if (e.getEntity() instanceof Player) { //Vérifie si l'entité qui meurt est un joueur
			Player p = (Player) e.getEntity(); //Cast l'entité en player (ne jamais faire ça avant de vérifier si c'est un joueur)
				if (e.getEntity().getKiller() instanceof Player) {
					Player killer = (Player) e.getEntity().getKiller();
					int k = score.getKills(killer);
					p.sendMessage(prefixe +"Vous avez été tue par " + killer.getName());
					killer.sendMessage(prefixe + "Vous avez tué " + p.getName());
					killer.sendMessage(prefixe + "Nombre de tués : " + ChatColor.DARK_AQUA + k);
					score.addDeath(p);
					score.addFullKill(killer);
					killer.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, (int) 0.5));
					ParticleEffect.FLAME.display(0.0F, 0.0F, 0.0F, 0.30F, 50, p.getLocation(), 20);
					if(killer.hasPermission("kitpvp.vipp")) {
						score.addEcoVipp(killer);
					} else {
						if(killer.hasPermission("kitpvp.vip")) {
							score.addEcoVip(killer); 
						} else {
							if((!killer.hasPermission("kitpvp.vipp")) && (!killer.hasPermission("kitpvp.vip"))) {
								score.addEcoCita(killer);
							}
						}
					}
}
  }
}
	@EventHandler
	public void onPlayerKilled1(EntityDeathEvent e) {
		if (e.getEntity().getKiller() instanceof Player) {
			Player p = (Player) e.getEntity().getKiller();
			score.addKill(p);
			int k = score.getKills(p);
			int t = score.getTopKill(p);
			if (k > t) {
				String u = Integer.toString(k);
				score.updateTopKill(p, u);
			}
			}
			else{}
	    }
	   

public static ItemStack getItemStackByID(Material m, String name, String lore, int amount, short id){
	ItemStack is = new ItemStack(m,amount,id);
	ItemMeta im = is.getItemMeta();
	im.setDisplayName(name);
	im.setLore(Arrays.asList(lore));
	is.setItemMeta(im);
	return is;
}
}
