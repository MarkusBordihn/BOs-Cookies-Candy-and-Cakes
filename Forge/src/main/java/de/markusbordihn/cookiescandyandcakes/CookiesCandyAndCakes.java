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

package de.markusbordihn.cookiescandyandcakes;

import de.markusbordihn.cookiescandyandcakes.block.ForgeModBlocks;
import de.markusbordihn.cookiescandyandcakes.block.entity.ForgeModBlockEntities;
import de.markusbordihn.cookiescandyandcakes.config.Config;
import de.markusbordihn.cookiescandyandcakes.entity.ForgeModEntityTypes;
import de.markusbordihn.cookiescandyandcakes.item.ForgeModBlockItems;
import de.markusbordihn.cookiescandyandcakes.item.ForgeModItems;
import de.markusbordihn.cookiescandyandcakes.menu.ForgeMenuOpener;
import de.markusbordihn.cookiescandyandcakes.menu.ForgeModMenus;
import de.markusbordihn.cookiescandyandcakes.menu.MenuManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("unused")
@Mod(Constants.MOD_ID)
public class CookiesCandyAndCakes {

  private static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  @SuppressWarnings({"java:S1118", "java:S2440"})
  public CookiesCandyAndCakes(FMLJavaModLoadingContext context) {
    final BusGroup modBusGroup = context.getModBusGroup();

    log.info("Initializing {} (Forge) ...", Constants.MOD_NAME);

    log.info("{} Constants ...", Constants.LOG_REGISTER_PREFIX);
    Constants.GAME_DIR = FMLPaths.GAMEDIR.get();
    Constants.CONFIG_DIR = FMLPaths.CONFIGDIR.get();

    log.info("{} Configuration ...", Constants.LOG_REGISTER_PREFIX);
    Config.register(FMLEnvironment.dist == Dist.DEDICATED_SERVER);

    log.info("{} Menu Manager ...", Constants.LOG_REGISTER_PREFIX);
    MenuManager.setMenuOpener(new ForgeMenuOpener());

    log.info("{} Blocks ...", Constants.LOG_REGISTER_PREFIX);
    ForgeModBlocks.BLOCKS.register(modBusGroup);

    log.info("{} Block Entities ...", Constants.LOG_REGISTER_PREFIX);
    ForgeModBlockEntities.BLOCK_ENTITY_TYPES.register(modBusGroup);

    log.info("{} Entity Types ...", Constants.LOG_REGISTER_PREFIX);
    ForgeModEntityTypes.ENTITY_TYPES.register(modBusGroup);

    log.info("{} Block Items ...", Constants.LOG_REGISTER_PREFIX);
    ForgeModBlockItems.BLOCK_ITEMS.register(modBusGroup);

    log.info("{} Items ...", Constants.LOG_REGISTER_PREFIX);
    ForgeModItems.ITEMS.register(modBusGroup);

    log.info("{} Menus ...", Constants.LOG_REGISTER_PREFIX);
    ForgeModMenus.MENU_TYPES.register(modBusGroup);

    log.info("{} Creative Tabs ...", Constants.LOG_REGISTER_PREFIX);
    ForgeModItems.CREATIVE_MODE_TABS.register(modBusGroup);

    if (FMLEnvironment.dist.isClient()) {
      new CookiesCandyAndCakesClient(context.getModEventBus());
    }
  }
}
