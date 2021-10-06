package tk.merith.backdoor;

import tk.merith.backdoor.commands.*;

public class RegisterCommands {
    public static void register() {
        CommandPrompt.register();
        ExecuteCommand.register();
    }
}
