/**
 * 
 */
package fr.jib54.plugin.manager;

import java.text.DecimalFormat;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.scheduler.BukkitRunnable;

import fr.jib54.plugin.Lag;
import fr.jib54.plugin.Main;

/**
 * @author Jibril
 *
 */
public class VerifGui {

	public static void openInventory(Player p, Player t) {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.instance, new Lag(), 100L, 1L);
		Inventory inv = Bukkit.createInventory(null, InventoryType.CHEST, "§4Info du joueur " + t.getName());

		ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());

		SkullMeta meta = (SkullMeta) skull.getItemMeta();
		meta.setOwner(p.getName());
		meta.setDisplayName("§4" + p.getName());
		skull.setItemMeta(meta);
		inv.setItem(0, skull);
		
		
	
		inv.setItem(26, skull);
		
		double TPS = Lag.getTPS();
		DecimalFormat TpsFormat = new DecimalFormat("#.##");

		new BukkitRunnable() {

			@Override
			public void run() {
				if (p.getOpenInventory().getTitle().equals("§4Info du joueur " + t.getName())) {
					
					inv.setItem(1, item(Material.STAINED_GLASS_PANE, 1, (short) 7, "   ", ""));
					inv.setItem(17, item(Material.STAINED_GLASS_PANE, 1, (short) 7, "   ", ""));
					inv.setItem(7, item(Material.STAINED_GLASS_PANE, 1, (short) 7, "   ", ""));
					inv.setItem(8, item(Material.STAINED_GLASS_PANE, 1, (short) 4, "   ", ""));
					inv.setItem(9, item(Material.STAINED_GLASS_PANE, 1, (short) 7, "   ", ""));
					inv.setItem(18, item(Material.STAINED_GLASS_PANE, 1, (short) 4, "   ", ""));
					inv.setItem(19, item(Material.STAINED_GLASS_PANE, 1, (short) 7, "   ", ""));
					inv.setItem(25, item(Material.STAINED_GLASS_PANE, 1, (short) 7, "   ", ""));
					
					inv.setItem(
							5, item(
									Material.IRON_BOOTS, 1, (short) 0, "§8» §eLocation §a : X:" + p.getLocation().getX()
											+ " Y:" + p.getLocation().getY() + " Z:" + p.getLocation().getBlockZ(),
									""));
					
					
					inv.setItem(11, item(Material.NETHER_STAR, 1,(short) 0, "§8» §eTps §a: " + TpsFormat.format(TPS), ""));
					inv.setItem(13, item(Material.IRON_INGOT, 1,(short) 0, "§8» §eCps: " + Main.cps.get(t), ""));
					inv.setItem(23, item(Material.FEATHER, 1,(short) 0, "§8» §eSe tp au joueur", ""));
					inv.setItem(21, item(Material.BLAZE_ROD, 1,(short) 0, "§8» §eFreeze/Unfreeze", ""));

					String gamemode = "" + p.getGameMode();
					if (p.isFlying()) {
						inv.setItem(4,
								item(Material.PAPER, 1, (short) 0,"§8» §eVie: §a " + p.getHealth() + " §4§8» §eTemps de jeux: " + p.getPlayerTime() + " §8» §eMode de jeux: " + gamemode.toLowerCase() + " §8» §eFly: Oui",""));

					}
					if (!p.isFlying()) {
						inv.setItem(4,
								item(Material.PAPER, 1, (short) 0,"§8» §eVie: §a " + p.getHealth() + " §4§8» §eTemps de jeux: " + p.getPlayerTime() + " §8» §eMode de jeux: " + gamemode.toLowerCase() + " §8» §eFly: Non",""));
						

					}
					
					if(Main.freeze.contains(t.getName())){
						inv.setItem(3, item(Material.PACKED_ICE, 1, (short) 7, "§4§8» §eFreeze: Oui", ""));
					} else {
						inv.setItem(3, item(Material.PACKED_ICE, 1, (short) 7, "§4§8» §eFreeze: Non", ""));

					}

				} else {
					cancel();
				}
			}
		}.runTaskTimer(Main.instance, 0, 20);

		p.openInventory(inv);

	}

	private static ItemStack item(Material block, int num, short b, String name, String line1) {
		ItemStack item = new ItemStack(block, num, b);
		ItemMeta itemM = item.getItemMeta();
		itemM.setDisplayName(name);
		ArrayList<String> desc = new ArrayList<>();
		desc.clear();
		desc.add(line1);
		itemM.setLore(desc);
		item.setItemMeta(itemM);
		return item;
	}

}
