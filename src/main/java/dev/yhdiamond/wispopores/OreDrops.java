package dev.yhdiamond.wispopores;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OreDrops {
    public static ItemStack getCoalOre() {
        List<ItemStack> randoms = new ArrayList<>();
        randoms.add(new ItemStack(Material.BEEF));
        randoms.add(new ItemStack(Material.BREAD));
        randoms.add(new ItemStack(Material.IRON_INGOT));
        randoms.add(new ItemStack(Material.GOLD_NUGGET));
        return randoms.get(new Random().nextInt(randoms.size()));
    }
    public static ItemStack getIronOre() {
        List<ItemStack> randoms = new ArrayList<>();
        randoms.add(new ItemStack(Material.BOOK));
        randoms.add(new ItemStack(Material.OAK_LOG));
        randoms.add(new ItemStack(Material.GOLD_INGOT));
        randoms.add(new ItemStack(Material.COOKED_BEEF));
        randoms.add(new ItemStack(Material.ANVIL));
        //blacksmith chest
        return randoms.get(new Random().nextInt(randoms.size()));
    }
    public static ItemStack getRedstoneOre() {
        List<ItemStack> randoms = new ArrayList<>();
        randoms.add(new ItemStack(Material.DIAMOND));
        randoms.add(new ItemStack(Material.GOLD_INGOT));
        randoms.add(new ItemStack(Material.ENDER_PEARL));
        randoms.add(new ItemStack(Material.FIREWORK_ROCKET, 8));
        //Stronghold loot chest
        return randoms.get(new Random().nextInt(randoms.size()));
    }
    public static ItemStack getLapisOre() {
        return new ItemStack(Material.DIAMOND_BLOCK);
    }
    public static ItemStack getGoldOre() {
        List<ItemStack> randoms = new ArrayList<>();
        randoms.add(new ItemStack(Material.DIAMOND));
        randoms.add(new ItemStack(Material.EXPERIENCE_BOTTLE, 8));
        return randoms.get(new Random().nextInt(randoms.size()));

    }
    public static List<ItemStack> getDiamondOre() {
        List<List<ItemStack>> randoms = new ArrayList<>();
            List<ItemStack> diamondarmor = new ArrayList<>();
            diamondarmor.add(new ItemStack(Material.DIAMOND_CHESTPLATE));
            diamondarmor.add(new ItemStack(Material.DIAMOND_LEGGINGS));
            diamondarmor.add(new ItemStack(Material.DIAMOND_BOOTS));
            diamondarmor.add(new ItemStack(Material.DIAMOND_HELMET));
        randoms.add(diamondarmor);
            List<ItemStack> elytra = new ArrayList<>();
            elytra.add(new ItemStack(Material.ELYTRA));
        randoms.add(elytra);
            List<ItemStack> protbook = new ArrayList<>();
            ItemStack protbookstack = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta protbookmeta = (EnchantmentStorageMeta) protbookstack.getItemMeta();
            protbookmeta.addStoredEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1000, true);
            protbookstack.setItemMeta(protbookmeta);
            protbook.add(protbookstack);
        randoms.add(protbook);
            List<ItemStack> pickbook = new ArrayList<>();
            ItemStack pickbookstack = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta pickbookmeta = (EnchantmentStorageMeta) pickbookstack.getItemMeta();
            pickbookmeta.addStoredEnchant(Enchantment.DURABILITY, 1000, true);
            pickbookmeta.addStoredEnchant(Enchantment.DIG_SPEED, 1000, true);
            pickbookstack.setItemMeta(pickbookmeta);
            pickbook.add(pickbookstack);
        randoms.add(pickbook);
        return randoms.get(new Random().nextInt(randoms.size()));
    }
    public static ItemStack getEmeraldOre() {
        return new ItemStack(Material.TOTEM_OF_UNDYING);
    }
    public static ItemStack getNetherGoldOre() {
        List<ItemStack> randoms = new ArrayList<>();
        randoms.add(new ItemStack(Material.OBSIDIAN));
        randoms.add(new ItemStack(Material.GOLDEN_APPLE));
        randoms.add(new ItemStack(Material.DIAMOND));
        randoms.add(new ItemStack(Material.EXPERIENCE_BOTTLE, 8));
        randoms.add(new ItemStack(Material.FIREWORK_ROCKET, 8));
        //bastion loot chest
        return randoms.get(new Random().nextInt(randoms.size()));
    }
    public static ItemStack getQuartzOre() {
        List<ItemStack> randoms = new ArrayList<>();
        randoms.add(ItemBuilder.of(Material.POTION, 1).color(Color.GREEN).name("Potion of Jump Boost").potionEffect(PotionEffectType.JUMP, 4).build());
        randoms.add(ItemBuilder.of(Material.POTION, 1).color(Color.ORANGE).name("Potion of Haste").potionEffect(PotionEffectType.FAST_DIGGING, 4).build());
        randoms.add(ItemBuilder.of(Material.POTION, 1).color(Color.GRAY).name("Potion of Swiftness").potionEffect(PotionEffectType.SPEED, 4).build());
        randoms.add(ItemBuilder.of(Material.POTION, 1).color(Color.GRAY).name("Potion of Invisibility").potionEffect(PotionEffectType.INVISIBILITY, 0).build());
        randoms.add(new ItemStack(Material.EXPERIENCE_BOTTLE, 8));
        return randoms.get(new Random().nextInt(randoms.size()));
    }
    
}
