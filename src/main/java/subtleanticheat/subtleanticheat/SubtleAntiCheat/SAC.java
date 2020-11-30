package subtleanticheat.subtleanticheat.SubtleAntiCheat;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.*;
import org.bukkit.plugin.java.JavaPlugin;
import subtleanticheat.subtleanticheat.SubtleAntiCheat.checks.*;


public final class SAC extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents( new FlyA() , this );
        pm.registerEvents( new NoSlowA() , this );
        pm.registerEvents( new KillauraA() , this );
        pm.registerEvents(new AntiKB() , this );
        pm.registerEvents(new WaterWalkA() , this );
    }
}
