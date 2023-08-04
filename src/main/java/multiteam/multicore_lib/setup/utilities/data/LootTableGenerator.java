package multiteam.multicore_lib.setup.utilities.data;

import com.google.common.collect.ImmutableList;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

// Nuked by Qboi
public class LootTableGenerator extends LootTableProvider {

    public final DeferredRegister<Block> blockRegistry;

    public LootTableGenerator(PackOutput p_254123_, Set<ResourceLocation> p_254481_, List<SubProviderEntry> p_253798_, DeferredRegister<Block> blockRegistry) {
        super(p_254123_, p_254481_, p_253798_);
        this.blockRegistry = blockRegistry;
    }

    @Override
    public @NotNull List<SubProviderEntry> getTables() {
        return ImmutableList.of();
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, @NotNull ValidationContext ctx) {
        map.forEach((resourceLocation, lootTable) -> lootTable.validate(ctx));
    }

    public static class ModBlockLoot extends BlockLootSubProvider {
        private final DeferredRegister<Block> blockRegistry;

        public ModBlockLoot(Set<Item> explosionResistant, FeatureFlagSet flags, DeferredRegister<Block> blockRegistry) {
            super(explosionResistant, flags);
            this.blockRegistry = blockRegistry;
        }

        @Override
        protected void generate() {

        }

        /**
         *  DO NOT USE YET! ORES DONT DROP CORRECTLY!
         */
        @ApiStatus.Experimental
        public void oreDrops(Block coal, Block diamond, Block emerald, Block gold, Block iron, Block lapis, Block redstone){
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

        public void selfDrop(Block block, Block slab, Block stair){
            dropSelf(block);
            dropSelf(slab);
            dropSelf(stair);
        }

        public void dropCobble(Block blockBase, Block blockCobbled, Block slab, Block stair){
            add(blockBase, createSilkTouchDispatchTable(blockBase, this.createSingleItemTable(blockCobbled)dropOther(blockBase, blockCobbled.asItem())));
            dropSelf(blockCobbled);
            dropSelf(slab);
            dropSelf(stair);
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return this.blockRegistry.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList());
        }
    }
}