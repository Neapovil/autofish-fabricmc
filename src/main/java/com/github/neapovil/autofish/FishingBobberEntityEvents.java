package com.github.neapovil.autofish;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.player.PlayerEntity;
import org.jetbrains.annotations.Nullable;

public final class FishingBobberEntityEvents
{
    public static final Event<Tick> TICK = EventFactory.createArrayBacked(Tick.class,
        (listeners) -> (playerEntity, caughtFish) -> {
            for (Tick listener : listeners)
            {
                listener.onTick(playerEntity, caughtFish);
            }
        });

    @FunctionalInterface
    public interface Tick
    {
        void onTick(@Nullable PlayerEntity playerEntity, boolean caughtFish);
    }
}
