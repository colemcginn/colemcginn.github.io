package io.github.colemcginn.TestPlugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

//Command Executor
public class TestPluginCommandExecutor implements CommandExecutor {
	private final TestPlugin plugin;
	//Set plugin
	public TestPluginCommandExecutor(TestPlugin plugin) {
		this.plugin = plugin;
	}
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		//Check for testplugin command
		if(cmd.getName().equalsIgnoreCase("testplugin")) {	
			//Check if any other args
			if(args.length==0) {
				sender.sendMessage("incorrect command");
				return false;
			}
			//command: reload
			if(args[0].equalsIgnoreCase("reload")) {
				//check permissions
				if(!sender.hasPermission("TestPlugin.reload")) {
					sender.sendMessage("no permission for reload");
					return false;
				}
				//reload from disk
				plugin.reloadConfig();
				sender.sendMessage(ChatColor.DARK_PURPLE+ "Config reloaded");
				return true;
			}
			//command: block
			if(args[0].equalsIgnoreCase("block")) {
				//check permissions
				if(!sender.hasPermission("TestPlugin.block")) {
					sender.sendMessage("no permission for block change");
					return false;
				}
				//check for block information
				if(args.length>1) {
					//make sure it's real block type
					try {
						Material.valueOf(args[1].toUpperCase()); 
					} catch(IllegalArgumentException e) {
						sender.sendMessage("incorrect block type");
						return false;
					}
					//Save to config
					plugin.getConfig().set("blocktype", args[1].toUpperCase());
					plugin.saveConfig();
					sender.sendMessage(ChatColor.DARK_PURPLE+ "Block type changed to: "+args[1]);
					return true;
				}
				//not enough args
				sender.sendMessage("incorrect command");
				return false;
			}
			//command: join
			if(args[0].equalsIgnoreCase("join")) {
				//check permissions
				if(!sender.hasPermission("TestPlugin.join")) {
					sender.sendMessage("no permission for join");
					return false;
				}
				if(args.length>1) {
					//build string from args
					StringBuilder msgbuilder = new StringBuilder();
					for(int i=1;i<args.length;i++) {
						msgbuilder.append(ChatColor.translateAlternateColorCodes('&',args[i])+" ");
					}
					String msg = msgbuilder.toString();
					//save to config
					plugin.getConfig().set("join",msg);
					plugin.saveConfig();
					sender.sendMessage(ChatColor.DARK_PURPLE+ "Join message changed to: "+msg);
					return true;
				}
				//not enough args
				sender.sendMessage("incorrect command");
				return false;
			}
			//command: firstjoin
			if(args[0].equalsIgnoreCase("firstjoin")) {
				//check permissions
				if(!sender.hasPermission("TestPlugin.firstjoin")) {
					sender.sendMessage("no permission for firstjoin");
					return false;
				}
				if(args.length>1) {
					//build strings from args
					StringBuilder msgbuilder = new StringBuilder();
					for(int i=1;i<args.length;i++) {
						msgbuilder.append(ChatColor.translateAlternateColorCodes('&',args[i])+" ");
					}
					String msg = msgbuilder.toString();
					//save to config
					plugin.getConfig().set("firstjoin",msg);
					plugin.saveConfig();
					sender.sendMessage(ChatColor.DARK_PURPLE+ "First join message changed to: "+msg);
					return true;
				}
				//not enough args
				sender.sendMessage("incorrect command");
				return false;
			}
			
			
		}
		//if any other command
		sender.sendMessage("incorrect command");
    	return false;
    }
}
