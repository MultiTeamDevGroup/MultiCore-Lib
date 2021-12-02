package multiteam.multicore_lib.setup;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.datafixers.util.Either;
import multiteam.multicore_lib.MultiCoreLib;
import multiteam.multicore_lib.setup.utilities.render.ClientItemTooltipComponent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientBundleTooltip;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.inventory.tooltip.BundleTooltip;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Arrays;
import java.util.List;

@Mod.EventBusSubscriber(modid = MultiCoreLib.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EventHandler {

    //@SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void renderTooltip(RenderTooltipEvent.GatherComponents event) {
        ItemStack stack = event.getItemStack();

        Minecraft mc = Minecraft.getInstance();

        CompoundTag nbtTagCompound = stack.getTag();

        if(nbtTagCompound != null){

            if(nbtTagCompound.getBoolean("hasTooltipItem")){
                for (int i = 0; i < nbtTagCompound.getIntArray("itemsToRender").length; i++){
                    ItemStack displayStack = new ItemStack(Item.byId(nbtTagCompound.getIntArray("itemsToRender")[i]));
                    //event.getTooltipElements().add(Either.right(new TooltipComponent()))
                    //event.getTooltipElements().add(new ClientItemTooltipComponent());
                    //mc.getItemRenderer().renderGuiItem(displayStack, i * 17, nbtTagCompound.getInt("lineToRender") + 20);
                }
            }

            if(nbtTagCompound.getBoolean("hasItemBar")){
                int barLength = nbtTagCompound.getInt("barLength");
                int barFillAmount = nbtTagCompound.getInt("barFillAmountDisplay");
                Item[] itemsToRender = new Item[barLength];

                for (int i = 0; i < barLength; i++) {
                    if(barFillAmount == 0){
                        itemsToRender[i] = Item.byId(nbtTagCompound.getInt("barItemEmpty"));
                    }else if(i < barFillAmount){
                        itemsToRender[i] = Item.byId(nbtTagCompound.getInt("barItem"));
                    }else{
                        itemsToRender[i] = Item.byId(nbtTagCompound.getInt("barItemEmpty"));
                    }
                }

                for (int i = 0; i < itemsToRender.length; i++){
                    ItemStack displayStack = new ItemStack(itemsToRender[i]);
                    //mc.getItemRenderer().renderGuiItem(displayStack, i * 17, nbtTagCompound.getInt("lineToRender") + 20);
                }
            }

        }

    }
}
