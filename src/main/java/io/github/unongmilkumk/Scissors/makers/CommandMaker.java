package io.github.unongmilkumk.Scissors.makers;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class CommandMaker {
    private final String namespace;
    private final String name;
    private BiConsumer<CommandSender, String[]> command;
    private List<String> alias = new ArrayList<>();
    private String description;
    private String permission;
    private String usage;

    public CommandMaker(String namespace, String name) {
        this.namespace = namespace;
        this.name = name;
    }

    public CommandMaker setDescription(String description) {
        this.description = description;
        return this;
    }

    public CommandMaker setPermission(String permission) {
        this.permission = permission;
        return this;
    }

    public CommandMaker setUsage(String usage) {
        this.usage = usage;
        return this;
    }

    public CommandMaker setCommand(BiConsumer<CommandSender, String[]> command) {
        this.command = command;
        return this;
    }

    public CommandMaker setAlias(List<String> alias) {
        this.alias = alias;
        return this;
    }

    public void register() {
        Command command1 = new Command(name) {
            @Override
            public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
                if (permission != null && !sender.hasPermission(permission)) {
                    sender.sendMessage("You don't have permission to use this command.");
                    return true;
                }

                command.accept(sender, args);
                return true;
            }
        }.setAliases(alias).setDescription(description).setUsage(usage);
        command1.setPermission(permission);
        Bukkit.getCommandMap().register(namespace, command1);
    }
}
