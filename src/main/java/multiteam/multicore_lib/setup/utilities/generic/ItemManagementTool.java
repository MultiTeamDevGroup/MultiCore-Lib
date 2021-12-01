package multiteam.multicore_lib.setup.utilities.generic;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ItemManagementTool {

    //Returns the count of a specific item in an inventory/container.
    //Note that if there's multiple stacks of items, it will count them all, so the return might result in bigger amounts than 64.
    public int getCountOfItemInInventory(Inventory inv, Item itemToCount){
        int count = 0;
        for (int i = 0; i < inv.getContainerSize(); i++){
            ItemStack currentStack = inv.getItem(i);
            if(currentStack.getItem() == itemToCount){
                count+=currentStack.getCount();
            }
        }
        return count;
    }

    //does the exact same thing except it static because idk java lol
    public static int getCountOfItemInInventory_(Inventory inv, Item itemToCount){
        int count = 0;
        for (int i = 0; i < inv.getContainerSize(); i++){
            ItemStack currentStack = inv.getItem(i);
            if(currentStack.getItem() == itemToCount){
                count+=currentStack.getCount();
            }
        }
        return count;
    }
}
