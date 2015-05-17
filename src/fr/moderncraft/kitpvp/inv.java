package fr.moderncraft.kitpvp;

import java.util.Arrays;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Material;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class inv implements Listener {
	
	String prefixe = ChatColor.BLUE + "[KitPvP]" + ChatColor.RESET;
	String prix = ChatColor.WHITE + " Prix" + ChatColor.GREEN + " ";
	private Main plugin;
	public inv(Main plugin){
		this.plugin = plugin;
	}

	
	@EventHandler
	public void onPlayerIntEvent(PlayerInteractEvent e){
		Player p = e.getPlayer();
		Action a = e.getAction();
		
			if(a.equals(Action.RIGHT_CLICK_AIR) || a.equals(Action.RIGHT_CLICK_BLOCK)){
				try {
				if(p.getItemInHand().getItemMeta().getDisplayName().contains("Stats")){
					score.getStats(p);
				} else {}

				if(p.getItemInHand().getItemMeta().getDisplayName().contains("Coffre des Kits")){
					plugin.inv.setItem(0,getItemStackByID(Material.EMERALD, "Kit de Départ (Citadin)", "Sélectionnez un kit", 1,(short) 0));
					plugin.inv.setItem(1,getItemStackByID(Material.STAINED_GLASS_PANE, "|", "", 1,(short) 8));
					plugin.inv.setItem(2,getItemStackByID(Material.STAINED_GLASS_PANE, "|", "", 1,(short) 8));
					plugin.inv.setItem(3,getItemStackByID(Material.STAINED_GLASS_PANE, "|", "", 1,(short) 8));
					plugin.inv.setItem(4,getItemStackByID(Material.STAINED_GLASS_PANE, "|", "", 1,(short) 14));
					plugin.inv.setItem(5,getItemStackByID(Material.STAINED_GLASS_PANE, "|", "", 1,(short) 15));
					plugin.inv.setItem(6,getItemStackByID(Material.STAINED_GLASS_PANE, "|", "", 1,(short) 8));
					plugin.inv.setItem(7,getItemStackByID(Material.NETHER_STAR, "Kits Avancés", "Kit achetable avec l'argent du KitPvP", 1,(short) 0));
					plugin.inv.setItem(8,getItemStackByID(Material.STAINED_GLASS_PANE, "|", "", 1,(short) 8));
					plugin.inv.setItem(9,getItemStackByID(Material.STAINED_GLASS_PANE, "|", "", 1,(short) 8));
					plugin.inv.setItem(10,getItemStackByID(Material.WOOD_SWORD, "Kit Epéiste", "Soyez un glorieux Epéiste" , 1,(short) 0));
					plugin.inv.setItem(11,getItemStackByID(Material.BOW, "Kit Archer", "Soyez un glorieux Archer", 1,(short) 0));
					plugin.inv.setItem(12,getItemStackByID(Material.FEATHER, "Kit du Joggeur", "Savoir courir est un don", 1,(short) 0));
					plugin.inv.setItem(13,getItemStackByID(Material.STAINED_GLASS_PANE, "|", "", 1,(short) 15));
					plugin.inv.setItem(14,getItemStackByID(Material.STAINED_GLASS_PANE, "|", "", 1,(short) 14));
					plugin.inv.setItem(15,getItemStackByID(Material.STAINED_GLASS_PANE, "|", "", 1,(short) 8));
					plugin.inv.setItem(16,getItemStackByID(Material.STAINED_GLASS_PANE, "|", "", 1,(short) 8));
					plugin.inv.setItem(17,getItemStackByID(Material.STAINED_GLASS_PANE, "|", "", 1,(short) 8));
					plugin.inv.setItem(18,getItemStackByID(Material.IRON_INGOT, "Kit de départ(ViP-)", "Sélectionne un kit", 1,(short) 0));
					plugin.inv.setItem(19,getItemStackByID(Material.STAINED_GLASS_PANE, "|", "", 1,(short) 8));
					plugin.inv.setItem(20,getItemStackByID(Material.STAINED_GLASS_PANE, "|", "", 1,(short) 8));
					plugin.inv.setItem(21,getItemStackByID(Material.STAINED_GLASS_PANE, "|", "", 1,(short) 8));
					plugin.inv.setItem(22,getItemStackByID(Material.STAINED_GLASS_PANE, "|", "", 1,(short) 14));
					plugin.inv.setItem(23,getItemStackByID(Material.STAINED_GLASS_PANE, "|", "", 1,(short) 15));
					plugin.inv.setItem(24,getItemStackByID(Material.DIAMOND_AXE, "Decapitator", "Kit Diamand & hache en diamant" + prix + "750mc", 1,(short) 0));
					plugin.inv.setItem(25,getItemStackByID(Material.ENDER_PEARL, "Elementaliste", "Kit Diamand & EnderPearl" + prix + "500mc", 1,(short) 0));
					plugin.inv.setItem(26,getItemStackByID(Material.ARROW, "Infinity", "Arc Infinity" + prix + "500mc", 1,(short) 0));
					plugin.inv.setItem(27,getItemStackByID(Material.STAINED_GLASS_PANE, "|", "", 1,(short) 8));
					plugin.inv.setItem(28,getItemStackByID(Material.STONE_SWORD, "Kit Guerrier", "Soyez un fière Epéiste", 1,(short) 0));
					plugin.inv.setItem(29,getItemStackByID(Material.BOW, "Kit Arbalètrié", "Soyez un fière Archer", 1,(short) 0));
					plugin.inv.setItem(30,getItemStackByID(Material.FEATHER, "Kit Marathonnien", "Ne vous faites pas rattraper", 1,(short) 0));
					plugin.inv.setItem(31,getItemStackByID(Material.STAINED_GLASS_PANE, "|", "", 1,(short) 15));
					plugin.inv.setItem(32,getItemStackByID(Material.STAINED_GLASS_PANE, "|", "", 1,(short) 14));
					plugin.inv.setItem(33,getItemStackByID(Material.GOLDEN_APPLE, "Adam", "Kit Diamand & épée en Diamand + pomme d'or" + prix + "600mc", 1,(short) 0));
					plugin.inv.setItem(34,getItemStackByID(Material.GOLDEN_CARROT, "Eve", "Kit Diamand, épée en Diamand" + prix + "350mc", 1,(short) 0));
					plugin.inv.setItem(35,getItemStackByID(Material.CACTUS, "Piquant", "Kit Diamand & Thorn" + prix + "700mc", 1,(short) 0));
					plugin.inv.setItem(36,getItemStackByID(Material.GOLD_INGOT, "Kit de Départ (ViP+)", "Sélectionnez un kit", 1,(short) 0));
					plugin.inv.setItem(37,getItemStackByID(Material.STAINED_GLASS_PANE, "|", "", 1,(short) 8));
					plugin.inv.setItem(38,getItemStackByID(Material.STAINED_GLASS_PANE, "|", "", 1,(short) 8));
					plugin.inv.setItem(39,getItemStackByID(Material.STAINED_GLASS_PANE, "|", "", 1,(short) 8));
					plugin.inv.setItem(40,getItemStackByID(Material.STAINED_GLASS_PANE, "|", "", 1,(short) 14));
					plugin.inv.setItem(41,getItemStackByID(Material.STAINED_GLASS_PANE, "|", "", 1,(short) 15));
					plugin.inv.setItem(42,getItemStackByID(Material.STAINED_GLASS_PANE, "|", "", 1,(short) 8));
					plugin.inv.setItem(43,getItemStackByID(Material.BOW, "Sniper", "Kit arc power 100" + prix + "1000mc", 1,(short) 364));
					plugin.inv.setItem(44,getItemStackByID(Material.STAINED_GLASS_PANE, "|", "", 1,(short) 8));
					plugin.inv.setItem(45,getItemStackByID(Material.STAINED_GLASS_PANE, "|", "", 1,(short) 8));
					plugin.inv.setItem(46,getItemStackByID(Material.GOLD_SWORD, "Kit Garde", "Soyez un légendaire Epéiste", 1,(short) 0));
					plugin.inv.setItem(47,getItemStackByID(Material.BOW, "Kit Expert précision", "Soyez un légendaire Archer", 1,(short) 0));
					plugin.inv.setItem(48,getItemStackByID(Material.FEATHER, "Kit Usain Bolt", "Soyez Usain Bolt", 1,(short) 0));
					plugin.inv.setItem(49,getItemStackByID(Material.STAINED_GLASS_PANE, "|", "", 1,(short) 15));
					plugin.inv.setItem(50,getItemStackByID(Material.STAINED_GLASS_PANE, "|", "", 1,(short) 14));
					plugin.inv.setItem(51,getItemStackByID(Material.STAINED_GLASS_PANE, "|", "", 1,(short) 8));
					plugin.inv.setItem(52,getItemStackByID(Material.STAINED_GLASS_PANE, "|", "", 1,(short) 8));
					plugin.inv.setItem(53,getItemStackByID(Material.STAINED_GLASS_PANE, "|", "", 1,(short) 8));
					p.openInventory(plugin.inv);
				}
			} catch(Exception n) {
				
			}
			}
	}

	@EventHandler
	public void onPlayerClickEvent(InventoryClickEvent e){
		
		Player p = (Player) e.getWhoClicked();
		int u = score.getEco(p);
		
		if(e.getInventory().getTitle().equals(plugin.inv.getTitle())){
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Citadin")){
				p.closeInventory();
				e.setCancelled(true);
				p.sendMessage(prefixe + "Kit de départ des Citadins");
			}
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().contains("ViP-")){
					p.closeInventory();
					e.setCancelled(true);
					p.sendMessage(prefixe + "Kit de départ des ViP-");
			}
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().contains("ViP+")){
						p.closeInventory();
						e.setCancelled(true);
						p.sendMessage(prefixe + "Kit de départ des ViP+");
			}
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Avanc")){
				p.closeInventory();
				e.setCancelled(true);
				p.sendMessage(prefixe + "Kits Avancés");
			}
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().contains("|")){
				p.closeInventory();
				e.setCancelled(true);
			}
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Epéiste")){
				p.getInventory().clear();
				p.removePotionEffect(PotionEffectType.SPEED);
				
			    ItemStack is = new ItemStack(Material.IRON_HELMET, 1); // Les bottes en cuir seront l'item à donner, et à modifier.
			    is.addEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 3);
			    is.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
			    //LeatherArmorMeta meta = (LeatherArmorMeta) is.getItemMeta(); // On récupère la méta actuelle de l'item afin de la modifier.
			    //meta.setColor(Color.GREEN); // On indique que l'on souhaite que les bottes soient de couleur verte. [Vous pouvez aussi utiliser Color.fromRGB(int red, int green, int blue OU int rgb), ou encore Color.fromBGR(int blue, int green, int red OU int bgr) pour des couleurs personnalisées]
			   // is.setItemMeta(meta); // On applique les modifications sur l'item.
				p.getInventory().setHelmet(new ItemStack(is));
				
				ItemStack is2 = new ItemStack(Material.IRON_CHESTPLATE, 1); 
			    is2.addEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 3);
			    is2.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
			    //LeatherArmorMeta meta2 = (LeatherArmorMeta) is.getItemMeta(); 
			    //meta2.setColor(Color.GREEN); 
			    //is2.setItemMeta(meta2);
				p.getInventory().setChestplate(new ItemStack(is2));
				
				ItemStack is3 = new ItemStack(Material.IRON_LEGGINGS, 1); 
			    is3.addEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 3);
			    is3.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
			    //LeatherArmorMeta meta3 = (LeatherArmorMeta) is.getItemMeta(); 
			    //meta3.setColor(Color.GREEN); 
			    //is3.setItemMeta(meta3); 
				p.getInventory().setLeggings(new ItemStack(is3));
				
				ItemStack is4 = new ItemStack(Material.IRON_BOOTS, 1); 
			    is4.addEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 3);
			    is4.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
			    //LeatherArmorMeta meta4 = (LeatherArmorMeta) is4.getItemMeta(); 
			    //meta4.setColor(Color.GREEN);  
			    //is4.setItemMeta(meta4); 
				p.getInventory().setBoots(new ItemStack(is4));
				
				ItemStack is5 = new ItemStack(Material.IRON_SWORD, 1);
			    is5.addEnchantment(EnchantmentWrapper.DAMAGE_ALL, 2);
			    is5.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
				p.getInventory().addItem(new ItemStack(is5));
				
				ItemStack is6 = new ItemStack (Material.POTION, 1);
				PotionMeta meta6 = (PotionMeta) is6.getItemMeta();
				meta6.addCustomEffect((new PotionEffect(PotionEffectType.HEAL, 1, 1)),true );
				meta6.setMainEffect(PotionEffectType.HEAL);
				meta6.setDisplayName("Eternal Potion");
				meta6.setDisplayName("Spécialité de " + ChatColor.GOLD + "Moderncraft");
				is6.setItemMeta(meta6);
				p.getInventory().addItem(new ItemStack(is6));
				p.getInventory().addItem(new ItemStack(is6));
				
				ItemStack is10 = new ItemStack(Material.COOKED_BEEF, 16);
				p.getInventory().addItem(new ItemStack(is10));
				
				p.closeInventory();
				e.setCancelled(true);
				
			}
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Guerrier") && (p.hasPermission("kitpvp.vip") || p.hasPermission("kitpvp.vipp"))){
				p.getInventory().clear();
				p.removePotionEffect(PotionEffectType.SPEED);
				
			    ItemStack is = new ItemStack(Material.IRON_HELMET, 1); // Les bottes en cuir seront l'item à donner, et à modifier.
			    is.addEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 4);
			    is.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
			    //LeatherArmorMeta meta = (LeatherArmorMeta) is.getItemMeta(); // On récupère la méta actuelle de l'item afin de la modifier.
			    //meta.setColor(Color.RED); // On indique que l'on souhaite que les bottes soient de couleur verte. [Vous pouvez aussi utiliser Color.fromRGB(int red, int green, int blue OU int rgb), ou encore Color.fromBGR(int blue, int green, int red OU int bgr) pour des couleurs personnalisées]
			    //is.setItemMeta(meta); // On applique les modifications sur l'item.
				p.getInventory().setHelmet(new ItemStack(is));
				
				ItemStack is2 = new ItemStack(Material.IRON_CHESTPLATE, 1); 
			    is2.addEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 4);
			    is2.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
			    //LeatherArmorMeta meta2 = (LeatherArmorMeta) is.getItemMeta(); 
			    //meta2.setColor(Color.RED); 
			    //is2.setItemMeta(meta2);
				p.getInventory().setChestplate(new ItemStack(is2));
				
				ItemStack is3 = new ItemStack(Material.IRON_LEGGINGS, 1); 
			    is3.addEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 4);
			    is3.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
			    //LeatherArmorMeta meta3 = (LeatherArmorMeta) is.getItemMeta(); 
			    //meta3.setColor(Color.RED); 
			    //is3.setItemMeta(meta3); 
				p.getInventory().setLeggings(new ItemStack(is3));
				
				ItemStack is4 = new ItemStack(Material.IRON_BOOTS, 1); 
			    is4.addEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 4);
			    is4.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
			    //LeatherArmorMeta meta4 = (LeatherArmorMeta) is4.getItemMeta();
			    //meta4.setColor(Color.RED);  
			    //is4.setItemMeta(meta4); 
				p.getInventory().setBoots(new ItemStack(is4));
				
				ItemStack is5 = new ItemStack(Material.IRON_SWORD, 1);
			    is5.addEnchantment(EnchantmentWrapper.DAMAGE_ALL, 2);
			    is5.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
				p.getInventory().addItem(new ItemStack(is5));
				
				ItemStack is6 = new ItemStack (Material.POTION, 1);
				PotionMeta meta6 = (PotionMeta) is6.getItemMeta();
				meta6.addCustomEffect((new PotionEffect(PotionEffectType.HEAL, 1, 1)),true );
				meta6.setMainEffect(PotionEffectType.HEAL);
				meta6.setDisplayName("Eternal Potion");
				meta6.setDisplayName("Spécialité de " + ChatColor.GOLD + "Moderncraft");
				is6.setItemMeta(meta6);
				p.getInventory().addItem(new ItemStack(is6));
				p.getInventory().addItem(new ItemStack(is6));
				
				ItemStack is10 = new ItemStack(Material.COOKED_BEEF, 16);
				p.getInventory().addItem(new ItemStack(is10));
				
				p.closeInventory();
				e.setCancelled(true);
			}
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Guerrier") && ((!p.hasPermission("kitpvp.vip")) || (!p.hasPermission("kitpvp.vipp")))){
				p.closeInventory();
				e.setCancelled(true);
				p.sendMessage("Vous n'êtes pas Vip ou Vip+");
			}
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Garde") && (p.hasPermission("kitpvp.vipp"))) {
				p.getInventory().clear();
				p.removePotionEffect(PotionEffectType.SPEED);
				
			    ItemStack is = new ItemStack(Material.IRON_HELMET, 1); // Les bottes en cuir seront l'item à donner, et à modifier.
			    is.addEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 4);
			    is.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
			    //LeatherArmorMeta meta = (LeatherArmorMeta) is.getItemMeta(); // On récupère la méta actuelle de l'item afin de la modifier.
			    //meta.setColor(Color.YELLOW); // On indique que l'on souhaite que les bottes soient de couleur verte. [Vous pouvez aussi utiliser Color.fromRGB(int red, int green, int blue OU int rgb), ou encore Color.fromBGR(int blue, int green, int red OU int bgr) pour des couleurs personnalisées]
			    //is.setItemMeta(meta); // On applique les modifications sur l'item.
				p.getInventory().setHelmet(new ItemStack(is));
				
				ItemStack is2 = new ItemStack(Material.IRON_CHESTPLATE, 1); 
			    is2.addEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 4);
			    is2.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
			    //LeatherArmorMeta meta2 = (LeatherArmorMeta) is.getItemMeta(); 
			    //meta2.setColor(Color.YELLOW); 
			    //is2.setItemMeta(meta2);
				p.getInventory().setChestplate(new ItemStack(is2));
				
				ItemStack is3 = new ItemStack(Material.IRON_LEGGINGS, 1); 
			    is3.addEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 4);
			    is3.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
			    //LeatherArmorMeta meta3 = (LeatherArmorMeta) is.getItemMeta(); 
			    //meta3.setColor(Color.YELLOW); 
			    //is3.setItemMeta(meta3); 
				p.getInventory().setLeggings(new ItemStack(is3));
				
				ItemStack is4 = new ItemStack(Material.IRON_BOOTS, 1); 
			    is4.addEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 4);
			    is4.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
			    //LeatherArmorMeta meta4 = (LeatherArmorMeta) is4.getItemMeta(); 
			    //meta4.setColor(Color.YELLOW);  
			    //is4.setItemMeta(meta4); 
				p.getInventory().setBoots(new ItemStack(is4));
				
				ItemStack is5 = new ItemStack(Material.IRON_SWORD, 1);
			    is5.addEnchantment(EnchantmentWrapper.DAMAGE_ALL, 3);
			    is5.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
				p.getInventory().addItem(new ItemStack(is5));
				
				ItemStack is6 = new ItemStack (Material.POTION, 1);
				PotionMeta meta6 = (PotionMeta) is6.getItemMeta();
				meta6.addCustomEffect((new PotionEffect(PotionEffectType.HEAL, 1, 1)),true );
				meta6.setMainEffect(PotionEffectType.HEAL);
				meta6.setDisplayName("Eternal Potion");
				meta6.setDisplayName("Spécialité de " + ChatColor.GOLD + "Moderncraft");
				is6.setItemMeta(meta6);
				p.getInventory().addItem(new ItemStack(is6));
				p.getInventory().addItem(new ItemStack(is6));
				
				ItemStack is10 = new ItemStack(Material.COOKED_BEEF, 16);
				p.getInventory().addItem(new ItemStack(is10));
				
				p.closeInventory();
				e.setCancelled(true);
			}
				
			else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Garde") && (!p.hasPermission("kitpvp.vipp"))) {
				p.closeInventory();
				e.setCancelled(true);
				p.sendMessage("Vous n'êtes pas Vip+");
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Archer")) {
				p.removePotionEffect(PotionEffectType.SPEED);
                p.getInventory().clear();
                
                ItemStack is = new ItemStack(Material.CHAINMAIL_HELMET, 1);
                is.addUnsafeEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 2);
                is.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
                p.getInventory().setHelmet(new ItemStack(is));
                
                ItemStack is2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
                is.addUnsafeEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 2);
                is2.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
                p.getInventory().setChestplate(new ItemStack(is2));
                
                ItemStack is3 = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
                is.addUnsafeEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 2);
                is3.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
                p.getInventory().setLeggings(new ItemStack(is3));
                
                ItemStack is4 = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
                is.addUnsafeEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 2);
                is4.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
                p.getInventory().setBoots(new ItemStack(is4));
                
                ItemStack is5 = new ItemStack(Material.STONE_SWORD, 1);
                is5.addEnchantment(EnchantmentWrapper.DAMAGE_ALL, 2);
                is5.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
                p.getInventory().addItem(new ItemStack(is5));
                
                ItemStack is8 = new ItemStack(Material.BOW, 1);
                is8.addEnchantment(EnchantmentWrapper.ARROW_DAMAGE, 1);
                is8.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
                p.getInventory().addItem(new ItemStack(is8));
                
                ItemStack is6 = new ItemStack(Material.POTION, 1);
                PotionMeta meta6 = (PotionMeta)is6.getItemMeta();
                meta6.addCustomEffect(new PotionEffect(PotionEffectType.HEAL, 1, 1), true);
                meta6.setMainEffect(PotionEffectType.HEAL);
                meta6.setDisplayName("Eternal Potion");
                meta6.setDisplayName("Spécialité de " + ChatColor.GOLD + "Moderncraft");
                is6.setItemMeta(meta6);
                p.getInventory().addItem(new ItemStack(is6));
                p.getInventory().addItem(new ItemStack(is6));
                
                ItemStack is7 = new ItemStack(Material.ARROW, 32);
                p.getInventory().addItem(new ItemStack(is7));
                
                ItemStack is10 = new ItemStack(Material.COOKED_BEEF, 16);
				p.getInventory().addItem(new ItemStack(is10));
                
                p.closeInventory();
                e.setCancelled(true);
            }
			
            if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Arbalètrié") && (p.hasPermission("kitpvp.vip") || p.hasPermission("kitpvp.vipp"))){
                p.getInventory().clear();
                p.removePotionEffect(PotionEffectType.SPEED);
                ItemStack is = new ItemStack(Material.CHAINMAIL_HELMET, 1);
                is.addUnsafeEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 2);
                is.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
                p.getInventory().setHelmet(new ItemStack(is));
                
                ItemStack is2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
                is.addUnsafeEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 2);
                is2.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
                p.getInventory().setChestplate(new ItemStack(is2));
                
                ItemStack is3 = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
                is.addUnsafeEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 2);
                is3.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
                p.getInventory().setLeggings(new ItemStack(is3));
                
                ItemStack is4 = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
                is.addUnsafeEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 2);
                is4.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
                p.getInventory().setBoots(new ItemStack(is4));
                
                ItemStack is5 = new ItemStack(Material.STONE_SWORD, 1);
                is5.addEnchantment(EnchantmentWrapper.DAMAGE_ALL, 2);
                is5.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
                p.getInventory().addItem(new ItemStack(is5));
                
                ItemStack is8 = new ItemStack(Material.BOW, 1);
                is8.addEnchantment(EnchantmentWrapper.ARROW_DAMAGE, 2);
                is8.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
                p.getInventory().addItem(new ItemStack(is8));
                
                ItemStack is6 = new ItemStack(Material.POTION, 1);
                PotionMeta meta6 = (PotionMeta)is6.getItemMeta();
                meta6.addCustomEffect(new PotionEffect(PotionEffectType.HEAL, 1, 1), true);
                meta6.setMainEffect(PotionEffectType.HEAL);
                meta6.setDisplayName("Eternal Potion");
                meta6.setDisplayName("Spécialité de " + ChatColor.GOLD + "Moderncraft");
                is6.setItemMeta(meta6);
                p.getInventory().addItem(new ItemStack(is6));
                p.getInventory().addItem(new ItemStack(is6));
                
                ItemStack is7 = new ItemStack(Material.ARROW, 32);
                p.getInventory().addItem(new ItemStack(is7));
                
                ItemStack is10 = new ItemStack(Material.COOKED_BEEF, 16);
				p.getInventory().addItem(new ItemStack(is10));
                
                p.closeInventory();
                e.setCancelled(true);
                
            } else
            if((e.getCurrentItem().getItemMeta().getDisplayName().contains("Arbalètrié")) && (!p.hasPermission("kitpvp.vip"))) 
            {
                p.closeInventory();
                e.setCancelled(true);
                p.sendMessage("Vous n'êtes pas Vip ou Vip+");
            }
            if(e.getCurrentItem().getItemMeta().getDisplayName().contains("précision") && (p.hasPermission("kitpvp.vipp")))
            {
                p.getInventory().clear();
                p.removePotionEffect(PotionEffectType.SPEED);
                ItemStack is = new ItemStack(Material.CHAINMAIL_HELMET, 1);
                is.addEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 3);
                is.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
                p.getInventory().setHelmet(new ItemStack(is));
                
                ItemStack is2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
                is2.addEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 3);
                is2.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
                p.getInventory().setChestplate(new ItemStack(is2));
                
                ItemStack is3 = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
                is3.addEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 3);
                is3.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
                p.getInventory().setLeggings(new ItemStack(is3));
                
                ItemStack is4 = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
                is4.addEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 3);
                is4.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
                p.getInventory().setBoots(new ItemStack(is4));
                
                ItemStack is5 = new ItemStack(Material.STONE_SWORD, 1);
                is5.addEnchantment(EnchantmentWrapper.DAMAGE_ALL, 2);
                is5.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
                p.getInventory().addItem(new ItemStack(is5));
                
                ItemStack is8 = new ItemStack(Material.BOW, 1);
                is8.addEnchantment(EnchantmentWrapper.ARROW_DAMAGE, 2);
                is8.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
                p.getInventory().addItem(new ItemStack(is8));
                                
                ItemStack is6 = new ItemStack(Material.POTION, 1);
                PotionMeta meta6 = (PotionMeta)is6.getItemMeta();
                meta6.addCustomEffect(new PotionEffect(PotionEffectType.HEAL, 1, 1), true);
                meta6.setMainEffect(PotionEffectType.HEAL);
                meta6.setDisplayName("Eternal Potion");
                meta6.setDisplayName("Spécialité de " + ChatColor.GOLD + "Moderncraft");
                is6.setItemMeta(meta6);
                p.getInventory().addItem(new ItemStack(is6));
                p.getInventory().addItem(new ItemStack(is6));
                
                ItemStack is7 = new ItemStack(Material.ARROW, 32);
                p.getInventory().addItem(new ItemStack(is7));
                
                ItemStack is10 = new ItemStack(Material.COOKED_BEEF, 16);
				p.getInventory().addItem(new ItemStack(is10));
                
                p.closeInventory();
                e.setCancelled(true);
                
            } else
            if(e.getCurrentItem().getItemMeta().getDisplayName().contains("précision") && (!p.hasPermission("kitpvp.vipp")))
            {
                p.closeInventory();
                e.setCancelled(true);
                p.sendMessage("Vous n'êtes pas Vip+");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Joggeur")){
				p.getInventory().clear();
				p.removePotionEffect(PotionEffectType.SPEED);
				
			    ItemStack is = new ItemStack(Material.IRON_HELMET, 1); // Les bottes en cuir seront l'item à donner, et à modifier.
			    is.addUnsafeEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 2);
			    is.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
				p.getInventory().setHelmet(new ItemStack(is));
				
				ItemStack is2 = new ItemStack(Material.IRON_CHESTPLATE, 1); 
				is2.addUnsafeEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 2);
			    is2.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
				p.getInventory().setChestplate(new ItemStack(is2));
				
				ItemStack is3 = new ItemStack(Material.IRON_LEGGINGS, 1); 
				is3.addUnsafeEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 2);
			    is3.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
				p.getInventory().setLeggings(new ItemStack(is3));
				
				ItemStack is4 = new ItemStack(Material.IRON_BOOTS, 1); 
				is4.addUnsafeEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 2);
			    is4.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
				p.getInventory().setBoots(new ItemStack(is4));
				
				ItemStack is5 = new ItemStack(Material.IRON_SWORD, 1);
			    is5.addEnchantment(EnchantmentWrapper.DAMAGE_ALL, 2);
			    is5.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
				p.getInventory().addItem(new ItemStack(is5));
				
				ItemStack is6 = new ItemStack (Material.POTION, 1);
				PotionMeta meta6 = (PotionMeta) is6.getItemMeta();
				meta6.addCustomEffect((new PotionEffect(PotionEffectType.HEAL, 1, 1)),true );
				meta6.setMainEffect(PotionEffectType.HEAL);
				meta6.setDisplayName("Eternal Potion");
				meta6.setDisplayName("Spécialité de " + ChatColor.GOLD + "Moderncraft");
				is6.setItemMeta(meta6);
				p.getInventory().addItem(new ItemStack(is6));
				p.getInventory().addItem(new ItemStack(is6));
				
				ItemStack is10 = new ItemStack(Material.COOKED_BEEF, 16);
				p.getInventory().addItem(new ItemStack(is10));
				
				p.getInventory().addItem(getItemStackByID(Material.POTION, "La vitesse sur Moderncraft", "Cours !", 2,(short) 16450));
				p.closeInventory();
				e.setCancelled(true);
			}
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Marathonnien") && ((p.hasPermission("kitpvp.vip")) || (p.hasPermission("kitpvp.vipp")))){
				p.getInventory().clear();
				p.removePotionEffect(PotionEffectType.SPEED);
				
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,9999999, 1));
				
				ItemStack is = new ItemStack(Material.IRON_HELMET, 1); // Les bottes en cuir seront l'item à donner, et à modifier.
			    is.addUnsafeEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 2);
			    is.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
				p.getInventory().setHelmet(new ItemStack(is));
				
				ItemStack is2 = new ItemStack(Material.IRON_CHESTPLATE, 1); 
				is2.addUnsafeEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 2);
			    is2.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
				p.getInventory().setChestplate(new ItemStack(is2));
				
				ItemStack is3 = new ItemStack(Material.IRON_LEGGINGS, 1); 
				is3.addUnsafeEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 2);
			    is3.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
				p.getInventory().setLeggings(new ItemStack(is3));
				
				ItemStack is4 = new ItemStack(Material.IRON_BOOTS, 1); 
				is4.addUnsafeEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 2);
			    is4.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
				p.getInventory().setBoots(new ItemStack(is4));
				
				ItemStack is5 = new ItemStack(Material.IRON_SWORD, 1);
				is5.addEnchantment(EnchantmentWrapper.DAMAGE_ALL, 2);
			    is5.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
				p.getInventory().addItem(new ItemStack(is5));
				
				ItemStack is6 = new ItemStack (Material.POTION, 1);
				PotionMeta meta6 = (PotionMeta) is6.getItemMeta();
				meta6.addCustomEffect((new PotionEffect(PotionEffectType.HEAL, 1, 1)),true );
				meta6.setMainEffect(PotionEffectType.HEAL);
				meta6.setDisplayName("Eternal Potion");
				meta6.setDisplayName("Spécialité de " + ChatColor.GOLD + "Moderncraft");
				is6.setItemMeta(meta6);
				p.getInventory().addItem(new ItemStack(is6));
				p.getInventory().addItem(new ItemStack(is6));
				
				ItemStack is10 = new ItemStack(Material.COOKED_BEEF, 16);
				p.getInventory().addItem(new ItemStack(is10));
				
				p.closeInventory();
				e.setCancelled(true);
			}
			
			else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Marathonnien") && ((!p.hasPermission("kitpvp.vip")) || (!p.hasPermission("kitpvp.vipp")))){

				p.closeInventory();
				e.setCancelled(true);
				p.sendMessage("Vous n'êtes pas Vip ou Vip+");
			}
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Usain") && (p.hasPermission("kitpvp.vipp"))){
				p.getInventory().clear();
				p.removePotionEffect(PotionEffectType.SPEED);
				
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,9999999, 1));
				
				ItemStack is = new ItemStack(Material.IRON_HELMET, 1); // Les bottes en cuir seront l'item à donner, et à modifier.
			    is.addUnsafeEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 2);
			    is.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
				p.getInventory().setHelmet(new ItemStack(is));
				
				ItemStack is2 = new ItemStack(Material.IRON_CHESTPLATE, 1); 
				is2.addUnsafeEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 2);
			    is2.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
				p.getInventory().setChestplate(new ItemStack(is2));
				
				ItemStack is3 = new ItemStack(Material.IRON_LEGGINGS, 1); 
				is3.addUnsafeEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 2);
			    is3.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
				p.getInventory().setLeggings(new ItemStack(is3));
				
				ItemStack is4 = new ItemStack(Material.IRON_BOOTS, 1); 
				is4.addUnsafeEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 2);
			    is4.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
				p.getInventory().setBoots(new ItemStack(is4));
				
				ItemStack is5 = new ItemStack(Material.IRON_SWORD, 1);
			    is5.addEnchantment(EnchantmentWrapper.DAMAGE_ALL, 2);
			    is5.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
				p.getInventory().addItem(new ItemStack(is5));
				
				ItemStack is6 = new ItemStack (Material.POTION, 1);
				PotionMeta meta6 = (PotionMeta) is6.getItemMeta();
				meta6.addCustomEffect((new PotionEffect(PotionEffectType.HEAL, 1, 1)),true );
				meta6.setMainEffect(PotionEffectType.HEAL);
				meta6.setDisplayName("Eternal Potion");
				meta6.setDisplayName("Spécialité de " + ChatColor.GOLD + "Moderncraft");
				is6.setItemMeta(meta6);
				p.getInventory().addItem(new ItemStack(is6));
				p.getInventory().addItem(new ItemStack(is6));
				
				ItemStack is10 = new ItemStack(Material.COOKED_BEEF, 16);
				p.getInventory().addItem(new ItemStack(is10));
				
				p.closeInventory();
				e.setCancelled(true);
			}
				
			else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Usain") && (!p.hasPermission("kitpvp.vipp"))){
				p.closeInventory();
				e.setCancelled(true);
				p.sendMessage("Vous n'êtes pas Vip+");
			}
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Decapitator") && u >= 750) {
				p.getInventory().clear();
				p.removePotionEffect(PotionEffectType.SPEED);
				
			    ItemStack is = new ItemStack(Material.DIAMOND_HELMET, 1); // Les bottes en cuir seront l'item à donner, et à modifier.
			    is.addUnsafeEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 1);
			    is.addEnchantment(EnchantmentWrapper.DURABILITY, 3);
				p.getInventory().setHelmet(new ItemStack(is));
				
				ItemStack is2 = new ItemStack(Material.DIAMOND_CHESTPLATE, 1); 
				is2.addUnsafeEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 1);
			    is2.addEnchantment(EnchantmentWrapper.DURABILITY, 3);
				p.getInventory().setChestplate(new ItemStack(is2));
				
				ItemStack is3 = new ItemStack(Material.DIAMOND_LEGGINGS, 1); 
				is3.addUnsafeEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 1);
			    is3.addEnchantment(EnchantmentWrapper.DURABILITY, 3);
				p.getInventory().setLeggings(new ItemStack(is3));
				
				ItemStack is4 = new ItemStack(Material.DIAMOND_BOOTS, 1); 
				is4.addUnsafeEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 1);
			    is4.addEnchantment(EnchantmentWrapper.DURABILITY, 3);
				p.getInventory().setBoots(new ItemStack(is4));
				
				ItemStack is5 = new ItemStack(Material.DIAMOND_AXE, 1);
			    is5.addEnchantment(EnchantmentWrapper.DURABILITY, 3);
				p.getInventory().addItem(new ItemStack(is5));
				
				ItemStack is6 = new ItemStack (Material.POTION, 1);
				PotionMeta meta6 = (PotionMeta) is6.getItemMeta();
				meta6.addCustomEffect((new PotionEffect(PotionEffectType.HEAL, 1, 1)),true );
				meta6.setMainEffect(PotionEffectType.HEAL);
				meta6.setDisplayName("Eternal Potion");
				meta6.setDisplayName("Spécialité de " + ChatColor.GOLD + "Moderncraft");
				is6.setItemMeta(meta6);
				p.getInventory().addItem(new ItemStack(is6));
				p.getInventory().addItem(new ItemStack(is6));
				
				ItemStack is10 = new ItemStack(Material.COOKED_BEEF, 16);
				p.getInventory().addItem(new ItemStack(is10));
				
				int r = u - 750;
				String t = Integer.toString(r);
				score.setEco(p, t);
				
				p.closeInventory();
				e.setCancelled(true);
			}
				
			else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Decapitator") && u < 750){
				p.closeInventory();
				e.setCancelled(true);
				p.sendMessage(prefixe + "Vous n'avez pas assez d'argent.");
			}
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Elementaliste") && u >= 500) {
				p.getInventory().clear();
				p.removePotionEffect(PotionEffectType.SPEED);
				
				ItemStack is = new ItemStack(Material.DIAMOND_HELMET, 1); // Les bottes en cuir seront l'item à donner, et à modifier.
			    is.addUnsafeEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 1);
			    is.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 3);
				p.getInventory().setHelmet(new ItemStack(is));
				
				ItemStack is2 = new ItemStack(Material.DIAMOND_CHESTPLATE, 1); 
				is.addUnsafeEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 1);
			    is2.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 3);
				p.getInventory().setChestplate(new ItemStack(is2));
				
				ItemStack is3 = new ItemStack(Material.DIAMOND_LEGGINGS, 1); 
				is.addUnsafeEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 1);
			    is3.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 3);
				p.getInventory().setLeggings(new ItemStack(is3));
				
				ItemStack is4 = new ItemStack(Material.DIAMOND_BOOTS, 1); 
				is.addUnsafeEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 1);
			    is4.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 3);
				p.getInventory().setBoots(new ItemStack(is4));
				
				ItemStack is5 = new ItemStack(Material.IRON_SWORD, 1);
				is5.addEnchantment(EnchantmentWrapper.DAMAGE_ALL, 2);
			    is5.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 3);
				p.getInventory().addItem(new ItemStack(is5));
				
				ItemStack is7 = new ItemStack(Material.ENDER_PEARL, 6);
				p.getInventory().addItem(new ItemStack(is7));
				
				ItemStack is6 = new ItemStack (Material.POTION, 1);
				PotionMeta meta6 = (PotionMeta) is6.getItemMeta();
				meta6.addCustomEffect((new PotionEffect(PotionEffectType.HEAL, 1, 1)),true );
				meta6.setMainEffect(PotionEffectType.HEAL);
				meta6.setDisplayName("Eternal Potion");
				meta6.setDisplayName("Spécialité de " + ChatColor.GOLD + "Moderncraft");
				is6.setItemMeta(meta6);
				p.getInventory().addItem(new ItemStack(is6));
				p.getInventory().addItem(new ItemStack(is6));
				
				ItemStack is10 = new ItemStack(Material.COOKED_BEEF, 16);
				p.getInventory().addItem(new ItemStack(is10));
				
				int r = u - 500;
				String t = Integer.toString(r);
				score.setEco(p, t);
				
				p.closeInventory();
				e.setCancelled(true);
			}
				
			else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Elementaliste") && u < 500){
				p.closeInventory();
				e.setCancelled(true);
				p.sendMessage(prefixe + "Vous n'avez pas assez d'argent");
			}
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Infinity") && u >= 500) {
				p.getInventory().clear();
				p.removePotionEffect(PotionEffectType.SPEED);
				
			    ItemStack is = new ItemStack(Material.IRON_HELMET, 1); // Les bottes en cuir seront l'item à donner, et à modifier.
			    is.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 3);
				p.getInventory().setHelmet(new ItemStack(is));
				
				ItemStack is2 = new ItemStack(Material.IRON_CHESTPLATE, 1); 
			    is2.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 3);
				p.getInventory().setChestplate(new ItemStack(is2));
				
				ItemStack is3 = new ItemStack(Material.IRON_LEGGINGS, 1); 
			    is3.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 3);
				p.getInventory().setLeggings(new ItemStack(is3));
				
				ItemStack is4 = new ItemStack(Material.IRON_BOOTS, 1); 
			    is4.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 3);
				p.getInventory().setBoots(new ItemStack(is4));
				
				ItemStack is7 = new ItemStack(Material.BOW, 1);
				is7.addEnchantment(EnchantmentWrapper.ARROW_INFINITE, 1);
				is7.addEnchantment(EnchantmentWrapper.ARROW_DAMAGE, 2);
				p.getInventory().addItem(new ItemStack(is7));
				
				ItemStack is5 = new ItemStack(Material.IRON_SWORD, 1);
				is5.addEnchantment(EnchantmentWrapper.DAMAGE_ALL, 3);
			    is5.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 3);
				p.getInventory().addItem(new ItemStack(is5));
				
				ItemStack is6 = new ItemStack (Material.POTION, 1);
				PotionMeta meta6 = (PotionMeta) is6.getItemMeta();
				meta6.addCustomEffect((new PotionEffect(PotionEffectType.HEAL, 1, 1)),true );
				meta6.setMainEffect(PotionEffectType.HEAL);
				meta6.setDisplayName("Eternal Potion");
				meta6.setDisplayName("Spécialité de " + ChatColor.GOLD + "Moderncraft");
				is6.setItemMeta(meta6);
				p.getInventory().addItem(new ItemStack(is6));
				p.getInventory().addItem(new ItemStack(is6));
				
				ItemStack is8 = new ItemStack(Material.ARROW, 1);
				p.getInventory().addItem(new ItemStack(is8));
				
				ItemStack is10 = new ItemStack(Material.COOKED_BEEF, 16);
				p.getInventory().addItem(new ItemStack(is10));
				
				int r = u - 500;
				String t = Integer.toString(r);
				score.setEco(p, t);
				
				p.closeInventory();
				e.setCancelled(true);
			}
				
			else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Infinity") && u < 500){
				p.closeInventory();
				e.setCancelled(true);
				p.sendMessage(prefixe + "Vous n'avez pas assez d'argent.");
			}
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Adam") && u >= 600) {
				p.getInventory().clear();
				p.removePotionEffect(PotionEffectType.SPEED);
				
				ItemStack is = new ItemStack(Material.DIAMOND_HELMET, 1); // Les bottes en cuir seront l'item à donner, et à modifier.
			    is.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 3);
				p.getInventory().setHelmet(new ItemStack(is));
				
				ItemStack is2 = new ItemStack(Material.DIAMOND_CHESTPLATE, 1); 
			    is2.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 3);
				p.getInventory().setChestplate(new ItemStack(is2));
				
				ItemStack is3 = new ItemStack(Material.DIAMOND_LEGGINGS, 1); 
			    is3.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 3);
				p.getInventory().setLeggings(new ItemStack(is3));
				
				ItemStack is4 = new ItemStack(Material.DIAMOND_BOOTS, 1); 
			    is4.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 3);
				p.getInventory().setBoots(new ItemStack(is4));
				
				ItemStack is5 = new ItemStack(Material.IRON_SWORD, 1);
				is5.addEnchantment(EnchantmentWrapper.DAMAGE_ALL, 3);
			    is5.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 3);
				p.getInventory().addItem(new ItemStack(is5));
				
				
				ItemStack is6 = new ItemStack (Material.POTION, 1);
				PotionMeta meta6 = (PotionMeta) is6.getItemMeta();
				meta6.addCustomEffect((new PotionEffect(PotionEffectType.HEAL, 1, 1)),true );
				meta6.setMainEffect(PotionEffectType.HEAL);
				meta6.setDisplayName("Eternal Potion");
				meta6.setDisplayName("Spécialité de " + ChatColor.GOLD + "Moderncraft");
				is6.setItemMeta(meta6);
				p.getInventory().addItem(new ItemStack(is6));
				p.getInventory().addItem(new ItemStack(is6));
				
				ItemStack is7 = new ItemStack(Material.GOLDEN_APPLE, 1);
				p.getInventory().addItem(new ItemStack(is7));
				
				ItemStack is10 = new ItemStack(Material.COOKED_BEEF, 16);
				p.getInventory().addItem(new ItemStack(is10));
				
				int r = u - 600;
				String t = Integer.toString(r);
				score.setEco(p, t);
				
				p.closeInventory();
				e.setCancelled(true);
			}
				
			else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Adam") && u < 600){
				p.closeInventory();
				e.setCancelled(true);
				p.sendMessage(prefixe + "Vous n'avez pas assez d'argent.");
			}
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Eve") && u >= 350) {
				p.getInventory().clear();
				p.removePotionEffect(PotionEffectType.SPEED);
				
				ItemStack is = new ItemStack(Material.DIAMOND_HELMET, 1); // Les bottes en cuir seront l'item à donner, et à modifier.
			    is.addEnchantment(EnchantmentWrapper.DURABILITY, 3);
				p.getInventory().setHelmet(new ItemStack(is));
				
				ItemStack is2 = new ItemStack(Material.DIAMOND_CHESTPLATE, 1); 
			    is2.addEnchantment(EnchantmentWrapper.DURABILITY, 3);
				p.getInventory().setChestplate(new ItemStack(is2));
				
				ItemStack is3 = new ItemStack(Material.DIAMOND_LEGGINGS, 1); 
			    is3.addEnchantment(EnchantmentWrapper.DURABILITY, 3);
				p.getInventory().setLeggings(new ItemStack(is3));
				
				ItemStack is4 = new ItemStack(Material.DIAMOND_BOOTS, 1); 
			    is4.addEnchantment(EnchantmentWrapper.DURABILITY, 3);
				p.getInventory().setBoots(new ItemStack(is4));
				
				ItemStack is5 = new ItemStack(Material.DIAMOND_SWORD, 1);
			    is5.addEnchantment(EnchantmentWrapper.DURABILITY, 3);
				p.getInventory().addItem(new ItemStack(is5));
				
				ItemStack is6 = new ItemStack (Material.POTION, 1);
				PotionMeta meta6 = (PotionMeta) is6.getItemMeta();
				meta6.addCustomEffect((new PotionEffect(PotionEffectType.HEAL, 1, 1)),true );
				meta6.setMainEffect(PotionEffectType.HEAL);
				meta6.setDisplayName("Eternal Potion");
				meta6.setDisplayName("Spécialité de " + ChatColor.GOLD + "Moderncraft");
				is6.setItemMeta(meta6);
				p.getInventory().addItem(new ItemStack(is6));
				p.getInventory().addItem(new ItemStack(is6));
				
				ItemStack is7 = new ItemStack(Material.GOLDEN_CARROT, 16);
				p.getInventory().addItem(new ItemStack(is7));
				
				ItemStack is10 = new ItemStack(Material.COOKED_BEEF, 16);
				p.getInventory().addItem(new ItemStack(is10));
				
				int r = u - 350;
				String t = Integer.toString(r);
				score.setEco(p, t);
				
				p.closeInventory();
				e.setCancelled(true);
			}
				
			else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Eve") && u < 350){
				p.closeInventory();
				e.setCancelled(true);
				p.sendMessage(prefixe + "Vous n'avez pas assez d'argent.");
			}
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Piquant") && u >= 700) {
				p.getInventory().clear();
				p.removePotionEffect(PotionEffectType.SPEED);
				
			    ItemStack is = new ItemStack(Material.DIAMOND_HELMET, 1); // Les bottes en cuir seront l'item à donner, et à modifier.
			    is.addEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 2);
			    is.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 1);
				p.getInventory().setHelmet(new ItemStack(is));
				
				ItemStack is2 = new ItemStack(Material.DIAMOND_CHESTPLATE, 1); 
			    is2.addEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 2);
			    is.addUnsafeEnchantment(EnchantmentWrapper.THORNS, 3);
			    is2.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 1);
				p.getInventory().setChestplate(new ItemStack(is2));
				
				ItemStack is3 = new ItemStack(Material.DIAMOND_LEGGINGS, 1); 
			    is3.addEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 2);
			    is3.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 1);
				p.getInventory().setLeggings(new ItemStack(is3));
				
				ItemStack is4 = new ItemStack(Material.DIAMOND_BOOTS, 1); 
			    is4.addEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 2);
			    is4.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 1);
				p.getInventory().setBoots(new ItemStack(is4));
				
				ItemStack is5 = new ItemStack(Material.STONE_SWORD, 1);
			    is5.addEnchantment(EnchantmentWrapper.DAMAGE_ALL, 3);
			    is5.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
				p.getInventory().addItem(new ItemStack(is5));
				
				ItemStack is6 = new ItemStack (Material.POTION, 1);
				PotionMeta meta6 = (PotionMeta) is6.getItemMeta();
				meta6.addCustomEffect((new PotionEffect(PotionEffectType.HEAL, 1, 1)),true );
				meta6.setMainEffect(PotionEffectType.HEAL);
				meta6.setDisplayName("Eternal Potion");
				meta6.setDisplayName("Spécialité de " + ChatColor.GOLD + "Moderncraft");
				is6.setItemMeta(meta6);
				p.getInventory().addItem(new ItemStack(is6));
				p.getInventory().addItem(new ItemStack(is6));
				
				ItemStack is10 = new ItemStack(Material.COOKED_BEEF, 16);
				p.getInventory().addItem(new ItemStack(is10));
				
				int r = u - 700;
				String t = Integer.toString(r);
				score.setEco(p, t);
				
				p.closeInventory();
				e.setCancelled(true);
			}
				
			else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Piquant") && u < 700){
				p.closeInventory();
				e.setCancelled(true);
				p.sendMessage(prefixe + "Vous n'avez pas assez d'argent.");
			}
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Sniper") && u >= 1000) {
				p.getInventory().clear();
				p.removePotionEffect(PotionEffectType.SPEED);
				
			    ItemStack is = new ItemStack(Material.DIAMOND_HELMET, 1); // Les bottes en cuir seront l'item à donner, et à modifier.
			    is.addEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 1);
			    is.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
				p.getInventory().setHelmet(new ItemStack(is));
				
				ItemStack is2 = new ItemStack(Material.DIAMOND_CHESTPLATE, 1); 
			    is2.addEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 1);
			    is2.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
			    is2.addUnsafeEnchantment(EnchantmentWrapper.THORNS, 2);
				p.getInventory().setChestplate(new ItemStack(is2));
				
				ItemStack is3 = new ItemStack(Material.DIAMOND_LEGGINGS, 1); 
			    is3.addEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 1);
			    is3.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
				p.getInventory().setLeggings(new ItemStack(is3));
				
				ItemStack is4 = new ItemStack(Material.DIAMOND_BOOTS, 1); 
			    is4.addEnchantment(EnchantmentWrapper.PROTECTION_ENVIRONMENTAL, 1);
			    is4.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
				p.getInventory().setBoots(new ItemStack(is4));
				
				ItemStack is8 = new ItemStack(Material.IRON_SWORD);
				is8.addUnsafeEnchantment(EnchantmentWrapper.DURABILITY, 10);
				is8.addEnchantment(EnchantmentWrapper.DAMAGE_ALL, 4);
				p.getInventory().addItem(new ItemStack(is8));
				
				ItemStack is5 = new ItemStack(getItemStackByID(Material.BOW, "Le Sniper", "Précision...", 1,(short) 374));
			    is5.addUnsafeEnchantment(EnchantmentWrapper.ARROW_DAMAGE, 100);
				p.getInventory().addItem(new ItemStack(is5));
				
				ItemStack is6 = new ItemStack (Material.POTION, 1);
				PotionMeta meta6 = (PotionMeta) is6.getItemMeta();
				meta6.addCustomEffect((new PotionEffect(PotionEffectType.HEAL, 1, 1)),true );
				meta6.setMainEffect(PotionEffectType.HEAL);
				meta6.setDisplayName("Eternal Potion");
				meta6.setDisplayName("Spécialité de " + ChatColor.GOLD + "Moderncraft");
				is6.setItemMeta(meta6);
				p.getInventory().addItem(new ItemStack(is6));
				p.getInventory().addItem(new ItemStack(is6));
				
				ItemStack is7 = new ItemStack(Material.ARROW, 5);
				p.getInventory().addItem(new ItemStack(is7));
				
				ItemStack is10 = new ItemStack(Material.COOKED_BEEF, 32);
				p.getInventory().addItem(new ItemStack(is10));
				
				int r = u - 1000;
				String t = Integer.toString(r);
				score.setEco(p, t);
				
				p.closeInventory();
				e.setCancelled(true);
			}
				
			else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Sniper") && u < 1000){
				p.closeInventory();
				e.setCancelled(true);
				p.sendMessage(prefixe + "Vous n'avez pas assez d'argent.");
			}
		}
	}
	

public static ItemStack getItemStackByID(Material m, String name, String lore, int amount, short id){
	ItemStack is = new ItemStack(m,amount,id);
	ItemMeta im = is.getItemMeta();
	im.setDisplayName(name);
	im.setLore(Arrays.asList(lore));
	is.setItemMeta(im);
	return is;
}
}