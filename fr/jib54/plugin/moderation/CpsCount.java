package fr.jib54.plugin.moderation;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import fr.jib54.plugin.Main;

public class CpsCount implements Listener {

	@EventHandler
	public void on(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
			if (Main.cps.get(p) == null) {
				Main.cps.put(p, 0);
			} else {
				Main.cps.put(p, Main.cps.get(p) + 1);
			}

			

			if (Main.cps.get(p) > 21) {
				for (Player all : Bukkit.getOnlinePlayers()) {
					if (all.isOp() || all.hasPermission("mod")) {
						all.sendMessage("§8[§cModération§8] §a" + p.getName() + "  §8» §eAutoclick§7§l: §d"
								+ Main.cps.get(p) + " CPS");
					}

				}
			}

		}
	}

}
