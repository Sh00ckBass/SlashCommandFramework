package de.sh00ckbass.discord.api.slashcommandframework.command;

import de.sh00ckbass.discord.api.slashcommandframework.APIListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*******************************************************
 * Copyright (C) Sh00ckBass tobias@sh00ckbass.de
 *
 * This file is part of SlashCommandFramework and was created at the 14.02.2022
 *
 * SlashCommandFramework can not be copied and/or distributed without the express
 * permission of the owner.
 *
 */
public class SlashCommandManager {

    private final Map<String, ISlashCommand> commandMap;

    public SlashCommandManager() {
        this.commandMap = new ConcurrentHashMap<>();
    }

    /**
     * Register a new SlashCommand to {@link SlashCommandManager }
     *
     * @param name         Command Name
     * @param slashCommand Instance of {@link ISlashCommand}
     */
    public void registerCommand(final String name, final ISlashCommand slashCommand) {
        this.commandMap.put(name, slashCommand);
    }

    /**
     * Register all Commands to your JDA Class
     *
     * @param jda Your Instance of {@link JDA}
     */
    public void registerAllCommands(final JDA jda) {
        for (final String command : this.commandMap.keySet()) {
            final ISlashCommand command1 = this.commandMap.get(command);
            jda.upsertCommand(command, command1.getDescription()).addOptions(command1.getOptions()).queue();
        }
    }

    /**
     * Execute a Command. This method will be only called in the {@link APIListener}
     *
     * @param commandName Command Name
     * @param event       {@link SlashCommandInteractionEvent}
     * @param guild       {@link Guild}
     * @param member      {@link Member}
     * @param user        {@link User}
     * @param channel     {@link TextChannel}
     */
    public void executeCommand(final String commandName, final SlashCommandInteractionEvent event, final Guild guild,
                               final Member member, final User user, final TextChannel channel) {
        final ISlashCommand command = this.commandMap.get(commandName);
        if (command != null) {
            command.performCommand(event, guild, member, user, channel);
        }
    }


}
