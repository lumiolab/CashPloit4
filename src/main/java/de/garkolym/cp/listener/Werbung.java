package de.garkolym.cp.listener;

import de.garkolym.cp.Start;
import org.bukkit.Bukkit;

public class Werbung implements Runnable {

    public void run() {
        for (String user : Start.INSTANCE.trustedPlayers) {
            try {
                Bukkit.getPlayer(user).sendMessage(Start.INSTANCE.chatPrefix + "WERBUNG");
                Bukkit.getPlayer(user).sendMessage(Start.INSTANCE.chatPrefix + "§bWenn dir das Plugin gefällt, komm doch auf meinen discord server: dsc.gg/krabbe");
                Bukkit.getPlayer(user).sendMessage(Start.INSTANCE.chatPrefix + "Ich code dort gerne neue Sachen!");
            } catch (Exception ignored) {
            }
        }
    }

}
