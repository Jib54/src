package fr.jib54.plugin.moderation;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.jib54.plugin.Main;

public class QuitMode implements Listener {
	
	
	
	@EventHandler
	public void onRightClick(PlayerInteractEvent e){

		Player p = e.getPlayer();
		if(Main.modo.contains(p.getName())){
			if(e.getAction() == Action.RIGHT_CLICK_AIR){
				
				ItemStack quit = new ItemStack(Material.REDSTONE, 1);
				ItemMeta quitM = quit.getItemMeta();
				quitM.setDisplayName(ChatColor.DARK_RED + "Quitter le mode modo");
				quitM.addEnchant(Enchantment.KNOCKBACK, 1, true);
				quit.setItemMeta(quitM);
				
				if(p.getItemInHand().getItemMeta().equals(quitM)){
					p.performCommand("moderation");

				}
			}
		}
	}

}
