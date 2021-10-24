package de.coolepizza.bingo.commands;

import de.coolepizza.bingo.Bingo;
import de.coolepizza.bingo.manager.BingoManager;
import de.coolepizza.bingo.team.Team;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class GlobalChatCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            return false;
        }
        if (Bingo.getBingoManager().bingoState == BingoManager.BingoState.INGAME) {
            Player player = (Player) commandSender;
            Team team = Bingo.getBingoManager().getTeamManager().getTeamFromPlayer(((Player) commandSender));
            if (team != Team.SPECTATOR) {
                if (strings.length == 0) {
                    commandSender.sendMessage("§cDu musst eine Nachricht eingeben!");
                    return false;
                }
                StringBuilder message = new StringBuilder(" ");
                for (String string : strings) {
                    message.append(string).append(" ");
                }
                for (Player uuid : Bukkit.getOnlinePlayers()) {

                    uuid.sendMessage("§Global§7» §a" + player.getName() + "§7:" + message);

                }
            }
        } else {
            commandSender.sendMessage("§cDieser Command ist nur während des Spiels freigeschaltet!");
        }
        return true;
    }
}
