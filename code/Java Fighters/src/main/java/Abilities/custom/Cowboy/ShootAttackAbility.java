package Abilities.custom.Cowboy;

import Abilities.AttackAbility;

public class ShootAttackAbility extends AttackAbility {
    public ShootAttackAbility() {
        super("High Noon", 3, 0, 30, 30, 100, 1);
    }

    @Override
    public String getDescription() {
        StringBuffer sb = new StringBuffer(super.getDescription());
        sb.append("\nDescription: <insert ability description here>");
        return sb.toString();
    }
}
