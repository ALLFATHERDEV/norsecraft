package com.norsecraft.mixin;

import com.norsecraft.NorseCraftMod;
import com.norsecraft.client.screen.NorseCraftInventoryScreen;
import com.norsecraft.common.screenhandler.NorseCraftInventoryScreenHandler;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.LiteralText;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientInputMixin {

    @Inject(method = "handleInputEvents()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/tutorial/TutorialManager;onInventoryOpened()V"), cancellable = true)
    private void renderOwnInventory(CallbackInfo info) {
        MinecraftClient client = MinecraftClient.getInstance();
        NorseCraftInventoryScreenHandler handler = new NorseCraftInventoryScreenHandler(0, client.player.getInventory());
        NorseCraftInventoryScreen screen = new NorseCraftInventoryScreen(handler, client.player.getInventory(), LiteralText.EMPTY);
        client.setScreen(screen);
        NorseCraftMod.LOGGER.info("Injected... opening own inventory");
        info.cancel();
    }


}
