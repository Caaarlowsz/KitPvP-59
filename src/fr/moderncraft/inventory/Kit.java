package fr.moderncraft.inventory;

import java.util.HashSet;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Kit {

	private String name;
	private double price;
	private int rankLevel;
	private int invSlot;
	private ItemStack logoItem;
	private ItemStack helmet;
	private ItemStack chestplate;
	private ItemStack leggings;
	private ItemStack boots;
	private HashSet<ItemStack> inventory;
	
	
	public Kit(String name,double price,int rankLevel,int invSlot){
		this.name = name; 
		this.price = price;
		this.rankLevel = rankLevel;
		this.invSlot = invSlot;
		this.inventory = new HashSet<ItemStack>();
	}
	
	public Kit(String name, double price, int rankLevel,int invSlot,ItemStack logoItem, ItemStack helmet, ItemStack chestplate, ItemStack leggings, ItemStack boots){
		this.name = name;
		this.price = price;
		this.rankLevel = rankLevel;
		this.helmet = helmet;
		this.chestplate = chestplate;
		this.leggings = leggings;
		this.boots = boots;
		this.logoItem = logoItem;
		this.invSlot = invSlot;
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
	public double getPrice() {
		return price;
	}

	public int getRankLevel() {
		return rankLevel;
	}

	public HashSet<ItemStack> getInventory(){
		return inventory;
	}
	
	public int getInvSlot() {
		return invSlot;
	}

	public void setInvSlot(int invSlot) {
		this.invSlot = invSlot;
	}

	public ItemStack getLogoItem() {
		return logoItem;
	}

	public void setLogoItem(ItemStack logoItem) {
		this.logoItem = logoItem;
	}

	
	public void setHelmet(ItemStack helmet) {
		this.helmet = helmet;
	}
	public void setHelmetEnchant(Enchantment e,int level){
		getHelmet().addUnsafeEnchantment(e, level);
	}
	
	public void setChestplate(ItemStack chestplate) {
		this.chestplate = chestplate;
	}
	public void setChestplateEnchant(Enchantment e,int level){
		getChestplate().addUnsafeEnchantment(e, level);
	}
	
	public void setLeggings(ItemStack leggings) {
		this.leggings = leggings;
	}
	public void setLeggingsEnchant(Enchantment e,int level){
		getLeggings().addUnsafeEnchantment(e, level);
	}
	
	public void setBoots(ItemStack boots) {
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
	
	public void addItem(ItemStack item){
		this.getInventory().add(item);
	}
	
	
	
	
	
}
