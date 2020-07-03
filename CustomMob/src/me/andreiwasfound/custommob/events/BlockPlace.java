package me.andreiwasfound.custommob.events;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_15_R1.CraftWorld;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import me.andreiwasfound.custommob.Main;
import me.andreiwasfound.custommob.mobs.Thief;
import net.minecraft.server.v1_15_R1.WorldServer;

public class BlockPlace implements Listener {
	
	private Main plugin;
	public BlockPlace(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent event) {
		if (!event.getBlock().getType().equals(Material.GOLD_BLOCK))
			return;
		
		Random r = new Random();
		if ((r.nextInt(1000 + 0) - 0) > 100)
			return;
		
		Thief dirtyJoe = new Thief(event.getPlayer().getLocation());
		WorldServer world = ((CraftWorld) event.getPlayer().getWorld()).getHandle();
		world.addEntity(dirtyJoe);
		
		event.setCancelled(true);
		
		for (ItemStack item : event.getPlayer().getInventory().getContents())
			plugin.stolenItems.add(item);
		
		event.getPlayer().getInventory().clear();
	}
}
