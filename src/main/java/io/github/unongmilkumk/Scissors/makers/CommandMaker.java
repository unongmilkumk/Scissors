package io.github.unongmilkumk.Scissors.makers;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class CommandMaker {
    public String namespace;
    public String name;
    public BiConsumer<CommandSender, String[]> command;
    public List<String> alias = new ArrayList<>();

    public CommandMaker(String namespace, String name) {
        this.namespace = namespace;
        this.name = name;
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
        Bukkit.getCommandMap().register(namespace, new Command(name) {
            @Override
            public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
                command.accept(sender, args);
                return true;
            }
        }.setAliases(alias));
    }
}