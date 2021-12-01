package multiteam.multicore_lib.setup.example.data.client;

import multiteam.multicore_lib.setup.utilities.data.BlockTagGenerator;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagProvider extends BlockTagGenerator {

    public ModBlockTagProvider(DataGenerator gen, String modId, ExistingFileHelper existingFileHelper) {
        super(gen, modId, existingFileHelper);
    }

    @Override
    protected void addTags() {
        //mineWithPickaxe(ModBlocks.RUBY_BLOCK.get(), RequiredToolLevel.DIAMOND);
    }
}
