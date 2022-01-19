package multiteam.multicore_lib.setup.example.main.item;

import multiteam.multicore_lib.MultiCoreLib;
import multiteam.multicore_lib.setup.utilities.render.tooltip.itemcomp.ItemTooltipComponent;
import multiteam.multicore_lib.setup.utilities.render.tooltip.itemtextcomp.ItemWithTextTooltipComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class HoverTextItemExample2Item extends Item {

    public HoverTextItemExample2Item(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(new TranslatableComponent("tooltip." + MultiCoreLib.MOD_ID + ".hover_text_item_example2_description").withStyle(Style.EMPTY.withColor(6497792)));
    }


    @Override
    public @NotNull Optional<TooltipComponent> getTooltipImage(ItemStack stack) {

        ItemStack appleStack = new ItemStack(Items.APPLE);
        appleStack.setCount(12);

        return Optional.of(new ItemWithTextTooltipComponent(List.of(
                new ItemWithTextTooltipComponent.ItemTextCompoundRow(List.of(
                        appleStack
                ), (TranslatableComponent) new TranslatableComponent("Row 1").withStyle(Style.EMPTY.withColor(0xffffff))),
                new ItemWithTextTooltipComponent.ItemTextCompoundRow(List.of(
                        new ItemStack(Items.APPLE),appleStack
                ), (TranslatableComponent) new TranslatableComponent("Row 2").withStyle(Style.EMPTY.withColor(0xffffff))),
                new ItemWithTextTooltipComponent.ItemTextCompoundRow(List.of(
                        new ItemStack(Items.APPLE),appleStack,appleStack,new ItemStack(Items.APPLE)
                ),(TranslatableComponent) new TranslatableComponent("Row 3").withStyle(Style.EMPTY.withColor(0xffffff)))
            )
        ));
    }
}
