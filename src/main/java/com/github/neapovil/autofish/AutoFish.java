package com.github.neapovil.autofish;

import com.github.neapovil.autofish.mixin.MinecraftClientAccessor;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class AutoFish implements ClientModInitializer
{
    public static final Logger LOGGER = LoggerFactory.getLogger("AutoFish");

    @Override
    public void onInitializeClient()
    {
        FishingBobberEntityEvents.TICK.register(this::onTick);
    }

    private void onTick(PlayerEntity playerEntity, boolean caughtFish)
    {
        if (caughtFish)
        {
            final MinecraftClient client = MinecraftClient.getInstance();
            ((MinecraftClientAccessor) client).invokeDoItemUse();
            ((MinecraftClientAccessor) client).invokeDoItemUse();
        }
    }
}
