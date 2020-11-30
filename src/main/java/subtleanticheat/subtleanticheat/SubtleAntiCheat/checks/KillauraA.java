package subtleanticheat.subtleanticheat.SubtleAntiCheat.checks;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.Collections;

public class KillauraA implements Listener {
    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e){
        if(e.getDamager() instanceof Player ){
            Player p = ( (Player) e.getDamager() ).getPlayer();
            double dist = e.getEntity().getLocation().distance( p.getLocation() );
            if(dist > 3.5){
                e.setCancelled( true );
                Bukkit.broadcast( p.getName()+" : §c§l KillAuraA" ,"subtleanticheat.log" );
            }

        }
    }
}
