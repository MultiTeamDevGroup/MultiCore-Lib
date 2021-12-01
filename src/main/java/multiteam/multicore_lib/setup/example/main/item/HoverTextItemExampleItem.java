package multiteam.multicore_lib.setup.example.main.item;

import multiteam.multicore_lib.MultiCoreLib;
import multiteam.multicore_lib.setup.utilities.render.HoverTextItemTool;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HoverTextItemExampleItem extends Item {

    public HoverTextItemExampleItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);

        tooltip.add(new TranslatableComponent("tooltip." + MultiCoreLib.MOD_ID + ".hover_text_item_example_description").withStyle(Style.EMPTY.withColor(6497792)));


        CompoundTag tag = stack.getTag();


        HoverTextItemTool.baseSetup(tag, stack);
        HoverTextItemTool.putItem(tooltip, tag, Items.APPLE);
    }
}
