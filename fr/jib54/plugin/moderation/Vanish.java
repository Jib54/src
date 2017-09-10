package fr.jib54.plugin.moderation;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.jib54.plugin.Main;

public class Vanish implements Listener {

	ArrayList<Player> toogle = new ArrayList();

	@EventHandler
	public void onClicOnSitck(PlayerInteractEvent e) {

		Player p = e.getPlayer();

		if (!p.getItemInHand().hasItemMeta()) {
			return;
		}

		if (Main.modo.contains(p.getName())) {
			if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {

				if (p.getItemInHand().getItemMeta().getDisplayName().equals("§6➜ §eVanish")) {

					if (toogle.contains(p)) {
						p.sendMessage("§8[§cModération§8] §3Vanish §8» §aInactif ");
						for (Player pls : Bukkit.getOnlinePlayers()) {
							pls.showPlayer(p);
						}

						toogle.remove(p);
					} else {
						p.sendMessage("§8[§cModération§8] §3Vanish §8» §aActif ");
						for (Player pls : Bukkit.getOnlinePlayers()) {
							if (p != pls) {
								pls.hidePlayer(p);
							}

							toogle.add(p);
						}

					}
				}
			}
		}

	}

	@EventHandler
	public void join(PlayerJoinEvent e) {
		Player p = e.getPlayer();

		for (Player pls : toogle) {
		   p.hidePlayer(pls);
		}
	}

	@EventHandler
	public void join(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		
		Main.cps.put(p, 0);
		if (toogle.contains(e.getPlayer())) {
			toogle.remove(e.getPlayer());
		}
	}

}
