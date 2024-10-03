package Item;


import GameStuff.Arena;
import GameStuff.Creature;

public class Item implements Cloneable{
    public String name;
    private int id = -1;

    public Item(String name) {
        this.name = name;
    }

    public void consume(Creature consumer, Arena arena) {

    }

    public Item clone() {
        try {
            return (Item) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return name;
    }



    public int getId() {
        return id;
    }
    public void setId(int updatedId) {
        if (id == -1) {
            id = updatedId;
        }
    }

}
