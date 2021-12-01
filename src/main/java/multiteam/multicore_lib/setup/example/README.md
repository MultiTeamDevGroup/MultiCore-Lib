# MultiCoreLib Wiki
Official documentation for MultiCoreLib, with a live example thats bundled with the library itself.


## Examples for Utility classes

### [ItemGroupTool](https://github.com/MultiTeamDevGroup/MultiCore-Lib/blob/1.18/src/main/java/multiteam/multicore_lib/setup/example/main/item/ExampleModItems.java#L14)

This is how you create a simple creative tab with a name and an item as icon.

Declare a static final variable basically anywhere in your code (We suggest the Item Registry class or the main class of your mod), and you can use it when creative tabs needs referencing.

```java
public static final ItemGroupTool TAB_REFERENCE_NAME = new ItemGroupTool(String label, Supplier<ItemStack> displayStack);
```

### [HoverTextItemTool]()

## Examples for DataGen classes