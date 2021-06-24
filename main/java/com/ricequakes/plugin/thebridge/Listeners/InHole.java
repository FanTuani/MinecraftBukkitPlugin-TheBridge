package com.ricequakes.plugin.thebridge.Listeners;

import com.ricequakes.plugin.thebridge.Game.Game;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class InHole implements Listener {
    @EventHandler
    public void onPlayerInHole(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location location = player.getLocation();
        location.setY(location.getY() - 1);
        if (location.getBlock().getType() == Material.REDSTONE_BLOCK && Game.isBlue(player)) { // Blue in Red
            Game.tpPlayersToHome();
            Game.blueScore++;
            Game.publishScore();
            if (Game.blueScore == 5) {
                Game.win(player);
            }
            Game.initPlayerKits(player);
            Game.clearBlocks();
        } else if (location.getBlock().getType() == Material.LAPIS_BLOCK && Game.isRed(player)) { // Red in Blue
            Game.tpPlayersToHome();
            Game.redScore++;
            Game.publishScore();
            if (Game.redScore == 5) {
                Game.win(player);
            }
            Game.initPlayerKits(player);
            Game.clearBlocks();
        } else if (location.getBlock().getType() == Material.LAPIS_BLOCK && Game.isBlue(player)
                || location.getBlock().getType() == Material.REDSTONE_BLOCK && Game.isRed(player)) { // X in X
            if (Game.isRed(player)) player.teleport(Game.redHome);
            if (Game.isBlue(player)) player.teleport(Game.blueHome);
            Game.initPlayerKits(player);
        }

    }
}
