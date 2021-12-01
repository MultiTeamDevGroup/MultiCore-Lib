package multiteam.multicore_lib.setup.utilities.specialcase;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.material.Fluid;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class FishBucketItem extends BucketItem {

    private final Supplier<EntityType<? extends WaterAnimal>> entityType;

    public FishBucketItem(Supplier<EntityType<? extends WaterAnimal>> entityType, Supplier<? extends Fluid> supplier, Item.Properties builder) {
        super(supplier, builder);
        this.entityType = entityType;
    }

    public void checkExtraContent(Level level, ItemStack stack, BlockPos pos) {
        if (!level.isClientSide) {
            this.placeEntity((ServerLevel) level, stack, pos);
        }
    }

    protected void playEmptySound(@Nullable Player player, LevelAccessor levelAccessor, BlockPos pos) {
        levelAccessor.playSound(player, pos, SoundEvents.BUCKET_EMPTY_FISH, SoundSource.NEUTRAL, 1.0F, 1.0F);
    }

    protected void placeEntity(ServerLevel level, ItemStack stack, BlockPos pos) {
        Entity entity = this.entityType.get().spawn(level, stack, null, pos, MobSpawnType.BUCKET, true, false);
    }

}