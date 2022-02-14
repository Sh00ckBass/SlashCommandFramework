package de.sh00ckbass.discord.api.slashcommandframework;

import de.sh00ckbass.discord.api.slashcommandframework.command.SlashCommandManager;
import lombok.Getter;
import net.dv8tion.jda.api.JDA;

/*******************************************************
 * Copyright (C) Sh00ckBass tobias@sh00ckbass.de
 *
 * This file is part of SlashCommandFramework and was created at the 14.02.2022
 *
 * SlashCommandFramework can not be copied and/or distributed without the express
 * permission of the owner.
 *
 */
public class Setup {

    /**
     * Get your Instance of {@link SlashCommandManager}
     */
    @Getter
    private final SlashCommandManager commandManager;

    public Setup(final JDA jda) {
        this.commandManager = new SlashCommandManager();
        jda.addEventListener(new APIListener(this));
    }

}
