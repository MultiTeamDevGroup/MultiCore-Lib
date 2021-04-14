package multiteam.multicore_lib.setup.utilities;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import java.util.function.Supplier;

public class ItemGroupTool extends ItemGroup {

    public Supplier<ItemStack> displayStack;

    public ItemGroupTool(String label, Supplier<ItemStack> displayStack) {
        super(label);
        this.displayStack = displayStack;
    }

    @Override
    public ItemStack makeIcon() {
        return displayStack.get();
    }
}
