package com.ricequakes.plugin.thebridge.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class NoHungry implements Listener {
    @EventHandler
    public void onHungry(FoodLevelChangeEvent event) {
        event.setCancelled(true);
    }
}
