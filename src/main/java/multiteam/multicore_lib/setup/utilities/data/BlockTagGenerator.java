package multiteam.multicore_lib.setup.utilities.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class BlockTagGenerator extends BlockTagsProvider {

    public enum RequiredToolLevel{
        NONE,
        STONE,
        IRON,
        DIAMOND
    }

    public BlockTagGenerator(DataGenerator gen, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, modId, existingFileHelper);
    }

    @Override
    protected void addTags() {

    }

    public void setRequiredTool(Block block,RequiredToolLevel lvl){
        switch (lvl){
            case NONE:
                //Do nothing bruh
                break;
            case STONE:
                this.tag(BlockTags.NEEDS_STONE_TOOL).add(block);
                break;
            case IRON:
                this.tag(BlockTags.NEEDS_IRON_TOOL).add(block);
                break;
            case DIAMOND:
                this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(block);
                break;
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
