package subtleanticheat.subtleanticheat.SubtleAntiCheat.checks;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class NoSlowA implements Listener {
    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer( );
        double dist = e.getTo( ).distance( e.getFrom( ) );
        if (! p.isOnGround())return;
        if ( ! p.isBlocking( ) ) return;
        if(dist > 0.21589){
            e.setTo( e.getFrom() );
            Bukkit.broadcast( p.getName()+" : §c§l NoSlow" ,"subtleanticheat.log" );
        }
    }
}
