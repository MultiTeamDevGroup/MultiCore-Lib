package multiteam.multicore_lib.setup.utilities.render;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.BaseComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class HoverTextItemTool {

    public static void baseSetup(CompoundTag tag, ItemStack stack){
        if(tag == null){
            tag = new CompoundTag();
            stack.setTag(tag);
        }else if(!tag.getBoolean("hasTooltipItem")){
            tag.putBoolean("hasTooltipItem", true);
            stack.setTag(tag);
        }
    }

    public static void putItems(List<Component> tooltip, CompoundTag nbtTagCompound, Item[] itemsToRender){
        tooltip.add(new TextComponent(" "));
        nbtTagCompound.putBoolean("hasTooltipItem", true);
        int[] itemIdsToRender = new int[itemsToRender.length];
        for (int i = 0; i < itemIdsToRender.length; i++){
            itemIdsToRender[i] = Item.getId(itemsToRender[i]);
        }
        nbtTagCompound.putIntArray("itemsToRender", itemIdsToRender);
        nbtTagCompound.putInt("lineToRender", tooltip.size());
    }

    public static void putItem(List<Component> tooltip, CompoundTag nbtTagCompound, Item itemToRender){
        tooltip.add(new TextComponent(" "));
        nbtTagCompound.putBoolean("hasTooltipItem", true);
        int[] itemIdsToRender = {Item.getId(itemToRender)};
        nbtTagCompound.putIntArray("itemsToRender", itemIdsToRender);
        nbtTagCompound.putInt("lineToRender", tooltip.size());
    }

    public static void displayItemBar(List<BaseComponent> tooltip, CompoundTag nbtTagCompound, Item barItem, Item barItemEmpty, int barLenght, int barFillAmount){
        String spacer = " ";
        for (int i = 0; i < barLenght * 5; i++){
            spacer+=" "; // Fixme: should be optimized.
        }
        tooltip.add(new TextComponent(spacer));
        nbtTagCompound.putBoolean("hasItemBar", true);
        nbtTagCompound.putInt("barLength", barLenght);
        nbtTagCompound.putInt("barFillAmountDisplay", barFillAmount);
        nbtTagCompound.putInt("barItem", Item.getId(barItem));
        nbtTagCompound.putInt("barItemEmpty", Item.getId(barItemEmpty));
        nbtTagCompound.putInt("lineToRender", tooltip.size());
    }
}
