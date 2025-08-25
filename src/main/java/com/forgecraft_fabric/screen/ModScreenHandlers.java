package com.forgecraft_fabric.screen;

import com.forgecraft_fabric.ForgeCraft;
import com.forgecraft_fabric.block.custom.ReforgeAnvilScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static final ScreenHandlerType<ReforgeAnvilScreenHandler> REFORGE_ANVIL_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(ForgeCraft.MOD_ID, "reforge_anvil"),
                    new ExtendedScreenHandlerType<>(ReforgeAnvilScreenHandler::new));


    public static void registerScreenHandlers() {
        ForgeCraft.LOGGER.info("Registering Screen Handlers for " + ForgeCraft.MOD_ID);
    }
}