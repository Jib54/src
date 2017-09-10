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
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.jib54.plugin.Main;

public class TpRandom implements Listener {

	ArrayList<Player> playeronline = new ArrayList();

	@EventHandler
	public void onRightClick(PlayerInteractEvent e) {

		Player p = e.getPlayer();
		if (Main.modo.contains(p.getName())) {
			if (e.getAction() == Action.RIGHT_CLICK_AIR) {



				if (p.getItemInHand().getItemMeta().getDisplayName().equals("§6➜ §eTp random")) {

					int randomNumer = new Random().nextInt(Bukkit.getOnlinePlayers().size());
					Player p1 = (Player) getServer().getOnlinePlayers().toArray()[randomNumer];

					p.teleport(p1);
					p.sendMessage("§8[§cModération§8] §eTéléportation sur §d" + p1.getName() + "§e !");
					e.setCancelled(true);

				}
			}
		}
	}

	private Server getServer() {
		return Bukkit.getServer();
	}

}
