package io.github.colemcginn.TestPlugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class TestPluginConfigListener implements Listener{
		TestPlugin plugin;
		 
		public TestPluginConfigListener(TestPlugin instance) {
		plugin = instance;
		}
		 
		@EventHandler
		public void onJoin(PlayerJoinEvent event) {
//		Player player = e.getPlayer();
//		 
//		player.sendMessage(plugin.getConfig().getString("msg1"));
			FileConfiguration config = this.plugin.getConfig();
			String msg = config.getString("join");
			
			OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(event.getPlayer().getName());
			if(!offlinePlayer.hasPlayedBefore()){
				msg = config.getString("joinfirst");
			}
			event.getPlayer().sendMessage(msg);
		}
		
		@EventHandler
		public void onMine(BlockBreakEvent event) { //onBlockBreak
			FileConfiguration config = plugin.getConfig();
			Boolean replace = config.getBoolean("replaceblock");
			if(replace) {
				event.setCancelled(true);
// 				block.setType(Material.valueOf(Config.getString("PATH")));
				event.getBlock().setType(Material.ICE);
			}
		}
		
}
