package GameStuff;

import Abilities.DefendAbility;
import Abilities.SpareAbility;
import Util.FileUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Creature {
    protected static String DEAD = "dead.png";
    protected String name;
    protected String fileName;
    private int hp;
    private int maxhp;
    private Random random = new Random();
    protected List<Ability> actions;
    protected List<Ability> attacks;
    protected List<Ability> spares;
    protected List<Ability> defense;
    protected boolean hasTurn =false;
    private ArrayList<List<Ability>> allActions;
    protected int extraDamage;
    protected int age;
    private Player owner;
    protected int armor;

    protected Ability selectedAbility;
    protected boolean targetsSelected;
    protected List<Creature> selectedTargets;

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

        selectedAbility = null;
        targetsSelected = false;
        selectedTargets = new ArrayList<>();
    }

    public boolean attack(Arena arena, int damage, int chance) throws InterruptedException{
        Thread.sleep(500);
        if (random.nextInt( 101) >= chance) {
            arena.writeOutput(this.name + " dodged the attack");
            return false;
        }
        damage-=getArmor();
        arena.writeOutput(this.name + " took " + damage + " damage");
        this.damage(damage);
        if (!this.alive()) {
            arena.writeOutput(this.name + " died");
        }
        return true;
    }

    public void damage(int damage) {
        if (damage < 0) {
            damage = 0;
        }
        this.hp-=damage;
    }

    public boolean alive() {
        return hp>0;
    }

    public void rename(String nick) {
        this.name = nick;
    }

    public String status() {
        return alive() ? name + " : " + hp + "/" + maxhp + (armor>0 ? " " + armor : "") : "Knocked Out";
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
                try {
                    ability.Update(arena, this);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void onTurn(Arena arena) {
        hasTurn = true;

    }

    public void endTurn(Arena arena) {
        hasTurn = false;
    }

    public List<Ability> getByType(int type) {
        switch (type) {
            case 0:
                return attacks;
            case 1:
                return actions;
            case 2:
                return spares;
            case 3:
                return defense;
            default:
                return null;
        }
    }

    public void setSelectedAbility(Ability ability) {
        selectedAbility = ability;
    }

    public void clearSelectedAbility() {
        selectedAbility = null;
    }

    public Ability getSelectedAbility() {
        return selectedAbility;
    }

    public void selectTarget(Creature creature) {
        selectedTargets.add(creature);
        targetsSelected = true;
    }

    public void clearTargets() {
        selectedTargets.clear();
        targetsSelected = false;
    }

    public boolean isReady() {
        return (selectedAbility != null) && targetsSelected;
    }

    public List<Creature> getSelectedTargets() {
        return new ArrayList<>(selectedTargets);
    }

    public void addExtraDamage(int extraDamage) {
        this.extraDamage += extraDamage;
    }

    @Override
    public String toString() {
        return name;
    }
    public void spriteUpdate(Arena arena) {
        age++;
    }

    public void heal(int ammount) {
        hp += ammount;
        if (hp > maxhp) {
            hp = maxhp;
        }
    }
    public boolean hasMaxHealth() {
        return hp >= maxhp;
    }

    public void modifyArmor(int addedArmor) {
        this.armor+=addedArmor;
    }
    public int getHpPercent() {
        return (int) (((float)hp/(float)maxhp) * 100);
    }
    public int getArmor() {
        return armor;
    }
}
