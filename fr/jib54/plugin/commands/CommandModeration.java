package fr.jib54.plugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.jib54.plugin.Main;
import fr.jib54.plugin.manager.ItemSave;
import fr.jib54.plugin.manager.ManagerItem;

public class CommandModeration implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("moderation")) {
			if (sender.hasPermission("moderation.use") || sender.isOp()) {
				if(sender instanceof Player){
					Player p = (Player) sender;
					if(Main.modo.contains(p.getName())){

						Main.modo.remove(p.getName());
						ItemSave.loadInv(p);
						p.sendMessage("§8[§cModération§8] §4✗ §cMode désactivé, vous êtes désormais visible.");
						p.setAllowFlight(true);
						p.setFlying(false);
						return true;
					}
					Main.modo.add(p.getName());
					p.sendMessage("§8[§cModération§8] §2✔ §aMode activé, vous êtes désormais invisible");
                    ItemSave.saveInv(p);
					p.setAllowFlight(true);
					p.setFlying(true);
					ManagerItem.ItemGive(p);
					
				} else{
					sender.sendMessage("Vous n'etes pas un joueur");
				}

			} else {
               sender.sendMessage(ChatColor.DARK_GRAY + "Vous n'avez pas la permission");
			}
		}
		return false;
	}

}
