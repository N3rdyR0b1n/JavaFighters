package Abilities.custom.Cowboy;

import Abilities.AttackAbility;

public class QuickDrawAttackAbility extends AttackAbility {
    public QuickDrawAttackAbility() {
        super("Quick Draw", 1, 0, 5, 10, 85, 3);
    }

    @Override
    public String getDescription() {
        StringBuffer sb = new StringBuffer(super.getDescription());
        sb.append("\nDescription: <insert ability description here>");
        return sb.toString();
    }
}
