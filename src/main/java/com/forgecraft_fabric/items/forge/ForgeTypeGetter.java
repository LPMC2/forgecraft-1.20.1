package com.forgecraft_fabric.items.forge;

import com.forgecraft_fabric.ForgeCraft;
import com.forgecraft_fabric.items.ForgeData;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

import java.util.*;

public class ForgeTypeGetter {
    public static Map<Item, ForgeData> itemList = new HashMap<Item, ForgeData>();
    public static int getIndex(Item item) {
        List<Map.Entry<Item, ForgeData>> entryList = new ArrayList<>(itemList.entrySet());

        int index = -1;
        for (int i = 0; i < entryList.size(); i++) {
            Map.Entry<Item, ForgeData> entry = entryList.get(i);
            if (entry.getKey().getName().equals(item.getName())) {
                index = i;
                break;
            }
        }
        return index;
    }
    public static Item getItem(int value) {
        for (Map.Entry<Item, ForgeData> entry : itemList.entrySet()) {
                if(entry.getValue().getID() == value) return entry.getKey();
        }
        return null;
    }
    public static Item getItem(Item item) {
        for (Map.Entry<Item, ForgeData> entry : itemList.entrySet()) {
            if(entry.getKey().getRegistryEntry().getKey().get().getValue() == item.getRegistryEntry().getKey().get().getValue()) return entry.getKey();
        }
        return null;
    }
    public static ForgeData getData(Item item) {
        for (Map.Entry<Item, ForgeData> entry : itemList.entrySet()) {
            if(entry.getKey().getRegistryEntry().getKey().get().getValue() == item.getRegistryEntry().getKey().get().getValue()) return entry.getValue();
        }
        return new ForgeData(-1, "ERROR", 0, Text.empty(), List.of("UNKNOWN"));
    }
    //Getting item's ID: item.getRegistryEntry().getKey().get().getValue()
    public static void Init() {
        itemList.clear();
        setItems();
        String data = "";
        int index = 1;
        for(Map.Entry<Item, ForgeData> entry : itemList.entrySet()) {
            if(getItem(index).getRegistryEntry()!= null) {
                data += getItem(index).getRegistryEntry().getKey().get().getValue().toString() + ": (" + entry.getValue().getName() + ", ID: " + entry.getValue().getID() + ", Cost: " + entry.getValue().getCost() + ")\n";
            } else {
                data += "ERROR Getting item (" + index + ") !\n";
            }
            index++;
        }
        ForgeCraft.LOGGER.info("Forge Type Data Loaded!\n" + data);
    }
    private static void setItems() {
        itemList.put(Weapon_Extender.target_item, Weapon_Extender.data);
        itemList.put(Ornate_Stone.target_item, Ornate_Stone.data);
    }
}
