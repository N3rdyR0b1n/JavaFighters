import java.util.ArrayList;
import java.util.List;

public abstract class Ability {

    private String name;
    private int cooldown;
    private int cooldownProgress;

    public Ability(String name, int cooldown, int cooldownProgress) {
        this.name = name;
        this.cooldown = cooldown;
        this.cooldownProgress = cooldownProgress;
    }

    public void perform(Arena world, Creature user, List<Creature> targets) {
        cooldownProgress = cooldown;
    }
    public boolean canPerform(Arena world, Creature creature, List<Creature> targets) {
        return cooldownProgress <=0;
    }
    public void Update(Arena arena, Creature user, List<Creature> targets) {
        cooldownProgress--;
    }

    public List<String> getDescription() {
        ArrayList<String> description = new ArrayList<>();
        description.add("Name: " + name);
        description.add("Status:" + ((cooldownProgress>0) ? cooldownProgress + " turns CD" : "READY"));
        description.add("Cooldown: " + cooldown);
        return description;
    }






}
