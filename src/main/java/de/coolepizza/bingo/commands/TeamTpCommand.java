package de.coolepizza.bingo.commands;

import de.coolepizza.bingo.Bingo;
import de.coolepizza.bingo.manager.BingoManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeamTpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (!(commandSender instanceof Player) || args.length ==0) return false;
        if (Bingo.getBingoManager().bingoState == BingoManager.BingoState.INGAME) {
            Player to = Bukkit.getPlayer(args[0]);
            if(to == null) return true;
            if(!Bingo.getBingoManager().getTeamManager().getPlayersInTeam(Bingo.getBingoManager().getTeamManager().getTeamFromPlayer((Player) commandSender)).contains(to.getUniqueId())) return true;
            Player from = (Player) commandSender;

            from.teleport(to);
            from.sendMessage(ChatColor.BLUE+"Du wurdest zu deinem Team-Partner " + ChatColor.WHITE +to.getName()+ChatColor.BLUE+" teleportiert!");
        }

        return true;
    }

}
