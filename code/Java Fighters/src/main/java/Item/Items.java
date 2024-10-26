package Item;

import java.util.Dictionary;
import java.util.HashMap;

public class Items {

    private static HashMap<Integer, Item> GAME_ITEMS = new HashMap<Integer, Item>();



    public static Item APPLE = registerItem(new Item("Apple", "ate the", 4, 6, "<insert item description>"));
    public static Item HEALING_POTION = registerItem(new Item("Healing Potion", "drank the", 10, 20, "<insert item description>"));
    public static Item TUNA_SALAD = registerItem(new Item("Tuna Salad", "devoured the", 15, 15, "<insert item description>"));
    public static Item GOLDEN_APPLE = registerItem(new Item("Golden Apple", "ate the", 1, 40, "<insert item description>"));
    public static Item PILK = registerItem(new Item("Pilk", "drank the", -20, 50, "<insert item description>"));
    public static Item registerItem(Item item) {
        item.setId(GAME_ITEMS.size());
        GAME_ITEMS.put(item.getId(), item);
        return item;
    }

    public static void init() {

    }

    public static int getItemCount() {
        return GAME_ITEMS.size();
    }

    public static Item getItem(int i) {
        Item item = GAME_ITEMS.get(i);
        return  ((item == null) ? null : item.clone());
    }

}
