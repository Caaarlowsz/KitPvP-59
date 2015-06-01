package fr.moderncraft.inventory;


import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

public class SpecialObject {
	
	private IncendaryBomb bomb;
	private PoisonStaff staff;
	
	private class IncendaryBomb{
		private Potion potion;
		private ItemStack is;
	
		public IncendaryBomb(){
			is = new ItemStack(Material.POTION,1,(short)16387);
			ItemMeta meta = is.getItemMeta();
			meta.setDisplayName(ChatColor.RED+"Bombe Incendiaire");
			String lore = ChatColor.AQUA+"Enflamme tes énnemis !";
			meta.setLore(Arrays.asList(lore));
			is.setItemMeta(meta);
		}
		
		public ItemStack getItem(){
			return is;
		}
	}
	
	private class PoisonStaff{
		private ItemStack is;
		
		public PoisonStaff() {
			is = new ItemStack(Material.BLAZE_ROD);
			ItemMeta meta = is.getItemMeta();
			meta.setDisplayName(ChatColor.GREEN+"Baguette d'empoisonnement");
			String lore = ChatColor.AQUA+"Empoisonne tes énnemis !";
			meta.setLore(Arrays.asList(lore));
			is.setItemMeta(meta);
		}
		
		public ItemStack getItem(){
			return is;
		}
	}
	
	
	public SpecialObject(){
		bomb = new IncendaryBomb();
		staff = new PoisonStaff();
	}
	
	public ItemStack getItem(String name){
		switch (name) {
		case "IncendaryBomb":
			return bomb.getItem();
		case "PoisonStaff":
			return staff.getItem();
		default:
			return null;
		}
	}
	
	
}
