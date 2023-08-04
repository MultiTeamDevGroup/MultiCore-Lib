package multiteam.multicore_lib.setup.example.data.client;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import multiteam.multicore_lib.setup.utilities.data.LootTableGenerator;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class ModLootTableProvider extends LootTableGenerator {

    public ModLootTableProvider(DataGenerator dataGenerator, DeferredRegister<Block> blockRegistry) {
        super(dataGenerator, blockRegistry);
    }

    @Override
    public @NotNull List<SubProviderEntry> getTables() {
        return ImmutableList.of(
                Pair.of(ModBlockLootTables::new, LootContextParamSets.BLOCK)
        );
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, @NotNull ValidationContext ctx) {
        map.forEach((resourceLocation, lootTable) -> lootTable.validate(ctx));
    }

    public static class ModBlockLootTables extends ModBlockLoot {
        public ModBlockLootTables() {
            super(new HashSet<>(), FeatureFlagSet.of());
        }

        @Override
        protected void addTables() {
            //dropSelf(ModBlocks.WITHERED_BONE_BLOCK.get());
        }

    }
}
