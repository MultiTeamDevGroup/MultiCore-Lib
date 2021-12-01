package multiteam.multicore_lib.setup.utilities.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModelGenerator extends ItemModelProvider {

    public ItemModelGenerator(DataGenerator generator, String modId, ExistingFileHelper existingFileHelper) {
        super(generator, modId, existingFileHelper);
    }

    @Override
    protected void registerModels() {

    }

    /**
     * flatItem(itemGenerated, "item_id");
     * usage - generic 2D/Flat item
     * -itemGenerated is an argument present in the function arguments
     * -"item_id" string id of the item. namespace not required to be passed in
     *
     * blockItem("block_id");
     * usage - generic Block item
     * -"block_id" the string id of your block item. namespace not required to be passed in
     *
     * blockItemBaseSlabStair("base_block_id");
     * usage - a set of blocks for slab and stair from a base block
     * -"base_block_id" the string id of your base block. this one also gets generated alongside the slab and stair
     *
     * blockItemBaseSlabStair("base_block_id");
     * usage -
     * -"base_block_id" the string id of your base block. this one also gets generated alongside the slab and stair
     */

    private ItemModelBuilder flatItem(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/"+name);
    }

    public void blockItem(String block){
        withExistingParent(block, modLoc("block/"+block));
    }

    public void blockItemBaseSlabStair(String block){
        blockItem(block);
        blockItem(block+"_slab");
        blockItem(block+"_stairs");
    }

    public void wholeVanillaOreSet(String base){
        blockItem(base + "_coal_ore");
        blockItem(base + "_copper_ore");
        blockItem(base + "_diamond_ore");
        blockItem(base + "_emerald_ore");
        blockItem(base + "_gold_ore");
        blockItem(base + "_iron_ore");
        blockItem(base + "_lapis_ore");
        blockItem(base + "_redstone_ore");
    }

    public ModelFile getItemGenerated(){
       return getExistingFile(mcLoc("item/generated"));
    }
}
