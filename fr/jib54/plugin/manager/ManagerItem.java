package fr.jib54.plugin.manager;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ManagerItem {

	public static void ItemGive(Player p) {


	



		ItemStack inv = new ItemStack(Material.BOOK, 1);
		ItemMeta invM = inv.getItemMeta();
		invM.setDisplayName("§6➜ §eInventaire du joueur ");
		inv.setItemMeta(invM);

		ItemStack kb = new ItemStack(Material.WOOD_SWORD, 1);
		ItemMeta kbvM = kb.getItemMeta();
		kbvM.setDisplayName("§6➜ §eTest du knockback");
		kbvM.addEnchant(Enchantment.KNOCKBACK, 4, true);
		kb.setItemMeta(kbvM);

		ItemStack freeze = new ItemStack(Material.PACKED_ICE, 1);
		ItemMeta freezeM = freeze.getItemMeta();
		freezeM.setDisplayName("§6➜ §eFreeze le joueur");
		freeze.setItemMeta(freezeM);

		ItemStack info = new ItemStack(Material.INK_SACK, 1, (short) 2);
		ItemMeta infoM = info.getItemMeta();
		infoM.setDisplayName( "§6➜ §eInformation du joueur");

		info.setItemMeta(infoM);

		ItemStack clear = new ItemStack(Material.CARROT_STICK, 1);
		ItemMeta clearM = clear.getItemMeta();
		clearM.setDisplayName("§6➜ §eSuivre");

		clear.setItemMeta(clearM);

		ItemStack tp = new ItemStack(Material.EYE_OF_ENDER, 1);
		ItemMeta tpM = tp.getItemMeta();
		tpM.setDisplayName("§6➜ §eTp random");
		tp.setItemMeta(tpM);

		ItemStack hidder = new ItemStack(Material.SUGAR);
		ItemMeta hidderM = hidder.getItemMeta();
		hidderM.setDisplayName("§6➜ §eVanish");
		hidder.setItemMeta(hidderM);

		p.getInventory().setItem(1, tp);
		p.getInventory().setItem(6, freeze);
		p.getInventory().setItem(5, info);
		p.getInventory().setItem(3, kb);
		p.getInventory().setItem(4, inv);
		p.getInventory().setItem(7, clear);
		p.getInventory().setItem(2, hidder);
	}

}
