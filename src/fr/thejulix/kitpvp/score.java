package fr.thejulix.kitpvp;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.entity.Player;

public class score {

	private static Connection conn = Main.getConn();
	
	public static int getKills(Player p) {
	 int kill = 0;
	 try {
	 String uuid = p.getUniqueId().toString();
	 Statement state = conn.createStatement();
	 ResultSet rs = state.executeQuery("SELECT kills FROM players WHERE players = '"+uuid+"'");
	 rs.next();
	 kill = rs.getInt("kills");
	} catch (IllegalArgumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return kill;
	}
 
 public static int getFullKills(Player p) {
	 int fullkills = -1;
	 try {
		 String uuid = p.getUniqueId().toString();
		 Statement state = conn.createStatement();
		 ResultSet rs = state.executeQuery("SELECT fullkills FROM players WHERE players = '"+uuid+"'");
		 rs.next();
		 fullkills = rs.getInt("fullkills");
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return fullkills;
	}


 public static void getStats(Player p) {
	String stat = ChatColor.YELLOW + "";
	int d = getDeaths(p);
	int k = getTopKill(p);
	int e = getEco(p);
	int f = getFullKills(p);
	float r = (float)(getRatio(p));
	
	String player = p.getName();
	p.sendMessage("---------------------------------------");
	p.sendMessage(stat + "Pseudo :        " + ChatColor.DARK_AQUA + player);
	p.sendMessage(stat + "TopKill :          " + ChatColor.DARK_AQUA + k);
	p.sendMessage(stat + "Morts :           " + ChatColor.DARK_AQUA + d);
	p.sendMessage(stat + "Total Kill :       " + ChatColor.DARK_AQUA + f);
	p.sendMessage(stat + "Ratio :          " + ChatColor.DARK_AQUA + r);
	p.sendMessage(stat + "Argent :         " + ChatColor.DARK_AQUA + e + ChatColor.GREEN + "mc");
	p.sendMessage("---------------------------------------");
	return;
	}
 
 public static void getStatsOther(Player p, Player o) {
	 String stat = ChatColor.YELLOW + "";
	int d = getDeaths(o);
	int k = getTopKill(o);
	int e = getEco(o);
	int f = getFullKills(o);
	float r = (float)(getRatio(o));
	
	String player = o.getName();
	p.sendMessage("---------------------------------------");
	p.sendMessage(stat + "Pseudo :        " + ChatColor.DARK_AQUA + player);
	p.sendMessage(stat + "TopKill :          " + ChatColor.DARK_AQUA + k);
	p.sendMessage(stat + "Morts :           " + ChatColor.DARK_AQUA + d);
	p.sendMessage(stat + "Total Kill :       " + ChatColor.DARK_AQUA + f);
	p.sendMessage(stat + "Ratio :          " + ChatColor.DARK_AQUA + r);
	p.sendMessage(stat + "Argent :         " + ChatColor.DARK_AQUA + e + ChatColor.GREEN + "mc");
	p.sendMessage("---------------------------------------");
	return;
	}
 
 public static int getDeaths(Player p) {
	 int deaths = -1;
	 try {
		 String uuid = p.getUniqueId().toString();
		 Statement state = conn.createStatement();
		 ResultSet rs = state.executeQuery("SELECT deaths FROM players WHERE players = '"+uuid+"'");
		 rs.next();
		 deaths = rs.getInt("deaths");
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return deaths;
	}
 
 public static int getEco(Player p) {
	 int economie = -1;
	 try {
		 String uuid = p.getUniqueId().toString();
		 Statement state = conn.createStatement();
		 ResultSet rs = state.executeQuery("SELECT economie FROM players WHERE players = '"+ uuid +"'");
		 rs.next();
		 economie = rs.getInt("economie");
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return economie;
	}
 
 public static int getTopKill(Player p) {
	 int TopKill = -1;
	 try {
		 String uuid = p.getUniqueId().toString();
		 Statement state = conn.createStatement();
		 ResultSet rs = state.executeQuery("SELECT TopKill FROM players WHERE players = '" +uuid+"'");
		 rs.next();
		 TopKill = rs.getInt("TopKill");
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return TopKill;
	}
 
 public static double getRatio(Player p) {
  if (getDeaths(p) > 0) {
	  double ratio = Math.round(((double)getFullKills(p)/(double)getDeaths(p)) * 100.0D) / 100.0D;
   //float ratio = getFullKills(p) / getDeaths(p);
   //ratio=(float)((int)(ratio*100))/100;
  // ratio *= 100;
  // Math.round(ratio);
  // ratio /= 100;
   return ratio;
  }
  else {
   return 0;
  }
 }



 public static void setKill(Player p, String k) {
		try {
			 String uuid = p.getUniqueId().toString();
			 Statement state = conn.createStatement();
			 String sql = "UPDATE players SET kills = '"+k+"' WHERE players = '" +uuid+"'";
			 state.executeUpdate(sql);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
 
 public static void setEco(Player p, String k) {
	 try {
		 String uuid = p.getUniqueId().toString();
		 Statement state = conn.createStatement();
		 String sql = "UPDATE players SET economie = '"+k+"' WHERE players = '" +uuid+"'";
		 state.executeUpdate(sql);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }
 
 public static void addKill(Player p) {
	 int k = getKills(p) + 1;
	 try {
		 String uuid = p.getUniqueId().toString();
		 Statement state = conn.createStatement();
		 String sql = "UPDATE players SET kills = '"+k+"' WHERE players = '" +uuid+"'";
		 state.executeUpdate(sql);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }
 
 public static void addFullKill(Player p) {
	 int k = getFullKills(p) + 1;
	 try {
		 String uuid = p.getUniqueId().toString();
		 Statement state = conn.createStatement();
		 String sql = "UPDATE players SET fullkills = '"+k+"' WHERE players = '" +uuid+"'";
		 state.executeUpdate(sql);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }

public static void addDeath(Player p) {
	int k = getDeaths(p) + 1;
	 try {
		 String uuid = p.getUniqueId().toString();
		 Statement state = conn.createStatement();
		 String sql = "UPDATE players SET deaths = '"+k+"' WHERE players = '" +uuid+"'";
		 state.executeUpdate(sql);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }

public static void addEco(Player p, String v) {
	int k = getEco(p) + Integer.valueOf(v);
	 try {
		 String uuid = p.getUniqueId().toString();
		 Statement state = conn.createStatement();
		 String sql = "UPDATE players SET economie = '"+k+"' WHERE players = '" +uuid+"'";
		 state.executeUpdate(sql);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }

public static void addEcoC(Player p, String v) {
	int k = getEco(p) + Integer.valueOf(v);
	 try {
		 String uuid = p.getUniqueId().toString();
		 Statement state = conn.createStatement();
		 String sql = "UPDATE players SET economie = '"+k+"' WHERE players = '" +uuid+"'";
		 state.executeUpdate(sql);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }

public static void addEcoCita(Player p) {
	int k = getEco(p) + 10;
	 try {
		 String uuid = p.getUniqueId().toString();
		 Statement state = conn.createStatement();
		 String sql = "UPDATE players SET economie = '"+k+"' WHERE players = '" +uuid+"'";
		 state.executeUpdate(sql);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }

public static void addEcoVip(Player p) {
	int k = getEco(p) + 15;
	 try {
		 String uuid = p.getUniqueId().toString();
		 Statement state = conn.createStatement();
		 String sql = "UPDATE players SET economie = '"+k+"' WHERE players = '" +uuid+"'";
		 state.executeUpdate(sql);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }

public static void addEcoVipp(Player p) {
	int k = getEco(p) + 20;
	 try {
		 String uuid = p.getUniqueId().toString();
		 Statement state = conn.createStatement();
		 String sql = "UPDATE players SET economie = '"+k+"' WHERE players = '" +uuid+"'";
		 state.executeUpdate(sql);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }


 public static void setTopKill(Player p, String k) {
	 try {
		 String uuid = p.getUniqueId().toString();
		 Statement state = conn.createStatement();
		 String sql = "UPDATE players SET TopKill = '"+k+"' WHERE players = '" +uuid+"'";
		 state.executeUpdate(sql);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }
 
 public static void setNick(Player p, String k) {
	 try {
		 String uuid = p.getUniqueId().toString();
		 Statement state = conn.createStatement();
		 String sql = "UPDATE playersSET nick = '"+k+"' WHERE players = '" +uuid+"'";
		 state.executeUpdate(sql);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }
 
 public static void setNickDefault(Player p) {
	 String k = p.getName();
	 try {
		 String uuid = p.getUniqueId().toString();
		 Statement state = conn.createStatement();
		 String sql = "UPDATE players SET nick = '"+k+"' WHERE players = '" +uuid+"'";
		 state.executeUpdate(sql);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }
 
 public static void updateTopKill(Player p, String k) {
	 try {
		 String uuid = p.getUniqueId().toString();
		 Statement state = conn.createStatement();
		 String sql = "UPDATE players SET TopKill = '"+k+"' WHERE players = '" +uuid+"'";
		 state.executeUpdate(sql);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }
 
 public static void resetTopKill(Player p) {
	 try {
		 String uuid = p.getUniqueId().toString();
		 Statement state = conn.createStatement();
		 String sql = "UPDATE players SET TopKill = 0 WHERE players = '" +uuid+"'";
		 state.executeUpdate(sql);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }

 public static void resetDeath(Player p) {
	 try {
		 Statement state = conn.createStatement();
		 String sql = "UPDATE players SET deaths = 0";
		 state.executeUpdate(sql);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }
 
 public static void resetKill(Player p) {
	 try {
		 Statement state = conn.createStatement();
		 String sql = "UPDATE players SET kills = 0";
		 state.executeUpdate(sql);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }

 public static void resetStats(Player p) {
  Main.getInstance().getConfig().set("Stats." + p.getName() + ".kills", 0);
  Main.getInstance().getConfig().set("Stats." + p.getName() + ".deaths", 0);
  Main.getInstance().getConfig().set("Stats." + p.getName() + ".killstreak", 0);
  Main.getInstance().getConfig().set("Stats." + p.getName() + ".bestkillstreak", 0);
  Main.getInstance().saveConfig();
 }

 public static String playerData(Player p) {
  if (Main.getInstance().getConfig().getString("Stats." + p.getName()) != null) {
   return Main.getInstance().getConfig().getString("Stats." + p.getName());
  }
  else {
   return "§cCe joueur n'existe pas";
  }
 }
}