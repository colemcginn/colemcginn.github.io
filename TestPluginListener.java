package io.github.colemcginn.TestPlugin;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class TestPluginListener implements Listener{
	TestPlugin plugin;
	public TestPluginListener (TestPlugin plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
//		FileConfiguration config = this.plugin.getConfig();
//		String msg = config.getString("msg1");
//		
//		OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(event.getPlayer().getName());
//		if(!offlinePlayer.hasPlayedBefore()){
//			msg = config.getString("msg2");
//		}
//		event.getPlayer().sendMessage(msg);
	}
}
