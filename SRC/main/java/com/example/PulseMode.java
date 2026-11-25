package com.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public class PulseMode implements ClientModInitializer {
    private float pulseTime = 0f;

    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register((DrawContext context, float tickDelta) -> {
            MinecraftClient mc = MinecraftClient.getInstance();
            if (mc.player == null) return;

            pulseTime += 0.05f;
            float phase = (float) ((Math.sin(pulseTime) + 1) / 2);
            int width = mc.getWindow().getScaledWidth();
            int height = mc.getWindow().getScaledHeight();
            
            // Пульсирующий круг
            int radius = (int) (40 + 20 * phase);
            int alpha = (int) ((0.4 + 0.6 * phase) * 255);
            int color = (alpha << 24) | 0x00B4FF; 
            context.fill(width / 2 - radius, height / 2 - radius, width / 2 + radius, height / 2 + radius, color);

            // Текст в центре
            context.drawText(mc.textRenderer, "Pulse Visual", width / 2 - 30, height / 2 - 5, 0xFFFFFF, true);
        });
    }
}
