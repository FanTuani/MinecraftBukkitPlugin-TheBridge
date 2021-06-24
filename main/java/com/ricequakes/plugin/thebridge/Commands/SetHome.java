package com.ricequakes.plugin.thebridge.Commands;

import com.ricequakes.plugin.thebridge.TheBridge;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class SetHome implements CommandExecutor {
    private TheBridge plugin;

    public SetHome(TheBridge plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            if (cmd.getName().equalsIgnoreCase("sh")) {
                Player player = (Player) sender;
                Location location = player.getLocation();
                FileConfiguration config = plugin.getConfig();
                if (args[0].equals("red")) {
                    config.set("redx", location.getX());
                    config.set("redy", location.getY());
                    config.set("redz", location.getZ());
                    config.set("redyaw", location.getYaw());
                    config.set("redpitch", location.getPitch());
                    player.sendMessage(ChatColor.YELLOW + "Set: Red");
                }
                if (args[0].equals("blue")) {
                    config.set("bluex", location.getX());
                    config.set("bluey", location.getY());
                    config.set("bluez", location.getZ());
                    config.set("blueyaw", location.getYaw());
                    config.set("bluepitch", location.getPitch());
                    player.sendMessage(ChatColor.YELLOW + "Set: Blue");
                }
                plugin.saveConfig();
                return true;
            }
        }
        return false;
    }
}
