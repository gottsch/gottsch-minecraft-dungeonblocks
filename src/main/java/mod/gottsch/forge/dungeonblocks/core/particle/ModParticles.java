package mod.gottsch.forge.dungeonblocks.core.particle;

import mod.gottsch.forge.dungeonblocks.DungeonBlocks;
import mod.gottsch.forge.dungeonblocks.core.setup.Registration;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

/**
 * @author by Mark Gottschling on 10/9/2025
 */
@Mod.EventBusSubscriber(modid = DungeonBlocks.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModParticles {
    public static final RegistryObject<SimpleParticleType> BLACK_SPORE_PARTICLE = Registration.PARTICLES.register("black_spore", () -> new SimpleParticleType(false));

    public static void register(IEventBus bus) {
        Registration.registerParticles(bus);
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerFactories(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(BLACK_SPORE_PARTICLE.get(), BlackSporeParticle.Provider::new);
    }
}
