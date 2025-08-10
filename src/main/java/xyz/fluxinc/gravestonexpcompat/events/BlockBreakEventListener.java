package xyz.fluxinc.gravestonexpcompat.events;

import de.maxhenkel.gravestone.GraveUtils;
import de.maxhenkel.gravestone.Main;
import de.maxhenkel.gravestone.tileentity.GraveStoneTileEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import xyz.fluxinc.gravestonexpcompat.Helper;

public class BlockBreakEventListener {

    @SubscribeEvent
    public void blockBreak(BlockEvent.BreakEvent event) {
        BlockEntity tileEntity = event.getLevel().getBlockEntity(event.getPos());
        if (tileEntity instanceof GraveStoneTileEntity grave) {
            if (!grave.getDeath().getId().equals(GraveUtils.EMPTY_UUID) && Main.SERVER_CONFIG.breakPickup.get()) {
                // grave experience is saved as levels rather than points
                event.getPlayer().giveExperienceLevels(Helper.calculateExperience(grave.getDeath().getExperience()));
            }
        }
    }
}
