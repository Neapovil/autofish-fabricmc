package com.github.neapovil.autofish;

import org.jetbrains.annotations.Nullable;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.player.PlayerEntity;

public final class FishingBobberEntityEvents
{
    public static final Event<Tick> TICK = EventFactory.createArrayBacked(Tick.class,
            (listeners) -> (playerEntity, hookCountdown) -> {
                for (Tick listener : listeners)
                {
                    listener.onTick(playerEntity, hookCountdown);
                }
            });

    @FunctionalInterface
    public interface Tick
    {
        void onTick(@Nullable PlayerEntity playerEntity, int hookCountdown);
    }
}
