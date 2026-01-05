/*
 * Copyright 2025 Markus Bordihn
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package de.markusbordihn.cookiescandyandcakes.client.screen;

import de.markusbordihn.cookiescandyandcakes.menu.CookieJarMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

public class CookieJarScreen extends AbstractContainerScreen<CookieJarMenu> {

  private static final Identifier TEXTURE_INVENTORY =
      Identifier.withDefaultNamespace("textures/gui/container/generic_54.png");

  public CookieJarScreen(CookieJarMenu menu, Inventory playerInventory, Component title) {
    super(menu, playerInventory, title);
    this.imageHeight = 218;
    this.inventoryLabelY = this.imageHeight - 94;
  }

  @Override
  protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
    int x = (width - imageWidth) / 2;
    int y = (height - imageHeight) / 2;

    // Render the background texture - top part
    guiGraphics.blit(
        RenderPipelines.GUI_TEXTURED,
        TEXTURE_INVENTORY,
        x,
        y,
        0,
        0,
        imageWidth,
        3 * 18 + 17,
        256,
        256);

    // Middle part
    int middleY = y + 3 * 18 + 17;
    int fillHeight = 13;
    for (int i = 0; i < 4; i++) {
      guiGraphics.blit(
          RenderPipelines.GUI_TEXTURED,
          TEXTURE_INVENTORY,
          x,
          middleY + i * fillHeight,
          0,
          4,
          imageWidth,
          fillHeight,
          256,
          256);
    }

    // Bottom part
    guiGraphics.blit(
        RenderPipelines.GUI_TEXTURED,
        TEXTURE_INVENTORY,
        x,
        y + 3 * 18 + 17 + 50,
        0,
        126,
        imageWidth,
        96,
        256,
        256);
  }

  @Override
  public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
    super.render(guiGraphics, mouseX, mouseY, partialTick);
    renderTooltip(guiGraphics, mouseX, mouseY);
  }
}
