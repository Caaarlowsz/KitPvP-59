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
	private Config config_obj;
	private HashSet<Kit> kitList;
	
	public Config_Kit(Config config){
		this.config = config.getFileConfig();
		this.config_obj = config;
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
				kit.setHelmetEnchant(EnchantmentWrapper.getByName(config.getString(sufEnch+".effect")), config.getInt(sufEnch+".level"));
				j++;
			}
			ItemStack chestplate = new ItemStack(Material.getMaterial(config.getInt(suf+".chestplate.id")));
			kit.setChestplate(chestplate);
			j = 1;
			while(config.isSet(suf+".chestplate.enchants.enchant"+j)){
				sufEnch = suf+".chestplate.enchants.enchant"+j;
				kit.setChestplateEnchant(EnchantmentWrapper.getByName(config.getString(sufEnch+".effect")), config.getInt(sufEnch+".level"));
				j++;
			}
			ItemStack leggings = new ItemStack(Material.getMaterial(config.getInt(suf+".leggings.id")));
			kit.setLeggings(leggings);
			j = 1;
			while(config.isSet(suf+".leggings.enchants.enchant"+j)){
				sufEnch = suf+".leggings.enchants.enchant"+j;
				kit.setLeggingsEnchant(EnchantmentWrapper.getByName(config.getString(sufEnch+".effect")), config.getInt(sufEnch+".level"));
				j++;
			}
			ItemStack boots = new ItemStack(Material.getMaterial(config.getInt(suf+".boots.id")));
			kit.setBoots(boots);
			j = 1;
			while(config.isSet(suf+".boots.enchants.enchant"+j)){
				sufEnch = suf+".boots.enchants.enchant"+j;
				kit.setBootsEnchant(EnchantmentWrapper.getByName(config.getString(sufEnch+".effect")), config.getInt(sufEnch+".level"));
				j++;
			}
			j = 1;
			ItemStack item;
			while(config.isSet(suf+".potions.potion"+j)){
				sufEnch = suf+".potions.potion"+j;
				item = config_obj.getConfigPotion().getPotion(config.getInt(sufEnch+".id"));
				item.setAmount(config.getInt(sufEnch+".amount"));
				kit.addItem(item);
				j++;
			}
			j = 1;
			int k;
			String sufItem;
			while(config.isSet(suf+".items.item"+j)){
				sufItem = suf+".items.item"+j;
				item = new ItemStack(config.getInt(sufItem+".id"), config.getInt(sufItem+".amount"));
				k = 1;
				while(config.isSet(sufItem+".enchants.enchant"+k)){
					sufEnch = sufItem+".enchants.enchant"+k;
					item.addEnchantment(EnchantmentWrapper.getByName(config.getString(sufEnch+".name")), config.getInt(sufEnch+".level"));
				}
				kit.addItem(item);
			}
			
			
		}
		return kits;
	}
	
}
