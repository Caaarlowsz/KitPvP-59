package fr.moderncraft.inventory;

import java.util.HashSet;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Kit {

	private String name;
	private ItemStack helmet;
	private ItemStack chestplate;
	private ItemStack leggings;
	private ItemStack boots;
	private HashSet<ItemStack> inventory;
	
	
	public Kit(String name){
		this.name = name; 
		this.inventory = new HashSet<ItemStack>();
	}
	
	public Kit(String name, ItemStack helmet, ItemStack chestplate, ItemStack leggings, ItemStack boots){
		this.name = name;
		this.helmet = helmet;
		this.chestplate = chestplate;
		this.leggings = leggings;
		this.boots = boots;
		this.inventory = new HashSet<ItemStack>();
	}
	
	// Getters/Setters
	public ItemStack getHelmet() {
		return helmet;
	}
	public ItemStack getChestplate() {
		return chestplate;
	}
	public ItemStack getLeggings() {
		return leggings;
	}
	public ItemStack getBoots() {
		return boots;
	}
	public String getName(){
		return name;
	}
	public HashSet<ItemStack> getInventory(){
		return inventory;
	}
	
	private void setHelmet(ItemStack helmet) {
		this.helmet = helmet;
	}
	public void setHelmetEnchant(Enchantment e,int level){
		getHelmet().addUnsafeEnchantment(e, level);
	}
	
	private void setChestplate(ItemStack chestplate) {
		this.chestplate = chestplate;
	}
	public void setChestplateEnchant(Enchantment e,int level){
		getChestplate().addUnsafeEnchantment(e, level);
	}
	
	private void setLeggings(ItemStack leggings) {
		this.leggings = leggings;
	}
	public void setLeggingsEnchant(Enchantment e,int level){
		getLeggings().addUnsafeEnchantment(e, level);
	}
	
	private void setBoots(ItemStack boots) {
		this.boots = boots;
	}
	public void setBootsEnchant(Enchantment e,int level){
		getBoots().addUnsafeEnchantment(e, level);
	}
	
	private void setName(String name){
		this.name = name;
	}
	
	public void equipPlayer(Player player){
		player.getInventory().setHelmet(getHelmet());
		player.getInventory().setChestplate(getChestplate());
		player.getInventory().setLeggings(getLeggings());
		player.getInventory().setBoots(getBoots());
		for (ItemStack itemStack : getInventory()) {
			player.getInventory().addItem(itemStack);
		}
	}
	
	
	
	
	
}
