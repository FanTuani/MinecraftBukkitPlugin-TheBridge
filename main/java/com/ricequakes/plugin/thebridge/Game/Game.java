package com.ricequakes.plugin.thebridge.Game;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class Game {
    public static Location redHome, blueHome;
    public static Player player1, player2;
    public static int blueScore = 0, redScore = 0;
    public static double voidY = 0;
    public static ArrayList<Location> blockLocs = new ArrayList<>();

    public static void initPlayerKits(Player player) {
        player.getInventory().clear();
        ItemStack[] items = new ItemStack[6];
        items[0] = new ItemStack(Material.IRON_SWORD);
        items[1] = new ItemStack(Material.SANDSTONE, 128);
        items[2] = new ItemStack(Material.DIAMOND_PICKAXE);
        items[3] = new ItemStack(Material.BOW);
        items[4] = new ItemStack(Material.ARROW, 64);
        items[5] = new ItemStack(Material.GOLDEN_APPLE, 6);
        for (ItemStack item : items) {
            player.getInventory().addItem(item);
        }

        ItemStack[] kits = new ItemStack[4];
        kits[0] = new ItemStack(Material.LEATHER_HELMET);
        kits[1] = new ItemStack(Material.LEATHER_CHESTPLATE);
        kits[2] = new ItemStack(Material.LEATHER_LEGGINGS);
        kits[3] = new ItemStack(Material.LEATHER_BOOTS);
        if (isRed(player)) {

        } else if (isBlue(player)) {

        }
        player.getInventory().setHelmet(kits[0]);
        player.getInventory().setChestplate(kits[1]);
        player.getInventory().setLeggings(kits[2]);
        player.getInventory().setBoots(kits[3]);
    }

    public static void setBlue(Player player) {
        player.setDisplayName(ChatColor.BLUE + player.getName());
        player.setPlayerListName(ChatColor.BLUE + player.getName());
    }

    public static void setRed(Player player) {
        player.setDisplayName(ChatColor.RED + player.getName());
        player.setPlayerListName(ChatColor.RED + player.getName());
    }

    public static void setWhite(Player player) {
        player.setDisplayName(player.getName());
        player.setPlayerListName(player.getName());
    }

    public static boolean isBlue(Player player) {
        return player.getDisplayName().equals(ChatColor.BLUE + player.getName());
    }

    public static boolean isRed(Player player) {
        return player.getDisplayName().equals(ChatColor.RED + player.getName());
    }

    public static void win(Player player) {
        player.sendMessage(ChatColor.GREEN + "You win!");
        if (player == player1) {
            player2.sendMessage(ChatColor.RED + "You lose!");
        } else {
            player1.sendMessage(ChatColor.RED + "You lose!");
        }
        blueScore = 0;
        redScore = 0;
        setWhite(player1);
        setWhite(player2);
        player1.getInventory().clear();
        player2.getInventory().clear();
    }

    public static void tpPlayersToHome() {
        if (isRed(player1)) player1.teleport(redHome);
        else if (isBlue(player1)) player1.teleport(blueHome);
        if (isRed(player2)) player2.teleport(redHome);
        else if (isBlue(player2)) player2.teleport(blueHome);
    }

    public static void publishScore() {
        player1.sendMessage(ChatColor.RED + String.valueOf(redScore) + ChatColor.WHITE + " : " + ChatColor.BLUE + String.valueOf(blueScore));
        player2.sendMessage(ChatColor.RED + String.valueOf(redScore) + ChatColor.WHITE + " : " + ChatColor.BLUE + String.valueOf(blueScore));
    }

    public static void clearBlocks() {
        for (Location location : blockLocs) {
            location.getBlock().setType(Material.AIR);
        }
        blockLocs.clear();
    }
}
