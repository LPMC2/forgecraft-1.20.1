package com.forgecraft_fabric.items.anvil;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.AnvilScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;

public class ReforgeHandler extends AnvilScreenHandler {
    private final PlayerEntity player;
    //private final Item targetItem;
    //private final Item forgeItem;

    public ReforgeHandler(int syncId, PlayerInventory inventory, ScreenHandlerContext context) {
        super(syncId, inventory, context);
        this.player = inventory.player;
        //this.targetItem = getForgingSlotsManager().;
        //this.forgeItem = buf.read();
    }

    @Override
    protected void onTakeOutput(PlayerEntity player, ItemStack stack) {
        super.onTakeOutput(player, stack);
    }

}
