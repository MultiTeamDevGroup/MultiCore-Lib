package multiteam.multicore_lib.setup.example.data.client;

import multiteam.multicore_lib.setup.utilities.data.BlockTagGenerator;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagGenerator {
    public ModBlockTagProvider(PackOutput gen, CompletableFuture<Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, lookupProvider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(@NotNull Provider p_256380_) {
        //mineWithPickaxe(ModBlocks.RUBY_BLOCK.get(), RequiredToolLevel.DIAMOND);
    }
}
