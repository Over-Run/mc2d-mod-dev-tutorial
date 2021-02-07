package com.examplemod;

import io.github.overrun.mc2d.block.Block;
import io.github.overrun.mc2d.item.BlockItem;
import io.github.overrun.mc2d.mod.Mod;
import io.github.overrun.mc2d.mod.ModInitializer;
import io.github.overrun.mc2d.util.Identifier;
import io.github.overrun.mc2d.util.registry.Registry;

/**
 * @author squid233
 * @since 2021/02/07
 */
public final class ExampleMod implements ModInitializer {
    @Mod.Modid
    public static String modid;

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier(modid, "example_block"), new BlockItem(Registry.register(Registry.BLOCK, new Identifier(modid, "example_block"), new Block())));
    }
}
