package dev.yhdiamond.wispopores;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class OreBreakListener implements Listener {
    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if (WispOPOres.isStarted && !e.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
            switch (e.getBlock().getType()) {
                case COAL_ORE:
                    e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), OreDrops.getCoalOre());
                    break;
                case IRON_ORE:
                    e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), OreDrops.getIronOre());
                    e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.IRON_INGOT));
                    e.setCancelled(true);
                    e.getBlock().setType(Material.AIR);
                    break;
                case REDSTONE_ORE:
                    e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), OreDrops.getRedstoneOre());
                    break;
                case LAPIS_ORE:
                    e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), OreDrops.getLapisOre());
                    break;
                case DIAMOND_ORE:
                    for (ItemStack i : OreDrops.getDiamondOre()) {
                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), i);
                    }
                    break;
                case GOLD_ORE:
                    e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), OreDrops.getGoldOre());
                    e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.GOLD_INGOT));
                    e.setCancelled(true);
                    e.getBlock().setType(Material.AIR);
                    break;
                case EMERALD_ORE:
                    e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), OreDrops.getEmeraldOre());
                    e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.QUARTZ));
                    e.setCancelled(true);
                    e.getBlock().setType(Material.AIR);
                    break;
                case NETHER_GOLD_ORE:
                    e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), OreDrops.getNetherGoldOre());
                    break;
                case NETHER_QUARTZ_ORE:
                    e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), OreDrops.getQuartzOre());
                    break;
            }
        }
    }
}
