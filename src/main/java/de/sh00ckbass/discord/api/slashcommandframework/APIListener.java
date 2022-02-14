package de.sh00ckbass.discord.api.slashcommandframework;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/*******************************************************
 * Copyright (C) Sh00ckBass tobias@sh00ckbass.de
 *
 * This file is part of SlashCommandFramework and was created at the 14.02.2022
 *
 * SlashCommandFramework can not be copied and/or distributed without the express
 * permission of the owner.
 *
 */

public class APIListener extends ListenerAdapter {

    private final Setup setup;

    public APIListener(final Setup setup) {
        this.setup = setup;
    }

    @Override
    public void onSlashCommandInteraction(final SlashCommandInteractionEvent event) {
        final String commandName = event.getName();

        final Guild guild = event.getGuild();
        final Member member = event.getMember();
        final User user = event.getUser();
        final TextChannel channel = event.getTextChannel();

        this.setup.getCommandManager().executeCommand(commandName, event, guild, member, user, channel);
    }
}
