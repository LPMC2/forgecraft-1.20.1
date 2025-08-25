package com.forgecraft_fabric.items.forge;

import com.forgecraft_fabric.ForgeCraft;
import com.forgecraft_fabric.block.custom.ReforgeAnvilScreenHandler;
import com.forgecraft_fabric.items.ForgeData;
import com.forgecraft_fabric.mixin.ItemMixin;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.item.TooltipData;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.Property;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.lwjgl.system.SharedLibrary;

import javax.swing.text.Style;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ForgingHelper {
    public static CraftingResultInventory output;
    public static Inventory input;
    public static ItemStack input_item_1;
    public static ItemStack input_item_2;
    public static ItemStack output_item;
    public static Property level_cost;
    public static List<String> item_Types = new ArrayList<String>();
    public static void InitForge(Inventory p_input, CraftingResultInventory p_output, ItemStack result, Property level_property) {
        input = p_input;
        output = p_output;
        input_item_1 = p_input.getStack(0);
        input_item_2 = p_input.getStack(1);
        output_item = result;
        level_cost = level_property;
    }
    public static void Clear() {
        input = null;
        output = null;
        input_item_1 = null;
        input_item_2 = null;
        output_item = null;
        level_cost = null;

    }
    public static ItemStack ForgeItem(ItemStack target_item, Item forge_item) {
        List<String> item_type = GetItemType(target_item);
        item_Types.clear();
        item_Types.addAll(item_type);
        ForgeData data = ForgeTypeGetter.getData(forge_item);
        if(data == null) return null;
        level_cost.set(data.getCost());
        SetName(target_item, data);
        SetTooltip(target_item,data);
        switch (data.getID()) {
            case 1:
                ForgeTypeHelper.Long(target_item);
                break;
            case 2:
                ForgeTypeHelper.Heavy(target_item);
                break;
            case 3:
          
                break;
            default:
                target_item = ItemStack.EMPTY;
        }
        NbtCompound nbt = target_item.getOrCreateNbt();
        nbt.putInt("forge_id", data.getID());
        return target_item;
    }
    private static void SetName(ItemStack item, ForgeData data) {
        if(item.hasCustomName()) {
            String name = item.getName().getString();
            ForgeCraft.LOGGER.info("Name: " + name);
            item.setCustomName(Text.literal("⚒ " + data.getName() + " " + name).styled(style -> style.withItalic(false).withColor(0xDEDEDE)));
        } else {
            item.setCustomName(Text.literal("⚒ " + data.getName() + " " + item.getName().getString()).styled(style -> style.withItalic(false).withColor(0xDEDEDE)));
        }
    }
    private static void SetTooltip(ItemStack item, ForgeData data) {
        /*
        if(item.getTooltipData().isPresent()) {
            TooltipData tooltip = item.getTooltipData().get();
            item.getItem().appendTooltip(item, ReforgeAnvilScreenHandler.world, List.of(Text.literal(data.getDescription().getString()).formatted(Formatting.DARK_GRAY)), TooltipContext.BASIC);
        } else {
            item.getItem().appendTooltip(item, ReforgeAnvilScreenHandler.world, List.of(Text.literal(data.getDescription().getString()).formatted(Formatting.DARK_GRAY)), TooltipContext.BASIC);
        }

         */


    }
    public static List<String> GetItemType(ItemStack target_item) {
        Item item = target_item.getItem();
        int maxDamage = item.getMaxDamage();
        boolean isTool = item instanceof ToolItem;
        boolean isWeapon = item instanceof SwordItem || item instanceof AxeItem || item instanceof TridentItem;
        boolean isArmor = item instanceof ArmorItem;
        boolean isRanged = item instanceof RangedWeaponItem || item instanceof TridentItem;
        boolean isUtilities = item instanceof FlintAndSteelItem || item instanceof OnAStickItem || item instanceof ShieldItem || item instanceof BrushItem || item instanceof ElytraItem || item instanceof ShearsItem || item instanceof FishingRodItem;
        String damage = target_item.getAttributeModifiers(EquipmentSlot.MAINHAND).get(EntityAttributes.GENERIC_ATTACK_DAMAGE).toString().replaceFirst(".*?amount=([0-9]+\\.[0-9]+).*", "$1");
        Double attack_damage = 0.0;
        if (damage.matches("[0-9]+\\.[0-9]+")) {
            attack_damage = Double.parseDouble(damage);
        }
        List<String> types = new ArrayList<String>();
        if (isWeapon || attack_damage >= 5.0) {
            types.add("MELEE");
        }
        if (isArmor) {
            types.add("ARMOR");
            ArmorItem armorItem = (ArmorItem) item;
            switch (armorItem.getSlotType()) {
                case HEAD:
                    types.add("Helmet");
                    break;
                case CHEST:
                    types.add("Chestplate");
                    break;
                case LEGS:
                    types.add("Leggings");
                    break;
                case FEET:
                    types.add("Boots");
                    break;
            }
        }
        if(isTool) {

            types.add("TOOL");
            if(item instanceof PickaxeItem) {
                PickaxeItem tool = (PickaxeItem) item;

            }



        }
        if(isRanged) {
            types.add("RANGED");
        }
        if(isUtilities) {
            types.add("UTILITIES");
        }
        if (maxDamage >= 1) {
            types.add("OTHER_DURABILITY");
        } else {
            types.add("OTHER");
        }
        return types;
    }
    protected static class ForgeTypeHelper {

        // ID - 1
        public static void Long(ItemStack item) {

        }
        // ID - 2
        public static void Heavy(ItemStack item) {

        }
    }
}
