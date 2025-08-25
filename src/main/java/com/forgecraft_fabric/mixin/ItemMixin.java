package com.forgecraft_fabric.mixin;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;

@Mixin(Item.class)
public abstract class ItemMixin implements FabricItem {
    @Unique
    private float miningSpeed = 1.0f;
    /**
     * @author LPMC2
     * @reason I need a way to modify Mining Speed through item, for setting data dynamically
     */
    @Overwrite
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return miningSpeed;
    }
    @Unique
    public void setMiningSpeed(float value) {
        miningSpeed = value;
    }
}
