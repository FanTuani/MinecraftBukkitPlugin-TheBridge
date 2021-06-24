package com.ricequakes.plugin.thebridge.Listeners;

import com.ricequakes.plugin.thebridge.Game.Game;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakBlock implements Listener {
    @EventHandler
    public void onBreakBlock(BlockBreakEvent event) {
        if(!event.getPlayer().getAllowFlight()) {
            if(!Game.blockLocs.contains(event.getBlock().getLocation())) {
                event.setCancelled(true);
            }
        }
    }
}
