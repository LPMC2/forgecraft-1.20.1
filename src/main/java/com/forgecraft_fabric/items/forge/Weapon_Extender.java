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

public class Weapon_Extender extends Item{
    public static final int forge_id = 1;
    public static final String forge_name = "Long";
    public static final ForgeData data = new ForgeData(1, "Long",5, Text.literal("⚒ Long: +50% Attack/Mining Range"), List.of("MELEE", "TOOL"));
    public Weapon_Extender(Settings settings) {
        super(settings);
    }
    public static final Item target_item = registerItem("weapon_extender", new Weapon_Extender(new FabricItemSettings().maxCount(1)));
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("§7⚒ Long: Increase Player Interaction Range by 50%"));
        tooltip.add(Text.literal("§7Put it in the Anvil with the item to forge it!"));
        tooltip.add(Text.literal("§8Can reforge to: §f§lMELEE/TOOL"));
        tooltip.add(Text.literal("§aXp level cost: 5"));
        super.appendTooltip(stack, world, tooltip, context);
    }


    @Override
    public ItemStack getDefaultStack() {
        ItemStack stack = super.getDefaultStack();
        return stack;
    }

}
