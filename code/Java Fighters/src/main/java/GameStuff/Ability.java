package GameStuff;

import java.util.ArrayList;
import java.util.List;

public abstract class Ability {
    protected String name;
    private int cooldown;
    private int cooldownProgress;
    private int targets;

    public Ability(String name, int cooldown, int cooldownProgress, int targets) {
        this(name, targets);
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
        cooldownProgress = cooldown;
    }

    public boolean canPerform(Arena world, Creature creature, List<Creature> targets) {
        return cooldownProgress <=0;
    }
    public void Update(Arena arena, Creature user) {
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
        return name + ((cooldownProgress>0) ? cooldownProgress + " turns CD" : "READY");
    }

    public int getTargets() {
        return targets;
    }
}
