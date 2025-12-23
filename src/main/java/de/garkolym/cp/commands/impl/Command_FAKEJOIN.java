package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Command_FAKEJOIN extends CommandBase {

    public Command_FAKEJOIN() {
        super("fakejoin", "<Spieler> [CustomJoinMessage]", Category.OTHER);
    }

    @Override
    public void execute(String[] args, Player p) {

        if (args.length < 1) {
            p.sendMessage(Start.INSTANCE.chatPrefix + "Usage: #fakejoin <Spieler> [Message]");
            return;
        }

        String playerName = args[0];
        String message;

        if (args.length == 1) {
            message = ChatColor.YELLOW + playerName + " joined the game.";
        } else {
            message = String.join(" ", args).substring(playerName.length() + 1);

            if (!message.contains("$")) {
                p.sendMessage(Start.INSTANCE.chatPrefix + "Die Message muss $ enthalten. ($ = Spieler)");
                return;
            }

            message = ChatColor.translateAlternateColorCodes('&',
                    message.replace("$", playerName)
            );
        }

        p.sendMessage(Start.INSTANCE.chatPrefix + "Fake Join gesendet.");

        for (Player online : Bukkit.getOnlinePlayers()) {
            online.sendMessage(message);
        }
    }
}
