package com.norsecraft.client.ymir.interpretation;

import com.norsecraft.client.ymir.ValidatedSlot;
import com.norsecraft.client.ymir.widget.data.HorizontalAlignment;
import com.norsecraft.client.ymir.widget.data.Vec2i;
import com.norsecraft.client.ymir.widget.FocusHandler;
import com.norsecraft.client.ymir.widget.YmirPanel;
import com.norsecraft.client.ymir.widget.YmirWidget;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.screen.PropertyDelegate;
import org.jetbrains.annotations.Nullable;

public interface GuiInterpretation {

    YmirPanel getRootPanel();

    int getTitleColor();

    GuiInterpretation setRootPanel(YmirPanel panel);

    GuiInterpretation setTitleColor(int color);

    GuiInterpretation setPropertyDelegate(PropertyDelegate delegate);

    void addSlotPeer(ValidatedSlot slot);

    @Environment(EnvType.CLIENT)
    void addPainters();

    @Nullable
    PropertyDelegate getPropertyDelegate();

    boolean isFocused(YmirWidget widget);

    @Nullable
    YmirWidget getFocus();

    void requestFocus(YmirWidget widget);

    void releaseFocus(YmirWidget widget);

    default void cycleFocus(boolean lookForwards) {
        FocusHandler.cycleFocus(this, lookForwards);
    }

    boolean isFullscreen();

    void setFullscreen(boolean fullscreen);

    boolean isTitleVisible();

    void setTitleVisible(boolean titleVisible);

    HorizontalAlignment getTitleAlignment();

    void setTitleAlignment(HorizontalAlignment alignment);

    Vec2i getTitlePos();

    void setTitlePos(Vec2i titlePos);

}