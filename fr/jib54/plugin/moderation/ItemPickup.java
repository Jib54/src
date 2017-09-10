package fr.jib54.plugin.moderation;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import fr.jib54.plugin.Main;

public class ItemPickup implements Listener {
	
	@EventHandler
	public void onPickup(PlayerPickupItemEvent e){
		Player p = e.getPlayer();
		if(Main.modo.contains(p.getName())){
			e.setCancelled(true);
		}
	}

}
