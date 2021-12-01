package multiteam.multicore_lib.setup;

import com.mojang.blaze3d.vertex.PoseStack;
import multiteam.multicore_lib.MultiCoreLib;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MultiCoreLib.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EventHandler {

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void renderTooltip(RenderTooltipEvent.PostText event) {
        ItemStack stack = event.getStack();

        PoseStack matrixStack = event.getMatrixStack();
        matrixStack.pushPose();
        matrixStack.translate(event.getX(), event.getY() + 12, 500);
        matrixStack.scale(0.5f, 0.5f, 1.0f);
        Minecraft mc = Minecraft.getInstance();

        CompoundTag nbtTagCompound = stack.getTag();

        if(nbtTagCompound != null){

            if(nbtTagCompound.getBoolean("hasTooltipItem")){
                for (int i = 0; i < nbtTagCompound.getIntArray("itemsToRender").length; i++){
                    ItemStack displayStack = new ItemStack(Item.byId(nbtTagCompound.getIntArray("itemsToRender")[i]));
                    mc.getItemRenderer().renderGuiItem(displayStack, i * 17, nbtTagCompound.getInt("lineToRender") + 20);
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
                    mc.getItemRenderer().renderGuiItem(displayStack, i * 17, nbtTagCompound.getInt("lineToRender") + 20);
                }
            }

        }

        matrixStack.popPose();
    }
}
