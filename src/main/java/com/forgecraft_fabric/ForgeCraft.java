package com.forgecraft_fabric;

import com.forgecraft_fabric.block.ModBlocks;
import com.forgecraft_fabric.block.entity.ModBlockEntities;
import com.forgecraft_fabric.items.ModItems;
import com.forgecraft_fabric.items.forge.ForgeTypeGetter;
import com.forgecraft_fabric.screen.ModScreenHandlers;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ForgeCraft implements ModInitializer {
	public static final String MOD_ID = "forgecraft";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.AddAllItems();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();
		ForgeTypeGetter.Init();
	}
}