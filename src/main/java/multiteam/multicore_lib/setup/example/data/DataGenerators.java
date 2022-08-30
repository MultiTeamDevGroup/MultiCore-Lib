package multiteam.multicore_lib.setup.example.data;

import multiteam.multicore_lib.MultiCoreLib;
import multiteam.multicore_lib.setup.example.Registration;
import multiteam.multicore_lib.setup.example.data.client.ModBlockStateProvider;
import multiteam.multicore_lib.setup.example.data.client.ModBlockTagProvider;
import multiteam.multicore_lib.setup.example.data.client.ModItemModelProvider;
import multiteam.multicore_lib.setup.example.data.client.ModLootTableProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MultiCoreLib.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    private DataGenerators() {}

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        gen.addProvider(true, new ModBlockStateProvider(gen, MultiCoreLib.MOD_ID, existingFileHelper));
        gen.addProvider(true, new ModItemModelProvider(gen,MultiCoreLib.MOD_ID, existingFileHelper));
        gen.addProvider(true, new ModLootTableProvider(gen, Registration.BLOCKS));
        gen.addProvider(true, new ModBlockTagProvider(gen, MultiCoreLib.MOD_ID, existingFileHelper));
    }
}
