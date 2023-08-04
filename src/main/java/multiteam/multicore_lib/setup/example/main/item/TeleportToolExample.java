package multiteam.multicore_lib.setup.example.main.item;

import multiteam.multicore_lib.MultiCoreLib;
import multiteam.multicore_lib.setup.utilities.generic.TeleportUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TeleportToolExample extends Item {

    public TeleportToolExample(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("tooltip." + MultiCoreLib.MOD_ID + ".teleport_tool_example_description").withStyle(Style.EMPTY.withColor(15403382)));
    }


    @Override
    public InteractionResult useOn(UseOnContext context) {
        if(!context.getLevel().isClientSide){
            TeleportUtils.teleportPlayerTo((ServerPlayer) context.getPlayer(), (ServerLevel) context.getLevel(), context.getClickedPos());
        }
        return InteractionResult.SUCCESS;
    }
}
