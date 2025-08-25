package com.forgecraft_fabric.block.entity;

import com.forgecraft_fabric.ForgeCraft;
import com.forgecraft_fabric.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<ReforgeAnvilBlockEntity> REFORGE_ANVIL_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(ForgeCraft.MOD_ID,"reforge_anvil_entity"),
                    FabricBlockEntityTypeBuilder.create(ReforgeAnvilBlockEntity::new,
                            ModBlocks.REFORGE_ANVIL).build());


    public static void registerBlockEntities() {
        ForgeCraft.LOGGER.info("Registering Block Entities for " + ForgeCraft.MOD_ID);
    }

}
