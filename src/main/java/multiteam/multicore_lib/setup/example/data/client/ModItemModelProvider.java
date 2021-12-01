package multiteam.multicore_lib.setup.example.data.client;

import multiteam.multicore_lib.setup.utilities.data.ItemModelGenerator;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelGenerator {

    public ModItemModelProvider(DataGenerator generator, String modId, ExistingFileHelper existingFileHelper) {
        super(generator, modId, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //Blockitems
        blockItem("example_block");

        //Regular Items
        flatItem("example_item");
    }
}
