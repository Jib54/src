package fr.jib54.plugin.manager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ItemSave {
	public static void saveInv(Player p) {
		ArrayList<ItemStack> list = new ArrayList();
		File f = new File("plugins//Mod//Inventory//" + p.getName() + ".yml");
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				p.sendMessage(ChatColor.RED + "Les fichiers ont été recréer");
			}
			YamlConfiguration inv = YamlConfiguration.loadConfiguration(f);
			ItemStack[] contents = p.getInventory().getContents();
			for (int i = 0; i < contents.length; i++) {
				ItemStack item = contents[i];
				list.add(item);
			}
			inv.set("Inventory", list);
			try {
				inv.save(f);
			} catch (IOException e) {
				p.sendMessage(ChatColor.RED + "Erreur dans la sauvegarde des fichiers !");
			}
			p.getInventory().clear();
			p.updateInventory();
		}
	}

	public static void loadInv(Player p) {
		p.getInventory().clear();
		File f = new File("plugins//Mod//Inventory//" + p.getName() + ".yml");
		if (f.exists()) {
			YamlConfiguration inv = YamlConfiguration.loadConfiguration(f);
			ItemStack[] contents = p.getInventory().getContents();
			List<?> list = inv.getList("Inventory");
			for (int i = 0; i < list.size(); i++) {
				contents[i] = ((ItemStack) list.get(i));
				p.getInventory().setItem(i, contents[i]);
			}
			f.delete();
			p.updateInventory();
		}
	}
}
