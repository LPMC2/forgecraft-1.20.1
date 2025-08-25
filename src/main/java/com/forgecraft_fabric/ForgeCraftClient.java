package com.forgecraft_fabric;

import com.forgecraft_fabric.screen.ModScreenHandlers;
import com.forgecraft_fabric.screen.ReforgeAnvilScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class ForgeCraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ForgeCraft.LOGGER.info("Registering UI screen");
        HandledScreens.register(ModScreenHandlers.REFORGE_ANVIL_SCREEN_HANDLER, ReforgeAnvilScreen::new);
    }
}
