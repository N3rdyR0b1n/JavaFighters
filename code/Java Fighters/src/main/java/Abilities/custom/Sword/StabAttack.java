package Abilities.custom.Sword;

import Abilities.AttackAbility;

public class StabAttack extends AttackAbility {
    public StabAttack() {
        super("Stab", 0, 0, 12, 18, 60, 1);
    }

    @Override
    public String getDescription() {
        StringBuffer sb = new StringBuffer(super.getDescription());
        sb.append("\nDescription: <insert ability description here>");
        return sb.toString();
    }
}
