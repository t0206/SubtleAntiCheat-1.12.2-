package subtleanticheat.subtleanticheat.SubtleAntiCheat.checks;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class FlyA implements Listener {
    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer( );
        if ( p.isFlying( ) || p.getAllowFlight( ) || p.getGameMode( ) == GameMode.CREATIVE || p.getGameMode( ) == GameMode.SPECTATOR  || p.isGliding())
            return;
        if(p.isOnGround()) return;
        if(p.isSneaking()) return;
        Location to = e.getTo( );
        Location from = e.getFrom( );
        double toX = to.getX( );
        double toZ = to.getZ( );
        double fromX = from.getX( );
        double fromZ = from.getZ( );
        Location t = new Location(p.getWorld(),toX,0 , toZ);
        Location f = new Location(p.getWorld(),fromX,0 ,fromZ );
        Location sBlockLoc = new Location(p.getWorld(), p.getLocation().getX(),p.getLocation().getY()-1, p.getLocation().getZ());
        double dist = t.distance( f );
        if(sBlockLoc.getBlock().getType() != Material.AIR)return;
        if(to.getY() < from.getY())return;
        if(dist > 0.625){
            e.setTo(from);
            Bukkit.broadcast( p.getName()+" : §c§l FlyA" ,"subtleanticheat.log" );
        }
    }
}
