package Abilities.custom.Brawler;

import Abilities.AttackAbility;

public class PunchAttack extends AttackAbility {
    public PunchAttack() {
        super("Punch", 0, 0, 10, 15, 75, 1);
    }

    @Override
    public String getDescription() {
        StringBuffer sb = new StringBuffer(super.getDescription());
        sb.append("\nDescription: <insert ability description here>");
        return sb.toString();
    }
}
