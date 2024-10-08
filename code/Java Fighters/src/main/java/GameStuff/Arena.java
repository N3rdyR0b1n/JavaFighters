package GameStuff;

import Item.Item;
import Item.Items;
import Util.TextUtil;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    Random random;
    Container textOutput;
    private int round = 1;
    private final Player player1;
    private final Player player2;
    public Arena(Player player1, Player player2){
        this.random = new Random();
        this.player1 = player1;
        this.player2 = player2;

    }

    public List<Creature> getCreatures() {
        List<Creature> creatures = new ArrayList<>();
        creatures.addAll(player1.getTeam());
        creatures.addAll(player2.getTeam());
        return creatures;
    }

    public void start() {

    }

    public void gameTick() {
        List<Creature> creatures = getCreatures();
        for (Creature creature : creatures) {
            creature.turnTick(this);
        }
    }



    public void writeOutput(String string) {
        Component component = new JLabel(string);
        TextUtil.fontify(component);
        textOutput.add(component);
    }
    public List<Item> getRelevantItems(boolean left) {
        return left ? player1.getInventory() : player2.getInventory();
    }

    public int getRound() {
        return round;
    }
    public void nextRound() {
        round++;
    }

}
