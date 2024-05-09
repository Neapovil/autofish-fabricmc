package com.github.neapovil.autofish.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.github.neapovil.autofish.event.FishingBobberEntityEvents;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;

@Mixin(FishingBobberEntity.class)
public class FishingBobberEntityMixin
{
    @Shadow
    private boolean caughtFish;

    @Inject(method = "tick", at = @At("TAIL"))
    public void tick(CallbackInfo ci)
    {
        FishingBobberEntityEvents.TICK.invoker().onTick(this.getPlayerOwner(), this.caughtFish);
    }

    @Shadow
    public PlayerEntity getPlayerOwner()
    {
        return null;
    }
}
