package GameStuff;

import Abilities.DefendAbility;
import Abilities.SpareAbility;
import Util.FileUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Creature {
    protected String name;
    protected String fileName;
    private int hp;
    private int maxhp;
    private Random random = new Random();
    protected List<Ability> actions;
    protected List<Ability> attacks;
    protected List<Ability> spares;
    protected List<Ability> defense;
    boolean hasTurn =false;
    private ArrayList<List<Ability>> allActions;
    protected int extraDamage;

    public Creature(String name, int hp, String fileName) {
        this.name = name;
        this.hp = hp;
        this.maxhp = hp;
        this.fileName = fileName;
        allActions = new ArrayList<List<Ability>>();
        actions = new ArrayList<>();

        attacks = new ArrayList<>();

        spares = new ArrayList<>();
        spares.add(new SpareAbility());

        defense = new ArrayList<>();
        defense.add(new DefendAbility());
        allActions.add(actions);
        allActions.add(attacks);
        allActions.add(spares);
        allActions.add(defense);
    }

    public void attack(Arena arena, int damage, int chance) {
        if (random.nextInt( 101) >= chance) {
            arena.writeOutput(this.name + " dodged the attack");
            return;
        }
        arena.writeOutput(this.name + " took " + damage + " damage");
        this.damage(damage);
        if (!this.alive()) {
            arena.writeOutput(this.name + " died");
        }


    }
    public void damage(int damage) {
        this.hp-=damage;
    }
    public boolean alive() {
        return hp>0;
    }
    public void rename(String nick) {
        this.name = nick;
    }
    public String status() {
        return name + " : " + hp + "/" + maxhp;
    }

    public String getImageSource() {
        return FileUtil.CHARACTERS+fileName;
    }

    public int damageMod(int initialDamage) {
        return initialDamage + extraDamage;
    }

    public void turnTick(Arena arena) {
        for (List<Ability> abilityList : allActions) {
            for (Ability ability : abilityList) {
                ability.Update(arena, this);
            }
        }
    }
    public void onTurn(Arena arena) {
        hasTurn = true;
    }
    public void endTurn(Arena arena) {
        hasTurn = false;
    }


}
