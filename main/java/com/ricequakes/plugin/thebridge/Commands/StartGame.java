package com.ricequakes.plugin.thebridge.Commands;

import com.ricequakes.plugin.thebridge.Game.Game;
import com.ricequakes.plugin.thebridge.TheBridge;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class StartGame implements CommandExecutor {
    private final TheBridge plugin;

    public StartGame(TheBridge plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player1 = (Player) sender;
            Server server = sender.getServer();
            Player player2 = server.getPlayer(args[0]);

            initGamePlayers(player1, player2);
            Game.initPlayerKits(player1);
            Game.initPlayerKits(player2);
            initGameHomes(player1);
            tpPlayersToHome();
            Game.voidY = plugin.getConfig().getDouble("voidy");

            return true;
        }
        return false;
    }

    private void initGamePlayers(Player player1, Player player2) {
        Game.setRed(player1);
        Game.setBlue(player2);
        Game.player1 = player1;
        Game.player2 = player2;
    }

    private void initGameHomes(Player player) {
        FileConfiguration config = plugin.getConfig();
        Location redHome, blueHome;

        redHome = player.getLocation();
        blueHome = player.getLocation();

        redHome.setX(config.getDouble("redx"));
        redHome.setY(config.getDouble("redy"));
        redHome.setZ(config.getDouble("redz"));
        redHome.setYaw((float) config.getDouble("redyaw"));
        redHome.setPitch((float) config.getDouble("redpitch"));

        blueHome.setX(config.getDouble("bluex"));
        blueHome.setY(config.getDouble("bluey"));
        blueHome.setZ(config.getDouble("bluez"));
        blueHome.setYaw((float) config.getDouble("blueyaw"));
        blueHome.setPitch((float) config.getDouble("bluepitch"));

        Game.redHome = redHome;
        Game.blueHome = blueHome;
    }

    private void tpPlayersToHome() {
        Game.player1.teleport(Game.redHome);
        Game.player2.teleport(Game.blueHome);
    }

}
