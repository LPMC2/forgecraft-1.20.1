package com.forgecraft_fabric.block;

import com.forgecraft_fabric.ForgeCraft;
import com.forgecraft_fabric.block.custom.ReforgeAnvil;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;


public class ModBlocks {

    public static final Block REFORGE_ANVIL = registerBlock("reforge_anvil", new ReforgeAnvil(FabricBlockSettings.create()
            .requiresTool()
            .strength(6.0F, 1200.0F)
            .sounds(BlockSoundGroup.ANVIL)
            .nonOpaque()
            .pistonBehavior(PistonBehavior.BLOCK)));



    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(ForgeCraft.MOD_ID, name), block);
    }


    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(ForgeCraft.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));

    }

    public static void registerModBlocks() {
        ForgeCraft.LOGGER.info("Registering ModBlocks for " + ForgeCraft.MOD_ID);
    }
}
