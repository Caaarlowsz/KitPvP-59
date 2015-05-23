package fr.moderncraft.config;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashSet;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectTypeWrapper;

import fr.moderncraft.inventory.Potion;

public class Config_Potion {
	private FileConfiguration config;
	private ArrayList<Potion> potionsList;
	private Config config_obj;
	
	public Config_Potion(Config config){
		this.config_obj = config;
		this.config = config.getFileConfig();
		potionsList = createPotions();
	}

	private ArrayList<Potion> createPotions() {
		ArrayList<Potion> potions = new ArrayList<Potion>();
		int i = 1;
		String suf;
		while(config.isSet("potions.potion"+i)){
			suf = "potions.potion"+i;
			Potion potion = new Potion(ChatColor.translateAlternateColorCodes('$',config.getString(suf+".name")));
			PotionEffect pe = new PotionEffect(PotionEffectType.getByName(config.getString(suf+".effect")), config.getInt(suf+".duration"), config.getInt(suf+".level"));
			potion.setPotionEffect(pe);
			if(config.isSet(suf+".description")){
				potion.setDescription(ChatColor.translateAlternateColorCodes('$',config.getString(suf+".description")));
			}
			potions.add(potion);
			i++;
		}
		return potions;
	}
	
	public ItemStack getPotion(int id){
		if(potionsList.get(id-1) != null){
			return potionsList.get(id-1).getPotion();
		}
		return null;
	}
}
