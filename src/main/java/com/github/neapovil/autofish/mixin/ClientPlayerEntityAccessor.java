package com.github.neapovil.autofish.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;

@Mixin(ClientPlayerEntity.class)
public interface ClientPlayerEntityAccessor
{
    @Accessor("client")
    @Final
    public MinecraftClient client();
}
