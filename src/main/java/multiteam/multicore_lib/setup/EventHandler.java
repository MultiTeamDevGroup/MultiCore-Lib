package multiteam.multicore_lib.setup;

import multiteam.multicore_lib.MultiCoreLib;
import multiteam.multicore_lib.setup.utilities.render.tooltip.itemcomp.ClientItemTooltipComponent;
import multiteam.multicore_lib.setup.utilities.render.tooltip.itemcomp.ItemTooltipComponent;
import multiteam.multicore_lib.setup.utilities.render.tooltip.itemtextcomp.ClientItemWithTextTooltipComponent;
import multiteam.multicore_lib.setup.utilities.render.tooltip.itemtextcomp.ItemWithTextTooltipComponent;
import net.minecraftforge.client.event.RegisterClientTooltipComponentFactoriesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = MultiCoreLib.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EventHandler {

    @SubscribeEvent
    public static void registerTooltipsEvent(RegisterClientTooltipComponentFactoriesEvent event){
        event.register(ItemTooltipComponent.class, ClientItemTooltipComponent::new);
        event.register(ItemWithTextTooltipComponent.class, ClientItemWithTextTooltipComponent::new);

    }

}
