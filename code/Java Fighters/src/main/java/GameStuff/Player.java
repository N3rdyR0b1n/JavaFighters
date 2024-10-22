package GameStuff;


import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Player {

    private List<Creature> team;
    private String name;
    private List<Ability> inventory;

    public Player(List<Creature> creatures, String username, List<Ability> inventory) {
        this.team = creatures;
        this.name = username;
        this.inventory = inventory;
    }

    public List<Creature> getTeam() {
        return team;
    }
    public List<Ability> getInventory() {
        return inventory;
    }


    @Override
    public String toString() {
        return name;
    }
}
