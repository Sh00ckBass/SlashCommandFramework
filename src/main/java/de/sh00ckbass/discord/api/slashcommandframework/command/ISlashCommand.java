package de.sh00ckbass.discord.api.slashcommandframework.command;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.Collection;

public interface ISlashCommand {

    String description = "Default Command";

    void performCommand(SlashCommandInteractionEvent event, Guild guild, Member member, User user, TextChannel channel);

    String getDescription();

    Collection<OptionData> getOptions();

}
