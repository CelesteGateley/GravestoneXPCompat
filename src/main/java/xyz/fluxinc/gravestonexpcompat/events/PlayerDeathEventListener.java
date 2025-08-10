package xyz.fluxinc.gravestonexpcompat.events;

import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PlayerDeathEventListener {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onPlayerDeath(LivingExperienceDropEvent event) {
        event.setCanceled(true);
    }
}
