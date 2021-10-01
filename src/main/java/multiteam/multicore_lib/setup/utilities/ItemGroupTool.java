package multiteam.multicore_lib.setup.utilities;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class ItemGroupTool extends CreativeModeTab {

    public Supplier<ItemStack> displayStack;

    public ItemGroupTool(String label, Supplier<ItemStack> displayStack) {
        super(label);
        this.displayStack = displayStack;
    }

    @NotNull
    @Override
    public ItemStack makeIcon() {
        return displayStack.get();
    }
}
