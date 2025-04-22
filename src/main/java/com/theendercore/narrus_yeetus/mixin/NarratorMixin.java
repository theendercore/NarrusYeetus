package com.theendercore.narrus_yeetus.mixin;

import com.mojang.text2speech.Narrator;
import org.jetbrains.annotations.NotNull;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Narrator.class)
public interface NarratorMixin {
    @Inject(method = "getNarrator", at = @At("HEAD"), cancellable = true, remap = false)
    private static void getNarrator(@NotNull CallbackInfoReturnable<Narrator> cir) {
        LoggerFactory.getLogger("Narrator").info("The Narrator has been disabled by Narrus Yeetus!");
        cir.setReturnValue(new Narrator() {
            @Override public void say(String msg, boolean interrupt) { }
            @Override public void clear() { }
            @Override public boolean active() { return false; }
            @Override public void destroy() { }
        });
    }
}
