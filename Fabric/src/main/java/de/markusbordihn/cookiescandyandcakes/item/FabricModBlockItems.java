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
import de.markusbordihn.cookiescandyandcakes.block.FabricModBlocks;
import de.markusbordihn.cookiescandyandcakes.data.cookiejar.CookieJarType;
import de.markusbordihn.cookiescandyandcakes.registry.ModBlockItems;
import java.util.function.Supplier;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class FabricModBlockItems {

  private FabricModBlockItems() {}

  public static void register() {
    ModBlockItems.PUMPKIN_HEAD_COOKIE_JAR =
        registerCookieJarItem(FabricModBlocks.PUMPKIN_HEAD_COOKIE_JAR, CookieJarType.PUMPKIN_HEAD);
    ModBlockItems.SHULKER_BOX_COOKIE_JAR =
        registerCookieJarItem(FabricModBlocks.SHULKER_BOX_COOKIE_JAR, CookieJarType.SHULKER_BOX);
    ModBlockItems.SKELETON_HEAD_COOKIE_JAR =
        registerCookieJarItem(
            FabricModBlocks.SKELETON_HEAD_COOKIE_JAR, CookieJarType.SKELETON_HEAD);
    ModBlockItems.TNT_COOKIE_JAR =
        registerCookieJarItem(FabricModBlocks.TNT_COOKIE_JAR, CookieJarType.TNT);
    ModBlockItems.GINGERBREAD_BLOCK =
        registerBlockItem("gingerbread_block", FabricModBlocks.GINGERBREAD_BLOCK);
  }

  private static Supplier<BlockItem> registerCookieJarItem(
      final Block block, final CookieJarType cookieJarType) {
    return registerBlockItem(cookieJarType.getId(), new CookieJarItem(block, cookieJarType));
  }

  private static Supplier<BlockItem> registerBlockItem(final String id, final Block block) {
    return registerBlockItem(
        id,
        new BlockItem(
            block,
            new Item.Properties()
                .setId(
                    ResourceKey.create(
                        Registries.ITEM, Identifier.fromNamespaceAndPath(Constants.MOD_ID, id)))));
  }

  private static Supplier<BlockItem> registerBlockItem(final String id, final BlockItem item) {
    Registry.register(BuiltInRegistries.ITEM, ModBlockItems.getBlockItemId(id), item);
    return () -> item;
  }
}
