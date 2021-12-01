package multiteam.multicore_lib.setup.utilities.data;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.*;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LootTableGenerator extends LootTableProvider {

    public static DeferredRegister<Block> BLOCK_REGISTRY;

    public LootTableGenerator(DataGenerator dataGenerator, DeferredRegister<Block> blockRegistry) {
        super(dataGenerator);
        BLOCK_REGISTRY = blockRegistry;
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        return ImmutableList.of(
                Pair.of(ModBlockLootTables::new, LootContextParamSets.BLOCK)
        );
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationtracker) {
        map.forEach((resourceLocation, lootTable) -> LootTables.validate(validationtracker, resourceLocation, lootTable));
    }

    public static class ModBlockLootTables extends BlockLoot {
        @Override
        protected void addTables() {

        }

        /**
        *  DO NOT USE YET! ORES DONT DROP CORRECTLY!
        **/
        public void oreSetDrops(Block coal, Block diamond, Block emerald, Block gold, Block iron, Block lapis, Block redstone){
            dropOther(coal, Items.COAL);
            dropWhenSilkTouch(coal);
            dropOther(diamond, Items.DIAMOND);
            dropWhenSilkTouch(diamond);
            dropOther(emerald, Items.EMERALD);
            dropWhenSilkTouch(emerald);
            dropSelf(gold);
            dropSelf(iron);
            dropOther(lapis, Items.LAPIS_LAZULI);
            dropWhenSilkTouch(lapis);
            dropOther(redstone, Items.REDSTONE);
            dropWhenSilkTouch(redstone);
        }

        public void blockSetDropSelf(Block block, Block slab, Block stair){
            dropSelf(block);
            dropSelf(slab);
            dropSelf(stair);
        }

        public void blockSetWithCobbledBase(Block blockBase, Block blockCobbled, Block slab, Block stair){
            //LootEntry.Builder builder = LootEntry.Builder();
            //createSilkTouchDispatchTable(blockBase, builder);
            dropOther(blockBase, blockCobbled.asItem());
            dropSelf(blockCobbled);
            dropSelf(slab);
            dropSelf(stair);
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return  BLOCK_REGISTRY.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList());
        }
    }
}