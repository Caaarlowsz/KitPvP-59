package fr.moderncraft.kitpvp;

public class MySQL {
	
	public static String url() {
		return Main.getInstance().getConfig().getString("url");
	}
	
	public static String user() {
		return Main.getInstance().getConfig().getString("user");
	}

	public static String password() {
		return Main.getInstance().getConfig().getString("password");
	}

	public static String bdd() {
		return Main.getInstance().getConfig().getString("bdd");
	}
	
	public static void setConfig() {
		Main.getInstance().getConfig().set("mysql.url", "local");
		Main.getInstance().getConfig().set("mysql.user", "root");
		Main.getInstance().getConfig().set("mysql.password", "Mot_De_Passe");
		Main.getInstance().getConfig().set("mysql.bdd", "KitPvP");
	}

}
