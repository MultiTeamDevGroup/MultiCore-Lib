package multiteam.multicore_lib.setup.utilities.render;

import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.ItemStack;

public class ItemTooltipComponent implements TooltipComponent {
    private final ItemStack displayStack;

    public ItemTooltipComponent(ItemStack stack){
        this.displayStack = stack;
    }

    public ItemStack getDisplayStack(){
        return this.displayStack;
    }
}
