package Item;


import GameStuff.Ability;
import GameStuff.Arena;
import GameStuff.Creature;
import Menu.GameForm;
import Util.AbilityUtil;

import java.util.List;

public class Item extends Ability implements Cloneable{
    private int id = -1;
    private String consumptionMessage;
    private int minHealing;
    private int maxHealing;
    private String description;

    public Item(String name, String consumptionmessage, int minHealing, int maxHealing, String description) {
        super(name, 0);
        this.consumptionMessage = consumptionmessage;
        this.maxHealing = maxHealing;
        this.minHealing = minHealing;
        this.description = description;
    }

    @Override
    public void perform(Arena world, Creature user, List<Creature> targets) throws InterruptedException{
        consume(user, world);
    }

    public void consume(Creature consumer, Arena arena) throws InterruptedException {
        arena.writeOutput(consumer.toString() + " " + consumptionMessage + " " + name);
        Thread.sleep(500);
        int healing = AbilityUtil.getRandom(minHealing, maxHealing);
        consumer.heal(healing);
        arena.writeOutput(consumer + " healed " + healing + " Hp");
        if (consumer.hasMaxHealth()) {
            Thread.sleep(300);
            arena.writeOutput(consumer + " fully restored");
        }
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

    @Override
    public String getDescription() {
        StringBuffer sb = new StringBuffer(super.getDescription());
        sb.append("\nDescription: " + description);
        return sb.toString();
    }
}
