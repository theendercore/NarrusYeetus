package com.theendercore.narrus_yeetus.mixin;

import com.mojang.text2speech.Narrator;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.mojang.text2speech.Narrator.EMPTY;
import static com.mojang.text2speech.Narrator.LOGGER;

@Mixin(Narrator.class)
public interface NarratorYeeter {
    @Inject(at = @At("HEAD"), method = "getNarrator", cancellable = true, remap = false)
    private static void getNarrator(@NotNull CallbackInfoReturnable<Narrator> cir) {
        LOGGER.error("Narrus Yeetus!");
        cir.setReturnValue(EMPTY);
    }
}
