package fr.moderncraft.inventory;

import org.bukkit.inventory.ItemStack;

public class NonKitItem {
	
	private ItemStack item;
	private int invSlot;
	
	public NonKitItem(ItemStack item,int invSlot){
		this.item = item;
		this.invSlot = invSlot;
	}

	public ItemStack getItem() {
		return item;
	}

	public int getInvSlot() {
		return invSlot;
	}
}
