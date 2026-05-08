package com.lapisdev.vanillacraft.kick;

import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;

import static com.lapisdev.vanillacraft.VanillacraftPlugin.plugin;
import static com.lapisdev.vanillacraft.discord.Discord.jda;

public class KickCommandRegistry {
    public static void register() {
        plugin().getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS, (registry) -> {
            KickCmdMc.register(registry.registrar());
        });

        KickCmdDc.register();
    }
}
