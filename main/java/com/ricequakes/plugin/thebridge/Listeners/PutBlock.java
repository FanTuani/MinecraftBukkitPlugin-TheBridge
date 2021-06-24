package com.ricequakes.plugin.thebridge.Listeners;

import com.ricequakes.plugin.thebridge.Game.Game;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PutBlock implements Listener {
    @EventHandler
    public void onPutBlock(BlockPlaceEvent event) {
        if(!event.getPlayer().getAllowFlight()) {
            Location location = event.getBlock().getLocation();
            Game.blockLocs.add(location);
        }
    }
}
