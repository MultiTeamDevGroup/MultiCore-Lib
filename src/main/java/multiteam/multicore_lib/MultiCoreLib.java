package multiteam.multicore_lib;

import multiteam.multicore_lib.setup.example.Registration;
import multiteam.multicore_lib.setup.utilities.render.tooltip.itemcomp.ClientItemTooltipComponent;
import multiteam.multicore_lib.setup.utilities.render.tooltip.itemcomp.ItemTooltipComponent;
import multiteam.multicore_lib.setup.utilities.render.tooltip.itemtextcomp.ClientItemWithTextTooltipComponent;
import multiteam.multicore_lib.setup.utilities.render.tooltip.itemtextcomp.ItemWithTextTooltipComponent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(MultiCoreLib.MOD_ID)
public class MultiCoreLib {
    public static final String MOD_ID = "multicore_lib";
    private static final Logger LOGGER = LogManager.getLogger();

    public MultiCoreLib() {
        Registration.register();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
    }

    private void processIMC(final InterModProcessEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

    }
}
