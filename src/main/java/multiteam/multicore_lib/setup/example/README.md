# MultiCoreLib Wiki
Official documentation for MultiCoreLib, with a live example that's bundled with the library itself.




## Examples for Utility classes


### [ItemGroupTool](https://github.com/MultiTeamDevGroup/MultiCore-Lib/blob/1.18/src/main/java/multiteam/multicore_lib/setup/example/main/item/ExampleModItems.java#L14)

This is how you create a simple creative tab with a name and an item as icon.

Declare a static final variable basically anywhere in your code (We suggest the Item Registry class or the main class of your mod), and you can use it when creative tabs needs referencing. Please keep in mind that the label is a translatable component, so localize it in your lang file!

```java
public static final ItemGroupTool TAB_REFERENCE_NAME = new ItemGroupTool(String label, Supplier<ItemStack> displayStack);
```


### [ItemTooltipComponent](https://github.com/MultiTeamDevGroup/MultiCore-Lib/blob/1.18/src/main/java/multiteam/multicore_lib/setup/example/main/item/HoverTextItemExampleItem.java#L34)
![Hover Text Item Example Image](https://raw.githubusercontent.com/MultiTeamDevGroup/MultiCore-Lib/1.18/example/HoverTextItemExample.png)

This example item shows how to add an item into the tooltip of an item.
Just simply override the getTooltipImage() function within your item class, and return a new ItemTooltipComponent. You can define the item for the tooltip component in many ways, we here just insert a new apple item

```java
@Override
public @NotNull Optional<TooltipComponent> getTooltipImage(ItemStack stack) {
    return Optional.of(new ItemTooltipComponent(new ItemStack(Items.APPLE)));
}
```
If you want to add an item tooltip component to an item that is already made (you don't have access to its class), just subscribe to the RenderTooltipEvent.GatherComponents event, and check if the item is the is what you want to modify, and if so just add a new ItemTooltipComponent, like so:
```java
@SubscribeEvent
public static void gatherTooltips(RenderTooltipEvent.GatherComponents event) {
    if (event.getItemStack().getItem() == Items.STICK) {
        event.getTooltipElements().add(Either.right(new ItemTooltipComponent(new ItemStack(Items.APPLE))));
    }
}
```

### [TeleportTool](https://github.com/MultiTeamDevGroup/MultiCore-Lib/blob/1.18/src/main/java/multiteam/multicore_lib/setup/example/main/item/HoverTextItemExampleItem.java#L34)




## Examples for DataGen classes