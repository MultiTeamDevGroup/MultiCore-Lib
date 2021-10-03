package multiteam.multicore_lib.setup.utilities;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class RegistrationTool {

    //Registers a block without an item form
    public static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block, DeferredRegister<Block> BLOCKS_){
        return BLOCKS_.register(name, block);
    }

    //Registers a block, and also registers an item version of the block
    public static <T extends Block> RegistryObject<T> registerWithItem(String name, Supplier<T> block, Item.Properties itemProperties, DeferredRegister<Block> BLOCKS_, DeferredRegister<Item> ITEMS_){
        RegistryObject<T> ret = registerNoItem(name, block, BLOCKS_);
        ITEMS_.register(name, () -> new BlockItem(ret.get(), itemProperties));
        return ret;
    }

    //Entity registry util
    public static <T extends Entity> RegistryObject<EntityType<T>> buildEntity(EntityType.EntityFactory<T> entity, Class<T> entityClass, float width, float height, MobCategory classification, int trackingRange, int updateinterval, DeferredRegister<EntityType<?>> ENTITIES_) {
        String name = entityClass.getSimpleName().toLowerCase();
        return ENTITIES_.register(name, () -> EntityType.Builder.of(entity, classification).sized(width, height).clientTrackingRange(trackingRange).updateInterval(updateinterval).build(name));
    }

    //Better version of the Entity registry util. uses a string as id instead of the name of the provided entity class
    public static <T extends Entity> RegistryObject<EntityType<T>> buildEntityV2(String name, EntityType.EntityFactory<T> entity, float width, float height, MobCategory classification, int trackingRange, int updateinterval, DeferredRegister<EntityType<?>> ENTITIES_) {
        return ENTITIES_.register(name, () -> EntityType.Builder.of(entity, classification).sized(width, height).clientTrackingRange(trackingRange).updateInterval(updateinterval).build(name));
    }
}