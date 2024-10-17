package GameStuff;

import Item.Item;

import java.util.List;

public class Player {

    private List<Creature> team;
    private String name;
    private List<Item> inventory;

    public Player(List<Creature> creatures, String username, List<Item> inventory) {
        this.team = creatures;
        this.name = username;
        this.inventory = inventory;
    }

    public List<Creature> getTeam() {
        return team;
    }
    public List<Item> getInventory() {
        return inventory;
    }


    @Override
    public String toString() {
        return name;
    }
}
