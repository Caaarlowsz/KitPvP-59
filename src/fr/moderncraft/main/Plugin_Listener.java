package fr.moderncraft.main;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class Plugin_Listener implements Listener{
	private Main main;

	public Plugin_Listener(Main main){
		super();
		this.main = main;
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e){
		if(e.getWhoClicked() instanceof Player){
			Player player = (Player) e.getWhoClicked();
			if(e.getInventory().getType() == InventoryType.PLAYER){
				if(e.isLeftClick() || e.isRightClick()){
					if(e.getCurrentItem().getType() == Material.CHEST){
						player.openInventory(main.get);
					}
				}
			}
		}
	}
}
