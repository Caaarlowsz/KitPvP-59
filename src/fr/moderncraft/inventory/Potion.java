package fr.moderncraft.inventory;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Potion {

	private ItemStack potion;
	private PotionMeta meta;
	private String name;
	private String description;
	
	public Potion(String name){
		this.name = name;
		this.potion = new ItemStack(Material.POTION, 1);
		this.meta = (PotionMeta) potion.getItemMeta();
		this.meta.setDisplayName(name);
	}
	
	public Potion(String name,PotionEffect pe){
		this.potion = new ItemStack(Material.POTION, 1);
		this.meta = (PotionMeta) potion.getItemMeta();
		this.meta.setDisplayName(name);
		setPotionEffect(pe);
	}

	public ItemStack getPotion() {
		potion.setItemMeta(meta);
		return potion;
	}

	private PotionMeta getMeta() {
		return meta;
	}

	public String getName() {
		return name;
	}
	
	public void setPotionEffect(PotionEffect pe){
		getMeta().addCustomEffect(pe, true);
		getMeta().setMainEffect(pe.getType());
	}
	
	public void setDescription(String des){
		ArrayList<String> ar = new ArrayList<String>();
		ar.add(des);
		meta.setLore(ar);
	}
	
}
