package fr.moderncraft.config;

import java.util.HashSet;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.inventory.ItemStack;

import fr.moderncraft.inventory.Kit;

public class Config_Kit {
	private FileConfiguration config;
	private HashSet<Kit> kitList;
	
	public Config_Kit(FileConfiguration config){
		this.config = config;
		kitList = createKits();
	}
	
	private HashSet<Kit> createKits(){
		HashSet<Kit> kits = new HashSet<Kit>();
		int i = 1;
		int j = 1;
		String suf,sufEnch;
		Kit kit;
		while(config.isSet("kits.kit"+i)){
			suf = "kits.kit"+i; 
			kit = new Kit(config.getString(suf+".name"), config.getDouble(suf+".price"), config.getInt(suf+".ranklevel"));
			ItemStack helmet = new ItemStack(Material.getMaterial(config.getInt(suf+".helmet.id")));
			kit.setHelmet(helmet);
			j = 1;
			while(config.isSet(suf+".helmet.enchants.enchant"+j)){
				sufEnch = suf+".helmet.enchants.enchant"+j;
				kit.setHelmetEnchant(EnchantmentWrapper.getByName(config.getString(suf+".effect")), config.getInt(suf+".level"));
				j++;
			}
			ItemStack chestplate = new ItemStack(Material.getMaterial(config.getInt(suf+".chestplate.id")));
			kit.setChestplate(chestplate);
			j = 1;
			while(config.isSet(suf+".chestplate.enchants.enchant"+j)){
				sufEnch = suf+".chestplate.enchants.enchant"+j;
				kit.setChestplateEnchant(EnchantmentWrapper.getByName(config.getString(suf+".effect")), config.getInt(suf+".level"));
				j++;
			}
			ItemStack leggings = new ItemStack(Material.getMaterial(config.getInt(suf+".leggings.id")));
			kit.setLeggings(leggings);
			j = 1;
			while(config.isSet(suf+".leggings.enchants.enchant"+j)){
				sufEnch = suf+".leggings.enchants.enchant"+j;
				kit.setLeggingsEnchant(EnchantmentWrapper.getByName(config.getString(suf+".effect")), config.getInt(suf+".level"));
				j++;
			}
			ItemStack boots = new ItemStack(Material.getMaterial(config.getInt(suf+".boots.id")));
			kit.setBoots(boots);
			j = 1;
			while(config.isSet(suf+".boots.enchants.enchant"+j)){
				sufEnch = suf+".boots.enchants.enchant"+j;
				kit.setBootsEnchant(EnchantmentWrapper.getByName(config.getString(suf+".effect")), config.getInt(suf+".level"));
				j++;
			}
		}
		return kits;
	}
	
}
