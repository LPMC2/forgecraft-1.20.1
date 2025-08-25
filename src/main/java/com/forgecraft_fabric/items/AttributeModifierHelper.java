package com.forgecraft_fabric.items;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AttributeModifierHelper {

    public static List<EntityAttributeModifier> getAttributeModifiers(ItemStack stack) {
        List<EntityAttributeModifier> modifiers = new ArrayList<>();
        NbtCompound nbt = stack.getNbt();

        if (nbt != null && nbt.contains("AttributeModifiers", 9)) {
            NbtList modifierList = nbt.getList("AttributeModifiers", 10); // 10 is the NBT type for compound tags

            for (int i = 0; i < modifierList.size(); i++) {
                NbtCompound modifierTag = modifierList.getCompound(i);
                try {
                    // Extract data from the modifier tag
                    UUID uuid = modifierTag.getUuid("UUID");
                    String name = modifierTag.getString("Name");
                    double amount = modifierTag.getDouble("Amount");
                    int operation = modifierTag.getInt("Operation");
                    String attributeName = modifierTag.getString("AttributeName");

                    // Attempt to create an EntityAttributeModifier
                    EntityAttributeModifier modifier = new EntityAttributeModifier(uuid, name, amount, EntityAttributeModifier.Operation.fromId(operation));
                    modifiers.add(modifier);
                    System.out.println("UUID: " + uuid + "\nName: "+ name + "\nAmount: " + amount + "\nOperation: " + operation + "\nAttributeName: " + attributeName);
                } catch (IllegalArgumentException e) {
                    // Handle cases where the attribute name is not registered
                    System.err.println("Error getting attribute modifier: " + e.getMessage());
                }
            }
        }
        return modifiers;
    }
}