package multiteam.multicore_lib.setup.utilities.generic;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.common.util.ITeleporter;

import java.util.function.Function;

public class TeleportTool {

    public static void teleportPlayerTo(ServerPlayer targetPlayer, ServerLevel destinationLevel, BlockPos destinationBlockPos) {
        targetPlayer.changeDimension(destinationLevel, new ITeleporter() {
            @Override
            public Entity placeEntity(Entity targetPlayer, ServerLevel currentWorld, ServerLevel destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
                targetPlayer = repositionEntity.apply(false);
                targetPlayer.teleportTo(destinationBlockPos.getX(), destinationBlockPos.getY(), destinationBlockPos.getZ());
                return targetPlayer;
            }
        });
    }

}
