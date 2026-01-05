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
import de.markusbordihn.cookiescandyandcakes.data.cookiejar.CookieJarType;
import de.markusbordihn.cookiescandyandcakes.registry.ModBlockItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class ForgeModBlockItems {

  public static final DeferredRegister<Item> BLOCK_ITEMS =
      DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);

  public static final RegistryObject<BlockItem> PUMPKIN_HEAD_COOKIE_JAR =
      BLOCK_ITEMS.register(
          CookieJarType.PUMPKIN_HEAD.getId(),
          () ->
              new CookieJarItem(
                  ForgeModBlocks.PUMPKIN_HEAD_COOKIE_JAR.get(), CookieJarType.PUMPKIN_HEAD));

  public static final RegistryObject<BlockItem> SHULKER_BOX_COOKIE_JAR =
      BLOCK_ITEMS.register(
          CookieJarType.SHULKER_BOX.getId(),
          () ->
              new CookieJarItem(
                  ForgeModBlocks.SHULKER_BOX_COOKIE_JAR.get(), CookieJarType.SHULKER_BOX));

  public static final RegistryObject<BlockItem> SKELETON_HEAD_COOKIE_JAR =
      BLOCK_ITEMS.register(
          CookieJarType.SKELETON_HEAD.getId(),
          () ->
              new CookieJarItem(
                  ForgeModBlocks.SKELETON_HEAD_COOKIE_JAR.get(), CookieJarType.SKELETON_HEAD));

  public static final RegistryObject<BlockItem> TNT_COOKIE_JAR =
      BLOCK_ITEMS.register(
          CookieJarType.TNT.getId(),
          () -> new CookieJarItem(ForgeModBlocks.TNT_COOKIE_JAR.get(), CookieJarType.TNT));

  public static final RegistryObject<BlockItem> GINGERBREAD_BLOCK =
      BLOCK_ITEMS.register(
          "gingerbread_block",
          () ->
              new BlockItem(
                  ForgeModBlocks.GINGERBREAD_BLOCK.get(),
                  new Item.Properties()
                      .setId(
                          ResourceKey.create(
                              Registries.ITEM,
                              Identifier.fromNamespaceAndPath(
                                  Constants.MOD_ID, "gingerbread_block")))));

  private ForgeModBlockItems() {}

  @SubscribeEvent
  public static void onCommonSetup(FMLCommonSetupEvent event) {
    event.enqueueWork(
        () -> {
          ModBlockItems.PUMPKIN_HEAD_COOKIE_JAR = PUMPKIN_HEAD_COOKIE_JAR::get;
          ModBlockItems.SHULKER_BOX_COOKIE_JAR = SHULKER_BOX_COOKIE_JAR::get;
          ModBlockItems.SKELETON_HEAD_COOKIE_JAR = SKELETON_HEAD_COOKIE_JAR::get;
          ModBlockItems.TNT_COOKIE_JAR = TNT_COOKIE_JAR::get;
          ModBlockItems.GINGERBREAD_BLOCK = GINGERBREAD_BLOCK::get;
        });
  }
}
