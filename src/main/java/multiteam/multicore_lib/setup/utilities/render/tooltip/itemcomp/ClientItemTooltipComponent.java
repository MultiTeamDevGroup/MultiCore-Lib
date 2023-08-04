package multiteam.multicore_lib.setup.utilities.render.tooltip.itemcomp;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@OnlyIn(Dist.CLIENT)
public class ClientItemTooltipComponent implements ClientTooltipComponent {

    private final List<ItemStack> displayStack;
    private final ItemTooltipComponent.ArrayRenderOption renderOption;


    public ClientItemTooltipComponent(ItemTooltipComponent component){
        this.displayStack = component.getDisplayStack();
        this.renderOption = component.getRenderOption();
    }

    @Override
    public int getHeight() {
        int ret = 0;
        switch (this.renderOption){
            case ROW -> ret = 16;
            case COLUMN -> ret = 18 * displayStack.size();
        }
        return ret;
    }

    @Override
    public int getWidth(@NotNull Font font) {
        int ret = 0;
        switch (this.renderOption){
            case COLUMN -> ret = 16;
            case ROW -> ret = 18 * displayStack.size();
        }
        return ret;
    }

    @Override
    public void renderImage(@NotNull Font font, int posX, int posY, @NotNull GuiGraphics gfx) {
        for (int i = 0; i < this.displayStack.size(); i++){
            switch (this.renderOption){
                case ROW -> {
                    gfx.renderItem(this.displayStack.get(i), posX + (i*18), posY-2, 0);
                    gfx.renderItemDecorations(font, this.displayStack.get(i), posX + (i*18), posY-2);
                }
                case COLUMN -> {
                    gfx.renderItem(this.displayStack.get(i), posX, posY + (i*16), 0);
                    gfx.renderItemDecorations(font, this.displayStack.get(i),posY + (i*16), 0);
                }
            }

        }

    }

}
