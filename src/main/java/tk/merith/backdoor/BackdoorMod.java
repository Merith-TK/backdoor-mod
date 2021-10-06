package tk.merith.backdoor;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BackdoorMod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("backdoor");

	@Override
	public void onInitialize() {
		RegisterCommands.register();

		LOGGER.info("BackDoor Loaded");
	}
}
