package fr.moderncraft.inventory;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;

public class Potion {

	private ItemStack potion;
	private PotionMeta meta;
	private String name;
	
	public Potion(String name,int amount){
		this.name = name;
		this.potion = new ItemStack(Material.POTION, amount);
		this.meta = (PotionMeta) potion.getItemMeta();
		this.meta.setDisplayName(name);
	}
	
	public Potion(String name,int amount,PotionEffect pe){
		this.name = name;
		this.potion = new ItemStack(Material.POTION, amount);
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
	
}
