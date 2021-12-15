package multiteam.multicore_lib.setup.utilities.render.tooltip.itemcomp;

import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class ItemTooltipComponent implements TooltipComponent {

    public enum ArrayRenderOption{
        ROW,
        COLUMN
    }

    private final List<ItemStack> displayStack;
    private final ArrayRenderOption renderOption;

    public ItemTooltipComponent(List<ItemStack> stack, ArrayRenderOption renderOption){
        this.displayStack = stack;
        this.renderOption = renderOption;
    }

    public List<ItemStack> getDisplayStack(){
        return this.displayStack;
    }
    public ArrayRenderOption getRenderOption(){
        return this.renderOption;
    }
}
