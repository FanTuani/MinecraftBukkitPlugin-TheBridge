package com.ricequakes.plugin.thebridge.Listeners;

import com.ricequakes.plugin.thebridge.Game.Game;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class ResurrectTeleport implements Listener {
    @EventHandler
    public void onPlayerResurrect(EntityDamageEvent event) {
        if(event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if(player.getHealth() - event.getFinalDamage() <= 0) {
                event.setCancelled(true);
                player.setHealth(20);
                if(Game.isBlue(player)) player.teleport(Game.blueHome);
                else if (Game.isRed(player)) player.teleport(Game.redHome);
                Game.initPlayerKits(player);
            }
        }
    }
}
