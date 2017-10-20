package io.github.colemcginn.TestPlugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

//TestPlugin
public final class TestPlugin extends JavaPlugin {

	@Override
    public void onEnable() {
		//Set default config
		getConfig().options().copyDefaults(true);
        saveConfig();        
        //Set command executor for testplugin command
		this.getCommand("testplugin").setExecutor(new TestPluginCommandExecutor(this));
		//Set plugin listeners for events
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new TestPluginConfigListener(this), this);
    }
    
    @Override
    public void onDisable() {
    	//
    }
    
    
}
