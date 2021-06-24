package com.ricequakes.plugin.thebridge;

import com.ricequakes.plugin.thebridge.Commands.GameStop;
import com.ricequakes.plugin.thebridge.Commands.SetHome;
import com.ricequakes.plugin.thebridge.Commands.SetVoid;
import com.ricequakes.plugin.thebridge.Commands.StartGame;
import com.ricequakes.plugin.thebridge.Listeners.*;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class TheBridge extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        registerCommands();
        saveDefaultConfig();
        registerListeners();
    }

    @Override
    public void onDisable() {

    }

    private void registerCommands() {
        getCommand("sh").setExecutor(new SetHome(this));
        getCommand("start").setExecutor(new StartGame(this));
        getCommand("setvoid").setExecutor(new SetVoid(this));
        getCommand("gamestop").setExecutor(new GameStop(this));
    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new NoFall(), this);
        getServer().getPluginManager().registerEvents(new NoHungry(), this);
        getServer().getPluginManager().registerEvents(new AntiVoid(), this);
        getServer().getPluginManager().registerEvents(new InHole(), this);
        getServer().getPluginManager().registerEvents(new ResurrectTeleport(), this);
        getServer().getPluginManager().registerEvents(new PutBlock(), this);
        getServer().getPluginManager().registerEvents(new BreakBlock(), this);
    }
}
