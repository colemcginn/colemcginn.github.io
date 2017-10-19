package io.github.colemcginn.TestPlugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;

public class TestPluginCommandExecutor implements CommandExecutor {
	private final TestPlugin plugin;

	public TestPluginCommandExecutor(TestPlugin plugin) {
		this.plugin = plugin; // Store the plugin in situations where you need it.
	}
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("testplugin")) {
			if(args.length==1) {
				if(args[0].equalsIgnoreCase("reload")) {
					//
					plugin.reloadConfig();
// 					config = YamlConfiguration.loadConfiguration(cFile);
					return true;
				}
			}
			if(args.length>1) {
				//
				if(args[0].equalsIgnoreCase("join")) {
					String msg = new String();
					for(int i=1;i<args.length;i++) {
						msg.concat(args[i]);
					}
					plugin.getConfig().set("join",msg);
					plugin.saveConfig();
					FileConfiguration config = plugin.getConfig();
					String newmsg = config.getString("join");
//					sender.getPlayer().sendMessage(msg);
					Bukkit.broadcastMessage(newmsg);
					//I chose not to reload because of /reload command
				}
				return true;
			} 
		}
//    	if (cmd.getName().equalsIgnoreCase("basic")) { // If the player typed /basic then do the following...
//    		// do something...
//    		sender.sendMessage("Hello basic");
//    		return true;
//    	} else if (cmd.getName().equalsIgnoreCase("basic2")) {
//    		if (!(sender instanceof Player)) {
//    			sender.sendMessage("This command can only be run by a player.");
//    		} else {
//    			Player player = (Player) sender;
//    			// do something
//    		}
//    		return true;
//    	}
    	return false;
    }
}
