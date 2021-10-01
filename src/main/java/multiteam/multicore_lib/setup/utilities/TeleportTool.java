package multiteam.multicore_lib.setup.utilities;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.common.util.ITeleporter;

import java.util.function.Function;

public class TeleportTool {

    public static void teleportTo(ServerPlayer entity, ServerLevel destination, BlockPos pos) {
        entity.changeDimension(destination, new ITeleporter() {
            @Override
            public Entity placeEntity(Entity entity, ServerLevel currentWorld, ServerLevel destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
                entity = repositionEntity.apply(false);
                entity.teleportTo(pos.getX(), pos.getY(), pos.getZ());
                return entity;
            }
        });
    }

}
