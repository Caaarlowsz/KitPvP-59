package fr.moderncraft.config;

import java.util.ArrayList;
import java.util.HashSet;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.entity.Horse.Color;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Colorable;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.Metadatable;

import fr.moderncraft.inventory.Kit;
import fr.moderncraft.inventory.NonKitItem;
import fr.moderncraft.main.Main;

public class Config_Kit {
	private FileConfiguration config;
	private Config config_obj;
	private ArrayList<Kit> kitList;
	private ArrayList<NonKitItem> nonKitItemList; 
	
	public Config_Kit(Config config){
		this.config = config.getFileConfig();
		this.config_obj = config;
		kitList = createKits();
		nonKitItemList = createNonKitItems();
	}
	
	private ArrayList<Kit> createKits(){
		ArrayList<Kit> kits = new ArrayList<Kit>();
		int i = 1;
		int j = 1;
		String suf,sufEnch;
		Kit kit;
		while(config.isSet("kits.kit"+i)){
			suf = "kits.kit"+i; 
			kit = new Kit(ChatColor.translateAlternateColorCodes('$',config.getString(suf+".name")), config.getDouble(suf+".price"), config.getInt(suf+".ranklevel"), config.getInt(suf+".invSlot"));
			ItemStack logo = new ItemStack(Material.getMaterial(config.getInt(suf+".logoItem.id")));
			j = 1;
			if(config.isSet(suf+".description"))
				kit.setDescription(ChatColor.translateAlternateColorCodes('$', config.getString(suf+".description")));
			while(config.isSet(suf+".logoItem.enchants.enchant"+j)){
				sufEnch = suf+".logoItem.enchants.enchant"+j;
				logo.addUnsafeEnchantment(EnchantmentWrapper.getByName(config.getString(sufEnch+".effect")), config.getInt(sufEnch+".level"));
				j++;
			}
			kit.setLogoItem(logo);
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
				if(config.isSet(sufItem+".special")){
					item = config_obj.getMain().getSpecialObject().getItem(config.getString(sufItem+".special"));
					if(config.isSet(sufItem+".amount")){
						item.setAmount(config.getInt(sufItem+".amount"));
					}
				}else{
					item = new ItemStack(config.getInt(sufItem+".id"), config.getInt(sufItem+".amount"));
					k = 1;
					while(config.isSet(sufItem+".enchants.enchant"+k)){
						sufEnch = sufItem+".enchants.enchant"+k;
						item.addUnsafeEnchantment(EnchantmentWrapper.getByName(config.getString(sufEnch+".name")), config.getInt(sufEnch+".level"));
						k++;
					}
				}
				kit.addItem(item);
				j++;
			}
			kits.add(kit);
			i++;
		}
		return kits;
	}
	
	private ArrayList<NonKitItem> createNonKitItems(){
		ArrayList<NonKitItem> list = new ArrayList<NonKitItem>();
		int i = 1;
		String suf;
		ArrayList<String> lore;
		ItemStack item;
		ItemMeta meta;
		while(config.isSet("nonkititems.item"+i)){
			suf = "nonkititems.item"+i;
			if(config.isSet(suf+".data")){
				item = new ItemStack(config.getInt(suf+".id"),1,(short)config.getInt(suf+".data"));
			}else{
				item = new ItemStack(config.getInt(suf+".id"));
			}
			meta = item.getItemMeta();
			if(config.isSet(suf+".name"))
				meta.setDisplayName(config.getString(suf+".name"));
			if(config.isSet(suf+".description")){
				lore = new ArrayList<String>();
				lore.add(config.getString(suf+".description"));
				meta.setLore(lore);
			}
			item.setItemMeta(meta);
			list.add(new NonKitItem(item, config.getInt(suf+".invSlot")));
			i++;
		}
		return list;
	}

	public ArrayList<Kit> getKitList() {
		return kitList;
	}

	public ArrayList<NonKitItem> getNonKitItemList() {
		return nonKitItemList;
	}
	
	public Kit searchKit(ItemStack is) {
		for(Kit kit: kitList){
			if(kit.getLogoItem().equals(is)){
				return kit;
			}
		}
		return null;
	}
	
	
	
}
