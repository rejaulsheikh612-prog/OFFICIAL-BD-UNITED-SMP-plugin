package bdunited.plugin;

import org.bukkit.plugin.java.JavaPlugin;

public class BDUnitedPlugin extends JavaPlugin {

    private ComplaintManager complaintManager;

    @Override
    public void onEnable() {
        complaintManager = new ComplaintManager(this);

        getServer().getPluginManager().registerEvents(
                new JoinListener(), this
        );

        getServer().getPluginManager().registerEvents(
                new ChatListener(complaintManager), this
        );

        new WebServer(complaintManager).start();

        getLogger().info("BD United Plugin Enabled");
    }
      }
