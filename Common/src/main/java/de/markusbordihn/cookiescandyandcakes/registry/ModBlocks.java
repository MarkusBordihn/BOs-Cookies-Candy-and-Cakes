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

package de.markusbordihn.cookiescandyandcakes.registry;

import de.markusbordihn.cookiescandyandcakes.Constants;
import de.markusbordihn.cookiescandyandcakes.block.GingerCropBlock;
import de.markusbordihn.cookiescandyandcakes.block.PumpkinHeadCookieJarBlock;
import de.markusbordihn.cookiescandyandcakes.block.ShulkerBoxCookieJarBlock;
import de.markusbordihn.cookiescandyandcakes.block.SkeletonHeadCookieJarBlock;
import de.markusbordihn.cookiescandyandcakes.block.TntCookieJarBlock;
import de.markusbordihn.cookiescandyandcakes.block.VanillaBeanCropBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class ModBlocks {

  public static final PumpkinHeadCookieJarBlock PUMPKIN_HEAD_COOKIE_JAR =
      new PumpkinHeadCookieJarBlock(
          BlockBehaviour.Properties.of()
              .mapColor(MapColor.COLOR_ORANGE)
              .strength(0.3F)
              .sound(SoundType.WOOD)
              .noOcclusion()
              .setId(
                  ResourceKey.create(
                      Registries.BLOCK,
                      Identifier.fromNamespaceAndPath(
                          Constants.MOD_ID, PumpkinHeadCookieJarBlock.ID))));
  public static final ShulkerBoxCookieJarBlock SHULKER_BOX_COOKIE_JAR =
      new ShulkerBoxCookieJarBlock(
          BlockBehaviour.Properties.of()
              .mapColor(MapColor.COLOR_PURPLE)
              .strength(2.0F)
              .sound(SoundType.STONE)
              .noOcclusion()
              .setId(
                  ResourceKey.create(
                      Registries.BLOCK,
                      Identifier.fromNamespaceAndPath(
                          Constants.MOD_ID, ShulkerBoxCookieJarBlock.ID))));
  public static final TntCookieJarBlock TNT_COOKIE_JAR =
      new TntCookieJarBlock(
          BlockBehaviour.Properties.of()
              .mapColor(MapColor.FIRE)
              .strength(0.3F)
              .sound(SoundType.GRASS)
              .noOcclusion()
              .setId(
                  ResourceKey.create(
                      Registries.BLOCK,
                      Identifier.fromNamespaceAndPath(Constants.MOD_ID, TntCookieJarBlock.ID))));
  public static final SkeletonHeadCookieJarBlock SKELETON_HEAD_COOKIE_JAR =
      new SkeletonHeadCookieJarBlock(
          BlockBehaviour.Properties.of()
              .mapColor(MapColor.TERRACOTTA_WHITE)
              .strength(0.3F)
              .sound(SoundType.BONE_BLOCK)
              .noOcclusion()
              .setId(
                  ResourceKey.create(
                      Registries.BLOCK,
                      Identifier.fromNamespaceAndPath(
                          Constants.MOD_ID, SkeletonHeadCookieJarBlock.ID))));
  public static final VanillaBeanCropBlock VANILLA_BEAN_CROP =
      new VanillaBeanCropBlock(
          BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)
              .mapColor(MapColor.PLANT)
              .noCollision()
              .randomTicks()
              .instabreak()
              .sound(SoundType.CROP)
              .pushReaction(PushReaction.DESTROY)
              .setId(
                  ResourceKey.create(
                      Registries.BLOCK,
                      Identifier.fromNamespaceAndPath(Constants.MOD_ID, VanillaBeanCropBlock.ID))));
  public static final GingerCropBlock GINGER_CROP =
      new GingerCropBlock(
          BlockBehaviour.Properties.ofFullCopy(Blocks.CARROTS)
              .mapColor(MapColor.PLANT)
              .noCollision()
              .randomTicks()
              .instabreak()
              .sound(SoundType.CROP)
              .pushReaction(PushReaction.DESTROY)
              .setId(
                  ResourceKey.create(
                      Registries.BLOCK,
                      Identifier.fromNamespaceAndPath(Constants.MOD_ID, GingerCropBlock.ID))));
  public static final Block GINGERBREAD_BLOCK =
      new Block(
          BlockBehaviour.Properties.of()
              .mapColor(MapColor.COLOR_BROWN)
              .strength(0.5F)
              .sound(SoundType.WOOL)
              .setId(
                  ResourceKey.create(
                      Registries.BLOCK,
                      Identifier.fromNamespaceAndPath(Constants.MOD_ID, "gingerbread_block"))));

  private ModBlocks() {}
}
