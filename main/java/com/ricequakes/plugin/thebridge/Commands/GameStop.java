package com.ricequakes.plugin.thebridge.Commands;

import com.ricequakes.plugin.thebridge.Game.Game;
import com.ricequakes.plugin.thebridge.TheBridge;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameStop implements CommandExecutor {
    private TheBridge plugin;

    public GameStop(TheBridge plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            if (cmd.getName().equalsIgnoreCase("gamestop")) {
                Game.win((Player) sender);
                Game.clearBlocks();
            } return true;
        }
        return false;
    }
}
