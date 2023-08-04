package multiteam.multicore_lib.setup.utilities.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class BlockTagGenerator extends BlockTagsProvider {

    @Override
    protected void addTags(@NotNull Provider p_256380_) {

    }

    @SuppressWarnings("unused")
    public enum RequiredToolLevel{
        NONE,
        STONE,
        IRON,
        DIAMOND
    }

    public BlockTagGenerator(PackOutput gen, CompletableFuture<Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, lookupProvider, modId, existingFileHelper);
    }

    public void setRequiredTool(Block block,RequiredToolLevel lvl){
        switch (lvl) {
            case STONE -> this.tag(BlockTags.NEEDS_STONE_TOOL).add(block);
            case IRON -> this.tag(BlockTags.NEEDS_IRON_TOOL).add(block);
            case DIAMOND -> this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(block);

            //Do nothing bruh
            default -> {}
        }
    }

    public void mineWithAxe(Block block, RequiredToolLevel lvl){
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(block);
        setRequiredTool(block, lvl);
    }

    public void mineWithHoe(Block block, RequiredToolLevel lvl){
        this.tag(BlockTags.MINEABLE_WITH_HOE).add(block);
        setRequiredTool(block, lvl);
    }

    public void mineWithPickaxe(Block block, RequiredToolLevel lvl){
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        setRequiredTool(block, lvl);
    }

    public void mineWithShovel(Block block, RequiredToolLevel lvl){
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL).add(block);
        setRequiredTool(block, lvl);
    }
}
