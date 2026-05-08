package com.lapisdev.vanillacraft.kick;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.InteractionContextType;
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jspecify.annotations.NonNull;

import static com.lapisdev.vanillacraft.discord.Discord.jda;

public class KickCmdDc extends ListenerAdapter {
    public static void register() {
        jda.updateCommands().addCommands(Commands.slash("mckick", "Kick a player from the Minecraft server, given their Minecraft username or a Discord ping.")
                        .addOptions(new OptionData(OptionType.USER, "dcuser", "Kick a player's Minecraft account associated with this discord account."),
                                new OptionData(OptionType.STRING, "mcuser", "Kick the Minecraft account with the given username."))
                .setContexts(InteractionContextType.GUILD)
                .setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.MESSAGE_MANAGE)))
                .queue();
        jda.addEventListener(new KickCmdDc());
    }

    @Override
    public void onSlashCommandInteraction(@NonNull SlashCommandInteractionEvent event) {
        super.onSlashCommandInteraction(event);
    }
}
