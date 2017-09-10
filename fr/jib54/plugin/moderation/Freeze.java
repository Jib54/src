package fr.jib54.plugin.moderation;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import fr.jib54.plugin.Main;

public class Freeze implements Listener {
	
	@EventHandler
	public void onMoove(PlayerMoveEvent e){
		Player p = e.getPlayer();
		if(Main.freeze.contains(p.getName())){
			e.setTo(e.getFrom());
			e.setCancelled(true);

		} 
	}

}
