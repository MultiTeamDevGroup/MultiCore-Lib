package multiteam.multicore_lib.setup.utilities.render.tooltip.itemtextcomp;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Matrix4f;
import multiteam.multicore_lib.setup.utilities.render.tooltip.itemcomp.ItemTooltipComponent;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.network.chat.TranslatableComponent;

import java.util.List;

public class ClientItemWithTextTooltipComponent implements ClientTooltipComponent {

    private final List<ItemWithTextTooltipComponent.ItemTextCompoundRow> displayCompoundRows;

    public ClientItemWithTextTooltipComponent(ItemWithTextTooltipComponent component) {
        //this.displayText = component.getDisplayText();
        this.displayCompoundRows = component.getDisplayCompoundRows();
    }

    @Override
    public int getHeight() {
        return displayCompoundRows.size() * 16;
    }

    @Override
    public int getWidth(Font font) {
        int ret = 0;
        for (int i = 0; i < this.displayCompoundRows.size(); i++){
            int a = font.width(displayCompoundRows.get(i).dispText);
            int b = this.displayCompoundRows.get(i).dispStackArray.size() * 18;
            if(a+b > ret){
                ret = a+b;
            }
        }
        return ret+18;
    }

    @Override
    public void renderImage(Font font, int posX, int posY, PoseStack poseStack, ItemRenderer renderer, int zIndex) {

        for (int i = 0; i < this.displayCompoundRows.size(); i++){
            for (int i2 = 0; i2 < this.displayCompoundRows.get(i).dispStackArray.size(); i2++){
                renderer.renderAndDecorateItem(this.displayCompoundRows.get(i).dispStackArray.get(i2), posX + (i2*18), posY + (i*16) - 2, 0);
            }
        }

    }

    @Override
    public void renderText(Font font, int posX, int posY, Matrix4f matrix4f, MultiBufferSource.BufferSource bufferSource) {

        for (int i = 0; i < this.displayCompoundRows.size(); i++){
            font.drawInBatch(this.displayCompoundRows.get(i).dispText, posX + (this.displayCompoundRows.get(i).dispStackArray.size()*18), posY + 3 + (i*16), 1, true, matrix4f, bufferSource, true, 1, 1);
        }

    }
}
