package com.forgecraft_fabric.items;

import com.forgecraft_fabric.ForgeCraft;
import com.forgecraft_fabric.block.ModBlocks;
import com.forgecraft_fabric.items.forge.Ornate_Stone;
import com.forgecraft_fabric.items.forge.Weapon_Extender;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class ModItems {

    private static List<Item> items = new ArrayList<>();

    public static void AddItemToList(Item item) {
        items.add(item);
    }
    public static void ClearItems() {
        items.clear();
    }
    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(ForgeCraft.MOD_ID, name), item);
    }
    public static void AddAllItems() {

        AddItemToList(Weapon_Extender.target_item);
        AddItemToList(Ornate_Stone.target_item);
    }
    public static void registerModItems() {
        ForgeCraft.LOGGER.info("Registering mod items for " + ForgeCraft.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(ModBlocks.REFORGE_ANVIL);
        });
        if(items.isEmpty()) return;
        items.forEach(item -> {
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
                entries.add(item);
            });
        });

    }
}
