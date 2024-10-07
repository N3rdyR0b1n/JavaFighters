package Item;


import GameStuff.Ability;
import GameStuff.Arena;
import GameStuff.Creature;
import Menu.GameForm;

public class Item extends Ability implements Cloneable{
    private int id = -1;
    private String consumptionMessage;
    private int minHealing;
    private int maxHealing;

    public Item(String name, String consumptionmessage, int minHealing, int maxHealing) {
        super(name, 0);
        this.consumptionMessage = consumptionmessage;
        this.maxHealing = maxHealing;
        this.minHealing = minHealing;
    }

    public void consume(Creature consumer, Arena arena) {
        arena.writeOutput(consumer.toString() + " " + consumptionMessage + " " + name);
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
