package bdunited.plugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        String msg = event.getMessage().toLowerCase();

        if (msg.equals(".tell me rule again")) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(Rules.TEXT);
        }
    }
}
