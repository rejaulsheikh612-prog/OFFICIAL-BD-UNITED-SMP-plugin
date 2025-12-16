package bdunited.plugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    private final ComplaintManager manager;

    public ChatListener(ComplaintManager manager) {
        this.manager = manager;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        String msg = e.getMessage();
        var p = e.getPlayer();

        if (!msg.startsWith(".")) return;

        e.setCancelled(true);

        if (msg.equalsIgnoreCase(".hi")) {
            p.sendMessage("§aHi, how can I help you?");
            return;
        }

        if (msg.equalsIgnoreCase(".tell")) {
            p.sendMessage("§6BD UNITED SMP — Official Rules");
            p.sendMessage("§e1. No Hacks, Cheats, or X-Ray");
            p.sendMessage("§e2. No Violence or Toxic Behavior");
            p.sendMessage("§e3. No Bad or Offensive Language");
            p.sendMessage("§e4. Follow All Server Rules");
            return;
        }

        if (msg.startsWith(".complain")) {
            String[] parts = msg.split(" ", 3);
            if (parts.length < 3) {
                p.sendMessage("§cUsage: .complain <player> <reason>");
                return;
            }

            manager.save(p.getName(), parts[1], parts[2]);
            p.sendMessage("§aComplaint saved. Admin will review.");
        }
    }
                                 }
