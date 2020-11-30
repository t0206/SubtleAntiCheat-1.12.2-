package subtleanticheat.subtleanticheat.SubtleAntiCheat.checks;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;
import java.util.UUID;

public class AntiKB implements Listener{
    HashMap<UUID,Integer> ctd = new HashMap<>();
    Location to ;
    Location from;
    @EventHandler
    public void onDamage(PlayerMoveEvent e){
        to = e.getTo();
        from = e.getFrom();
    }
    @EventHandler
    public void onDamage(EntityDamageEvent e){
        if(e.getEntity() instanceof Player){
            Player p = ( (Player) e.getEntity() ).getPlayer();
            if(to ==null || from == null)return;
            double dist = to.distance( from );
            if(p.isBlocking())return;
            if(dist == 0.0){
                if(ctd.get( p.getUniqueId() ) !=null){
                    ctd.put( p.getUniqueId(), ctd.get( p.getUniqueId() ) +1  );
                    if(ctd.get( p.getUniqueId() ) > 10){
                        ctd.remove( p.getUniqueId() );
                        Bukkit.broadcast( p.getName()+" : §c§l AntiKB" ,"subtleanticheat.log" );
                    }
                }else {
                    ctd.put( p.getUniqueId(), 1  );
                }
            }
            if(dist < 0.001){
                if(ctd.get( p.getUniqueId() ) !=null){
                    ctd.put( p.getUniqueId(), ctd.get( p.getUniqueId() ) +1  );
                    if(ctd.get( p.getUniqueId() ) > 10){
                        ctd.remove( p.getUniqueId() );
                        e.setDamage( 1 );
                    }
                }else {
                    ctd.put( p.getUniqueId(), 1  );
                }
            }
        }
    }
    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        ctd.remove( e.getPlayer().getUniqueId() );
    }
}
