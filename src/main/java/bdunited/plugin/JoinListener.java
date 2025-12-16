package bdunited.plugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        var p = e.getPlayer();

        p.sendMessage("§6BD UNITED SMP — Official Rules");
        p.sendMessage("§e1. No Hacks, Cheats, or X-Ray");
        p.sendMessage("§e2. No Violence or Toxic Behavior");
        p.sendMessage("§e3. No Bad or Offensive Language");
        p.sendMessage("§e4. Follow All Server Rules");
    }
          }
