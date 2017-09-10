package fr.jib54.plugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ClicMenu implements Listener {

	@EventHandler
	public void on(InventoryClickEvent e) {
		if (e.getInventory().getName().startsWith("§4Info du joueur ")) {

			
			if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) {
				return;
			}
			if (!e.getCurrentItem().hasItemMeta()) {
				return;
			}
			

			e.setCancelled(true);

			String player = e.getInventory().getName().replace("§4Info du joueur ", "");
			Player p = Bukkit.getPlayer(player);
			Player clic = (Player) e.getWhoClicked();
			

			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §eSe tp au joueur")) {
				
				p.closeInventory();
				clic.teleport(p.getLocation());

			} else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §eFreeze/Unfreeze")) {
				if (!Main.freeze.contains(p.getName())) {
					Main.freeze.add(p.getName());

				} else {

					Main.freeze.remove(p.getName());
				}
			}
		}
	}

}
