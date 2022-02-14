# Slash Command-Framework

This is a simple Discord JDA Slash Command-Framework

## Setup

```java
import de.sh00ckbass.discord.api.slashcommandframework.Setup;
import de.sh00ckbass.discord.api.slashcommandframework.command.SlashCommandManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Bot {

    private JDA jda;
    private Setup setup;
    private CommandManager commandManager;

    public Bot() throws LoginException {
        final JDABuilder jdaBuilder = JDABuilder.createDefault(Secret.TOKEN);
        this.jda = jdaBuilder.build();
        this.setup = new Setup(this.jda);
        this.commandManager = this.setup.getCommandManager();
    }

    public static void main(final String[] args) {
        try {
            new Bot();
        } catch (LoginException exception) {
            exception.printStackTrace();
        }
    }

}
```

## Usage

### Example command

```java
import de.sh00ckbass.discord.api.slashcommandframework.command.ISlashCommand;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.Collection;

public class HelloWorldCommand implements ISlashCommand {

    @Override
    public void performCommand(final SlashCommandInteractionEvent event, final Guild guild, final Member member, final User user, final TextChannel channel) {
        event.reply("Hello World!").queue();
    }

    @Override
    public String getDescription() {
        return "Says \"Hello World!\""; // Can't be null
    }

    @Override
    public Collection<OptionData> getOptions() {
        return null; // Can be null
        //return List.of(new OptionData(OptionType.USER, "user", "Username")); That's an example for adding options
    }

}
```

### Registration

```java
import de.sh00ckbass.discord.api.slashcommandframework.Setup;
import de.sh00ckbass.discord.api.slashcommandframework.command.SlashCommandManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Bot {

    private JDA jda;
    private Setup setup;
    private CommandManager commandManager;

    public Bot() throws LoginException {
        final JDABuilder jdaBuilder = JDABuilder.createDefault(Secret.TOKEN);
        this.jda = jdaBuilder.build();
        this.setup = new Setup(this.jda);
        this.commandManager = this.setup.getCommandManager();

        this.commandManager.registerCommand("helloworld", new HelloWorldCommand()); //Register a command in the command manager 
        this.commandManager.registerAllCommands(this.jda); //It's very important to add this line because it won't work without it 
    }

    public static void main(final String[] args) {
        try {
            new Bot();
        } catch (LoginException exception) {
            exception.printStackTrace();
        }
    }

}
```

## Maven dependency

Repository

```xml

<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```

Dependency

```xml

<dependency>
    <groupId>com.github.Sh00ckBass</groupId>
    <artifactId>SlashCommandFramework</artifactId>
    <version>v1.0.0</version>
</dependency>
```