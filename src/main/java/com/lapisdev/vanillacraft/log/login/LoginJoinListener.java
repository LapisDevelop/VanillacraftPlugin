package com.lapisdev.vanillacraft.log.login;

import com.lapisdev.vanillacraft.player.ServerPlayer;
import com.lapisdev.vanillacraft.task.RunTask;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class LoginJoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        RunTask.async((_) -> {
            ServerPlayer player = ServerPlayer.fromMinecraftUuid(e.getPlayer().getUniqueId());
            if (player == null) {
                return; // will soon be kicked for not linking
            }
            PlayerLogin login = new PlayerLogin(player, System.currentTimeMillis(), e.getPlayer().getLocation());
            login.save();
        });
    }
}
