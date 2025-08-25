package com.forgecraft_fabric.items.forge;

import com.forgecraft_fabric.ForgeCraft;
import com.forgecraft_fabric.items.ForgeData;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static com.forgecraft_fabric.items.ModItems.registerItem;

public class Ornate_Stone extends Item{
    public static final int forge_id = 1;
    public static final String forge_name = "Heavy";
    public static final ForgeData data = new ForgeData(2, "Heavy",5, Text.literal("⚒ Heavy: +100% Attack Damage, -50% Attack Speed & Move Speed"), List.of("MELEE"));
    public Ornate_Stone(Settings settings) {
        super(settings);
    }


    //new ArrayList<>(Arrays.asList(new EntityAttributeModifier(UUID.randomUUID(),"minecraft:generic.attack_damage", 1, EntityAttributeModifier.Operation.ADDITION)))
    public static final Item target_item = registerItem("ornate_stone", new Ornate_Stone(new FabricItemSettings().maxCount(1)));
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("§7⚒ Heavy: Increase Attack Damage by 100%,"));
        tooltip.add(Text.literal("§7but decrease Movement & Attack Speed by 50%"));
        tooltip.add(Text.literal("§7Put it in the Anvil with the item to forge it!"));
        tooltip.add(Text.literal("§8Can reforge to: §f§lMELEE"));
        tooltip.add(Text.literal("§aXp level cost: 5"));
        super.appendTooltip(stack, world, tooltip, context);
    }
    
    /*
    ItemStack stack = super.getDefaultStack();
    nbt = stack.getOrCreateNbt();
    nbt.putInt("forge_id", 1);

     */

    @Override
    public ItemStack getDefaultStack() {
        ItemStack stack = super.getDefaultStack();
        return stack;
    }

}
