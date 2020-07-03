package me.andreiwasfound.custommob;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.andreiwasfound.custommob.events.BlockPlace;
import me.andreiwasfound.custommob.events.EntityDamage;
import me.andreiwasfound.custommob.events.EntityDeath;

public class Main extends JavaPlugin {
	
	public List<ItemStack> stolenItems = new ArrayList<>();
	
	@Override
	public void onEnable() {
		
		PluginManager pm =this.getServer().getPluginManager();
		pm.registerEvents(new EntityDamage(), this);
		pm.registerEvents(new EntityDeath(this), this);
		pm.registerEvents(new BlockPlace(this), this);
		
	}
	
	@Override
	public void onDisable() {
		
	}

}
