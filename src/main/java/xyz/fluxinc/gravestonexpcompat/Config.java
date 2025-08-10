package xyz.fluxinc.gravestonexpcompat;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

// Demonstrates how to use Forge's config APIs
@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    private static final ForgeConfigSpec.IntValue XP_SAVE = BUILDER.comment("The percentage of XP to save").defineInRange("xp-share", 100, 0, 100);

    static final ForgeConfigSpec SPEC = BUILDER.build();
    public static float xpMultiplier;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        xpMultiplier = ((float)XP_SAVE.get() / 100);
    }
}
