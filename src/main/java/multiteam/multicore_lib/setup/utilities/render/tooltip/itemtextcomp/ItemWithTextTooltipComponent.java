package multiteam.multicore_lib.setup.utilities.render.tooltip.itemtextcomp;

import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class ItemWithTextTooltipComponent implements TooltipComponent {

    private final List<ItemTextCompoundRow> displayCompoundRows;

    public static class ItemTextCompoundRow{
        public List<ItemStack> dispStackArray;
        public Component dispText;

        public ItemTextCompoundRow(List<ItemStack> displayStack, Component displayText){
            this.dispStackArray = displayStack;
            this.dispText = displayText;
        }
    }


    public ItemWithTextTooltipComponent(List<ItemTextCompoundRow> compoundRows) {
        this.displayCompoundRows = compoundRows;
    }

    public List<ItemTextCompoundRow> getDisplayCompoundRows(){
        return this.displayCompoundRows;
    }

}
