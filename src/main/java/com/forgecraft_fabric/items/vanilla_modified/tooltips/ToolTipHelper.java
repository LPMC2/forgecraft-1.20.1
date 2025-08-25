package com.forgecraft_fabric.items.vanilla_modified.tooltips;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.text.HoverEvent;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;

@Mixin({Item.class})
public abstract class ToolTipHelper {
    @Nullable
    private List<Text> tooltip;
}
