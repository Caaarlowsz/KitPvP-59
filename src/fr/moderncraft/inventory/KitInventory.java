package fr.moderncraft.inventory;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import fr.moderncraft.main.Main;

public class KitInventory{
	
	private Inventory inventory;
	private Main main;
	
	public KitInventory(Main main){
		super();
		this.main = main;
		this.inventory = Bukkit.createInventory(null, 54, "Choisissez votre kit");
	}
	
	private void setKits(){
		for (Kit kit : main.getConfiguration().getConfigKit().getKitList()) {
			this.inventory.setItem(kit.getInvSlot(), kit.getLogoItem());
		}
	}
	
	public Inventory getInventory(){
		return inventory;
	}

}
