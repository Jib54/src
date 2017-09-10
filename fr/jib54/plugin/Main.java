package fr.jib54.plugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.jib54.plugin.commands.CommandModeration;
import fr.jib54.plugin.moderation.BlockPlace;
import fr.jib54.plugin.moderation.ClickEvent;
import fr.jib54.plugin.moderation.CpsCount;
import fr.jib54.plugin.moderation.Drop;
import fr.jib54.plugin.moderation.Freeze;
import fr.jib54.plugin.moderation.ItemPickup;
import fr.jib54.plugin.moderation.QuitMode;
import fr.jib54.plugin.moderation.TpRandom;
import fr.jib54.plugin.moderation.Vanish;

public class Main extends JavaPlugin {
	public static ArrayList<String> modo = new ArrayList<String>();
	public static HashMap<Player, Integer> cps = new HashMap<>();
	public static ArrayList<String> freeze = new ArrayList<String>();

	public static Main instance;

	public void clearCps() {

		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

			@Override
			public void run() {
				for (Player p : cps.keySet()) {
					cps.put(p, Integer.valueOf(0));
				}

			}
		}, 0, 20);

	

	

      

		super.onEnable();

		getCommand("moderation").setExecutor(new CommandModeration());
		getCommand("modmenu").setExecutor(new CommandMenu());
		clearCps();

		instance = this;
		// Event
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new ClickEvent(), (this));
		pm.registerEvents(new Freeze(), (this));
		pm.registerEvents(new TpRandom(), (this));
		pm.registerEvents(new QuitMode(), (this));
		pm.registerEvents(new Drop(), (this));
		pm.registerEvents(new BlockPlace(), (this));
		pm.registerEvents(new ItemPickup(), (this));
		pm.registerEvents(new Vanish(), (this));
		pm.registerEvents(new CpsCount(), (this));
		pm.registerEvents(new ClicMenu(), (this));

	}

}
