package com.ricequakes.plugin.thebridge.Commands;

import com.ricequakes.plugin.thebridge.Game.Game;
import com.ricequakes.plugin.thebridge.TheBridge;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetVoid implements CommandExecutor {
    private final TheBridge plugin;

    public SetVoid(TheBridge plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player && cmd.getName().equalsIgnoreCase("setvoid")) {
            Player player = (Player) sender;
            plugin.getConfig().set("voidy", player.getLocation().getY());
            plugin.saveConfig();
            Game.voidY = plugin.getConfig().getDouble("voidy");
            player.sendMessage("Set: Void");

            return true;
        }
        return false;
    }
}
