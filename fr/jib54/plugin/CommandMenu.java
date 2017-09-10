package fr.jib54.plugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.jib54.plugin.manager.VerifGui;

public class CommandMenu implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender.hasPermission("mod") || sender.isOp()) {

			if (sender instanceof Player) {
				
				Player p = (Player) sender;
				if (args.length == 0) {
					sender.sendMessage("§8[§cModération§8] §eMauvaise utilisation de la commande !");
					return false;
				}
				
				if (args.length == 1) {
					Player t = Bukkit.getPlayer(args[0]);
					if (t == null) {
						sender.sendMessage(
								"§8[§cModération§8] §eVérifier le pseudo du joueur, car, le joueur est introuvable.");
					} else {
						VerifGui.openInventory(p, t);
					}
				}
			} else {
				return false;
			}
			
		} else {
			sender.sendMessage("§8[§cModération§8] §eVous n'avez pas la permission");

		}
		return false;
	}

}
