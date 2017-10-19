package io.github.colemcginn.TestPlugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;

public final class TestPlugin extends JavaPlugin {
	@Override
    public void onEnable() {
		this.getCommand("basic").setExecutor(new TestPluginCommandExecutor(this));
		PluginManager pm = getServer().getPluginManager();
		TestPluginListener listener = new TestPluginListener(this);
		pm.registerEvents(listener, this);
//		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new TestPluginConfigListener(this), this);
		
		getLogger().info("onEnable has been invoked!");
//		for (Player player : Bukkit.getServer().getOnlinePlayers()) {
//		    playerList.put(player.getName(), playerData(player));
//		}
    }
    
    @Override
    public void onDisable() {
    	getLogger().info("onDisable has been invoked!");
    }
    
    
}
