package multiteam.multicore_lib.setup.utilities.render.tooltip;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ClientItemTooltipComponent implements ClientTooltipComponent {

    private ItemStack displayStack;

    public ClientItemTooltipComponent(ItemTooltipComponent component){
        displayStack = component.getDisplayStack();
    }

    @Override
    public int getHeight() {
        return 16;
    }

    @Override
    public int getWidth(Font p_169952_) {
        return getHeight();
    }

    @Override
    public void renderImage(Font font, int posX, int posY, PoseStack poseStack, ItemRenderer renderer, int zIndex) {

        renderer.renderAndDecorateItem(this.displayStack, posX, posY-2, 0);

    }

}
