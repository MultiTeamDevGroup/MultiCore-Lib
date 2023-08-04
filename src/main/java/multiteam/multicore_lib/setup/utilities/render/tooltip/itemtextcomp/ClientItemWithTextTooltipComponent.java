package multiteam.multicore_lib.setup.utilities.render.tooltip.itemtextcomp;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.renderer.MultiBufferSource;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;

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
    public int getWidth(@NotNull Font font) {
        int ret = 0;
        for (ItemWithTextTooltipComponent.ItemTextCompoundRow displayCompoundRow : this.displayCompoundRows) {
            int a = font.width(displayCompoundRow.dispText);
            int b = displayCompoundRow.dispStackArray.size() * 18;
            if (a + b > ret) {
                ret = a + b;
            }
        }
        return ret+18;
    }

    @Override
    public void renderImage(@NotNull Font font, int posX, int posY, @NotNull GuiGraphics gfx /* Sponsored by Opera GX */) {

        for (int i = 0; i < this.displayCompoundRows.size(); i++){
            for (int i2 = 0; i2 < this.displayCompoundRows.get(i).dispStackArray.size(); i2++){
                gfx.renderItem(this.displayCompoundRows.get(i).dispStackArray.get(i2), posX + (i2*18), posY + (i*16) - 2, 1);
                gfx.renderItemDecorations(font, this.displayCompoundRows.get(i).dispStackArray.get(i2),posX + (i2*18), posY + (i*16) - 2 );
            }
        }

    }

    @Override
    public void renderText(@NotNull Font font, int posX, int posY, @NotNull Matrix4f matrix4f, MultiBufferSource.@NotNull BufferSource bufferSource) {

        for (int i = 0; i < this.displayCompoundRows.size(); i++){
            font.drawInBatch(this.displayCompoundRows.get(i).dispText, posX + (this.displayCompoundRows.get(i).dispStackArray.size()*18), posY + 3 + (i*16), 1, true, matrix4f, bufferSource, Font.DisplayMode.NORMAL, 1, 1);

        }

    }
}
