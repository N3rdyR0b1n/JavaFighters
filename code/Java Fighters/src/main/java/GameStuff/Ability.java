package GameStuff;

import java.util.ArrayList;
import java.util.List;

public abstract class Ability {
    protected String name;
    protected int cooldown;
    protected int cooldownProgress;
    private int targets;

    public Ability(String name, int cooldown, int cooldownProgress, int targets) {
        this(name, targets);
        // Preventing negative cooldown durations
        // Artificially raising cooldown by 1 due to the fact that
        // the turn at which the ability itself gets used counts for
        // the turn in which cooldowns will get reduced.
        if (cooldown < 0) {
            cooldown = 0;
        }
        this.cooldown = cooldown;
        this.cooldownProgress = cooldownProgress;
    }

    public Ability(String name, int targets) {
        this.name = name;
        this.targets = targets;
        this.cooldown = 0;
        this.cooldownProgress=0;
    }

    public void perform(Arena world, Creature user, List<Creature> targets) throws InterruptedException {
        world.writeOutput(user + " used " + name);
        cooldownProgress = cooldown + 1;
    }

    public boolean canPerform(Arena world, Creature creature) {
        return cooldownProgress <=0;
    }
    public void Update(Arena arena, Creature user) throws InterruptedException {
        cooldownProgress--;
    }

    public List<String> getDescription() {
        ArrayList<String> description = new ArrayList<>();
        description.add("Name: " + name);
        description.add("Status:" + ((cooldownProgress>0) ? cooldownProgress + " turns CD" : "READY"));
        description.add("Cooldown: " + cooldown);
        return description;
    }

    @Override
    public String toString() {
        return name + ((cooldownProgress>0) ? cooldownProgress + " turns CD left " : " READY ") + cooldown + " CD ";
    }

    public int getTargets() {
        return targets;
    }

    public ArrayList getInfo() {
        ArrayList<String> info = new ArrayList<>();
        info.add(name);
        info.add("Cooldown: " + cooldownProgress);
        info.add("Max Cooldown: " + cooldown);
        return info;
    }
}
