package fr.moderncraft.main;

import net.minecraft.server.v1_8_R2.InventoryHorseChest;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.moderncraft.inventory.Kit;

public class Plugin_Listener implements Listener{
	private Main main;

	public Plugin_Listener(Main main){
		super();
		this.main = main;
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e){
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
			Player player = e.getPlayer();
			if(player.getItemInHand() != null){
				if(player.getItemInHand().equals(main.getConfiguration().getKitItem())){
					Inventory in = main.getKitInventory().getInventory();
					player.openInventory(in);
				}
			}
		}
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e){
		if(e.getInventory().equals(main.getKitInventory().getInventory())){
			Player player = (Player) e.getWhoClicked();
			ItemStack is = e.getCurrentItem();
			Kit kit = main.getConfiguration().getConfigKit().searchKit(is);
			if(kit != null){
				kit.equipPlayer(player);
				player.closeInventory();
			}
		}
	}
	
	@EventHandler
	public void onPlayerConnect(PlayerJoinEvent e){
		Player player = e.getPlayer();
		player.teleport(player.getLocation().getWorld().getSpawnLocation());
		clearInventory(player);
		player.getInventory().addItem(main.getConfiguration().getKitItem());
	}
	
	private void clearInventory(Player p){
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
	}
}
