package com.example;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;

public class PulseMode implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        System.out.println("PULSE MOD SUCCESSFULLY LOADED!");
    }
}
