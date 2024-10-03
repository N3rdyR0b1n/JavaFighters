package Item;

import java.util.Dictionary;
import java.util.HashMap;

public class Items {

    private static HashMap<Integer, Item> GAME_ITEMS = new HashMap<Integer, Item>();



    public static Item APPLE = registerItem(new Item("Apple"));
    public static Item HEALING_POTION = registerItem(new Item("Healing Potion"));
    public static Item TUNA_SALAD = registerItem(new Item("Tuna Salad"));
    public static Item GOLDEN_APPLE = registerItem(new Item("Golden Apple"));

    public static Item registerItem(Item item) {
        item.setId(GAME_ITEMS.size());
        GAME_ITEMS.put(item.getId(), item);
        return item;
    }

    public static void init() {
        APPLE = registerItem(new Item("Apple"));
        HEALING_POTION = registerItem(new Item("Healing Potion"));
        TUNA_SALAD = registerItem(new Item("Tuna Salad"));
        GOLDEN_APPLE = registerItem(new Item("Golden Apple"));
    }

    public static int getItemCount() {
        return GAME_ITEMS.size();
    }

    public static Item getItem(int i) {
        Item item = GAME_ITEMS.get(i);
        return  ((item == null) ? null : item.clone());
    }

}
