package com.github.neapovil.autofish.mixin;

import com.github.neapovil.autofish.FishingBobberEntityEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FishingBobberEntity.class)
public abstract class FishingBobberEntityMixin
{
    @Shadow
    private boolean caughtFish;

    @Inject(method = "tick", at = @At("TAIL"))
    public void tick(CallbackInfo ci)
    {
        FishingBobberEntityEvents.TICK.invoker().onTick(this.getPlayerOwner(), this.caughtFish);
    }

    @Shadow
    public abstract PlayerEntity getPlayerOwner();
}
