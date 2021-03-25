package dev.yhdiamond.wispopores;

import org.bukkit.event.Listener;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Map;

public class AnvilListener implements Listener {
    @EventHandler
    public void onAnvilMakeItem(PrepareAnvilEvent event){
        int bookslot = 0;
        int bookcount = 0;
        for (int i=0;i<event.getInventory().getSize()-1;i++){
            if (event.getInventory().getItem(i) != null){
                if (event.getInventory().getItem(i).getType().equals(Material.ENCHANTED_BOOK)){
                    bookslot = i;
                    bookcount++;
                }
            }
        }
        if (bookslot == 1 && bookcount == 1){
            if (event.getInventory().getItem(0) != null){
                ItemStack cloneditem = new ItemStack(event.getInventory().getItem(0).getType());
                ItemMeta originalmeta = event.getInventory().getItem(0).getItemMeta().clone();
                EnchantmentStorageMeta enchantmentStorageMeta = (EnchantmentStorageMeta) event.getInventory().getItem(bookslot).getItemMeta();
                Map<Enchantment, Integer> bookEnchants = enchantmentStorageMeta.getStoredEnchants();
                boolean enchanted = false;
                for (Enchantment enchantment : bookEnchants.keySet()){
                    if (enchantment.canEnchantItem(cloneditem)){
                        originalmeta.addEnchant(enchantment, bookEnchants.get(enchantment), true);
                        enchanted = true;
                    }
                }
                cloneditem.setItemMeta(originalmeta);
                if (enchanted){
                    event.setResult(cloneditem);
                }
                else {
                    event.setResult(null);
                }
            }
        }
        else if (bookcount == 2) {
            ItemStack ebookstack = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta oldbookmeta = (EnchantmentStorageMeta) event.getInventory().getItem(0).getItemMeta().clone();
            EnchantmentStorageMeta newbookmeta = (EnchantmentStorageMeta) event.getInventory().getItem(1).getItemMeta();
            Map<Enchantment, Integer> newBookEnchants = newbookmeta.getStoredEnchants();
            boolean enchanted = false;
            for (Enchantment enchantment : newBookEnchants.keySet()) {
                if (oldbookmeta.hasStoredEnchant(enchantment)) {
                    oldbookmeta.addStoredEnchant(enchantment, newbookmeta.getStoredEnchantLevel(enchantment) + newBookEnchants.get(enchantment), true);
                    enchanted = true;
                }
            }
            if (enchanted) {
                ebookstack.setItemMeta(oldbookmeta);
                event.setResult(ebookstack);
            } else {
                event.setResult(null);
            }
        }
    }
}
