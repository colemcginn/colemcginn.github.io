package io.github.colemcginn.TestPlugin;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class TestPluginConfigListener implements Listener{
		TestPlugin plugin;
		//set plugin
		public TestPluginConfigListener(TestPlugin instance) {
			plugin = instance;
		}
		 
		@EventHandler
		public void onJoin(PlayerJoinEvent event) {
			//get config
			FileConfiguration config = plugin.getConfig();
			//choose message - one for joining sever for first time, other for returning players
			if(!event.getPlayer().hasPlayedBefore()){;
				event.getPlayer().sendMessage(config.getString("joinfirst"));
			} else {
				event.getPlayer().sendMessage(config.getString("join"));
			}
			
		}
		
		//if player breaks block, prevent break and replace with block from config
		@EventHandler
		public void onMine(BlockBreakEvent event) { 
			FileConfiguration config = plugin.getConfig();
			if(config.getBoolean("replaceblock")) {
				event.setCancelled(true);
				event.getBlock().setType(Material.valueOf(config.getString("blocktype")));
			}
		}
		
}
