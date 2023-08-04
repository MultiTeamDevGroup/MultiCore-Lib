package multiteam.multicore_lib.setup.utilities.data;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockStateAndModelGenerator extends BlockStateProvider {
    private final String modId;

    public BlockStateAndModelGenerator(PackOutput gen, String modId, ExistingFileHelper exFileHelper) {
        super(gen, modId, exFileHelper);
        this.modId = modId;
    }

    /**
     * blockBaseSlabStairSet() - makes a set of block:Base-Slab-Stair
     * example from a mod called Cavernous:
     * blockBaseSlabStairSet("siltstone", CavernousBlocks.SILTSTONE.get(), CavernousBlocks.SILTSTONE_SLAB.get(), CavernousBlocks.SILTSTONE_STAIRS.get());
     *
     * blockBaseSlabStairWallSet - makes a set of block:Base-Slab-Stair-Wall
     * example from a mod called Cavernous:
     * blockBaseSlabStairWallSet("siltstone", CavernousBlocks.SILTSTONE.get(), CavernousBlocks.SILTSTONE_SLAB.get(), CavernousBlocks.SILTSTONE_STAIRS.get(), CavernousBlocks.SILTSTONE_WALL.get());
     *
     *  for the functions to accept your blocks, they must extend the correct classes:
     *  -base:Block
     *  -slab:SlabBlock
     *  -stair:StairBlock
     *  -wall:WallBlock
     */

    @Override
    protected void registerStatesAndModels() {
        /* put your generator functions here */
    }

    public ResourceLocation texure(String textureName){
        return new ResourceLocation(modId +":block/"+textureName);
    }

    public void blockBaseSlabStairSet(String name, Block block, Block slab, Block stair){
        ResourceLocation texture = texure(name);
        simpleBlock(block);
        slabBlock((SlabBlock)slab, texture, texture);
        stairsBlock((StairBlock)stair, texture);
    }

    public void blockBaseSlabStairWallSet(String name, Block block, Block slab, Block stair, Block wall){
        blockBaseSlabStairSet(name, block, slab, stair);
        ResourceLocation texture = texure(name);
        wallBlock((WallBlock) wall, texture);
    }
}