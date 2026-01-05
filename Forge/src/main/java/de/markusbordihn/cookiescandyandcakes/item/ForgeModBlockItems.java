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

package de.markusbordihn.cookiescandyandcakes.item;

import de.markusbordihn.cookiescandyandcakes.Constants;
import de.markusbordihn.cookiescandyandcakes.block.ForgeModBlocks;
import de.markusbordihn.cookiescandyandcakes.block.PumpkinHeadCookieJarBlock;
import de.markusbordihn.cookiescandyandcakes.block.ShulkerBoxCookieJarBlock;
import de.markusbordihn.cookiescandyandcakes.block.SkeletonHeadCookieJarBlock;
import de.markusbordihn.cookiescandyandcakes.block.TntCookieJarBlock;
import de.markusbordihn.cookiescandyandcakes.registry.ModBlockItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ForgeModBlockItems {

  public static final DeferredRegister<Item> BLOCK_ITEMS =
      DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);

  static {
    ModBlockItems.PUMPKIN_HEAD_COOKIE_JAR =
        BLOCK_ITEMS.register(
            PumpkinHeadCookieJarBlock.ID,
            () ->
                new CookieJarItem(
                    ForgeModBlocks.PUMPKIN_HEAD_COOKIE_JAR.get(), new Item.Properties()));
    ModBlockItems.SHULKER_BOX_COOKIE_JAR =
        BLOCK_ITEMS.register(
            ShulkerBoxCookieJarBlock.ID,
            () ->
                new CookieJarItem(
                    ForgeModBlocks.SHULKER_BOX_COOKIE_JAR.get(), new Item.Properties()));
    ModBlockItems.SKELETON_HEAD_COOKIE_JAR =
        BLOCK_ITEMS.register(
            SkeletonHeadCookieJarBlock.ID,
            () ->
                new CookieJarItem(
                    ForgeModBlocks.SKELETON_HEAD_COOKIE_JAR.get(), new Item.Properties()));
    ModBlockItems.TNT_COOKIE_JAR =
        BLOCK_ITEMS.register(
            TntCookieJarBlock.ID,
            () -> new CookieJarItem(ForgeModBlocks.TNT_COOKIE_JAR.get(), new Item.Properties()));
    ModBlockItems.GINGERBREAD_BLOCK =
        BLOCK_ITEMS.register(
            "gingerbread_block",
            () -> new BlockItem(ForgeModBlocks.GINGERBREAD_BLOCK.get(), new Item.Properties()));
  }

  private ForgeModBlockItems() {}
}
