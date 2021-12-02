package multiteam.multicore_lib.setup.example.main.item;

import multiteam.multicore_lib.MultiCoreLib;
import multiteam.multicore_lib.setup.example.Registration;
import multiteam.multicore_lib.setup.utilities.generic.ItemGroupTool;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.RegistryObject;

public class ExampleModItems {

    //EXAMPLE: Usage of the ItemGroupTool utility class
    public static final ItemGroupTool MCL_EXAMPLES_TAB = new ItemGroupTool(MultiCoreLib.MOD_ID + "_examples_tab", () -> new ItemStack(Items.BOOK));


    public static final RegistryObject<Item> HOVERTEXTITEM_EXAMPLE = Registration.ITEMS.register("hover_text_item_example", () -> new HoverTextItemExampleItem(new Item.Properties().tab(MCL_EXAMPLES_TAB)));
    public static final RegistryObject<Item> TELEPORTTOOL_EXAMPLE = Registration.ITEMS.register("teleport_tool_example", () -> new TeleportToolExample(new Item.Properties().tab(MCL_EXAMPLES_TAB)));



    public static void register(){}
}
