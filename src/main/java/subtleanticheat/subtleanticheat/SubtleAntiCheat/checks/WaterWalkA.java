package subtleanticheat.subtleanticheat.SubtleAntiCheat.checks;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class WaterWalkA implements Listener {
    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Player p = e.getPlayer();
        if(p.isGliding() || p.isFlying())return;
        Location loc1 = new Location(p.getWorld(),p.getLocation().getX(),p.getLocation().getY()-1,p.getLocation().getZ());
        if(loc1.getBlock().getType() == Material.WATER){
            e.setTo(e.getFrom());
            Bukkit.broadcast( p.getName()+" : §c§l WaterWalkA" ,"subtleanticheat.log" );
        }
    }
}
