package fr.moderncraft.main;

import java.util.ArrayList;

import net.minecraft.server.v1_8_R2.InventoryHorseChest;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.FireworkEffect.Builder;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.moderncraft.inventory.Kit;
import fr.moderncraft.utils.FireworkEffectPlayer;

public class Plugin_Listener implements Listener {
	private Main main;

	public Plugin_Listener(Main main) {
		super();
		this.main = main;
	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_AIR
				|| e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			Player player = e.getPlayer();
			if (player.getItemInHand() != null) {
				if (player.getItemInHand().equals(
						main.getConfiguration().getKitItem())) {
					e.setCancelled(true);
					Inventory in = main.getKitInventory().getInventory();
					player.openInventory(in);
				}
			}
		}
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (e.getInventory().equals(main.getKitInventory().getInventory())) {
			Player player = (Player) e.getWhoClicked();
			ItemStack is = e.getCurrentItem();
			Kit kit = main.getConfiguration().getConfigKit().searchKit(is);
			e.setCancelled(true);
			if (kit != null) {
				kit.equipPlayer(player);
				player.closeInventory();
			}
		}
	}

	@EventHandler
	public void onPlayerConnect(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		if(main.getSql().isNewPlayer(player)){
			main.getSql().addPlayer(player);
		}
		player.teleport(player.getLocation().getWorld().getSpawnLocation());
		clearInventory(player);
		player.getInventory().addItem(main.getConfiguration().getKitItem());
	}

	@EventHandler
	public void onPlayerKilled(EntityDeathEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (e.getEntity().getKiller() instanceof Player) {
				Player killer = (Player) e.getEntity().getKiller();
				killer.setHealth(killer.getHealth() + 8);
			}
		}
	}
	
	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent e){
		Player player = e.getPlayer();
		player.teleport(player.getLocation().getWorld().getSpawnLocation());
		clearInventory(player);
		player.getInventory().addItem(main.getConfiguration().getKitItem());
	}
	
	@EventHandler
	public void onPotionSplash(PotionSplashEvent e){
		if(e.getPotion().getItem().equals(main.getSpecialObject().getItem("IncendaryBomb"))){
			for (LivingEntity en : e.getAffectedEntities()) {
				en.setFireTicks(5*20);
			} 
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onPlayerDoDamage(EntityDamageByEntityEvent e){
		if(e.getDamager() instanceof Player){
			Player p = (Player) e.getDamager();
			LivingEntity d = (LivingEntity) e.getEntity();
			if(p.getItemInHand().getType() == Material.BLAZE_ROD){
				FireworkEffectPlayer effectPlayer = new FireworkEffectPlayer();
				Builder b = FireworkEffect.builder();
				b.with(Type.BURST);
				b.withColor(Color.RED);
				b.withFade(Color.MAROON);
				try {
					Location loc = d.getLocation();
					loc.setY(loc.getY()+1);
					effectPlayer.playFirework(d.getWorld(), loc, b.build());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				d.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 3*50, 2));
			}
		}
	}

	private void clearInventory(Player p) {
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		for(PotionEffect effect : p.getActivePotionEffects())
		{
		    p.removePotionEffect(effect.getType());
		}
	}

}
