package fr.jib54.plugin.moderation;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.jib54.plugin.Main;
import fr.jib54.plugin.manager.VerifGui;

public class ClickEvent implements Listener {

	@EventHandler
	public void onClickEntity(PlayerInteractAtEntityEvent event) {
		if (event.getRightClicked() instanceof Player) {

			Player t = (Player) event.getRightClicked();
			Player p = event.getPlayer();
			if (Main.modo.contains(p.getName())) {



				if (p.hasPermission("mod") || p.isOp()) {
					if (p.getItemInHand() == null) {
						return;
					}
					 if (p.getItemInHand().getItemMeta().getDisplayName().equals("§6➜ §eInventaire du joueur ")) {
						p.openInventory(t.getInventory());
				

					} else if (p.getItemInHand().getItemMeta().getDisplayName().equals("§6➜ §eFreeze le joueur")) {
						if (!Main.freeze.contains(t.getName())) {
							Main.freeze.add(t.getName());
							for (Player all : Bukkit.getOnlinePlayers()) {
								if (all.hasPermission("mod")) {
									all.sendMessage("§8[§cModération§8] §7Le joueur §e" + t.getName()
											+ " §7a été freeze par §c" + p.getName() + "§7.");
								}
							}
						} else {
							for (Player all : Bukkit.getOnlinePlayers()) {
								if (all.hasPermission("mod")) {
									all.sendMessage("§8[§cModération§8] §7Le joueur §e" + t.getName()
											+ " §7a été unfreeze par §c" + p.getName() + "§7.");
								}
							}
							Main.freeze.remove(t.getName());
						}

					} else if (p.getItemInHand().getItemMeta().getDisplayName().equals("§6➜ §eSuivre")) {
						t.setPassenger(p);

					} else if (p.getItemInHand().getItemMeta().getDisplayName().equals("§6➜ §eInformation du joueur")){
						
						VerifGui.openInventory(p, t);
					}

				}

			}

		}

	}

}
