package com.ricequakes.plugin.thebridge.Listeners;

import com.ricequakes.plugin.thebridge.Game.Game;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class AntiVoid implements Listener {
    @EventHandler
    public void onPlayerIntoVoid(PlayerMoveEvent event) {
        if (event.getPlayer().getLocation().getY() < Game.voidY && !event.getPlayer().getAllowFlight()) {
            Player player = event.getPlayer();
            if (Game.isBlue(player)) player.teleport(Game.blueHome);
            else if (Game.isRed(player)) player.teleport(Game.redHome);
            Game.initPlayerKits(player);
            player.setHealth(20);
        }
    }
}
