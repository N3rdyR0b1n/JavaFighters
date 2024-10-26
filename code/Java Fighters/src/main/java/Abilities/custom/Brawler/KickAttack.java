package Abilities.custom.Brawler;

import Abilities.AttackAbility;

public class KickAttack extends AttackAbility {
    public KickAttack() {
        super("Drop Kick", 0, 0, 15, 25, 50, 1);
    }

    @Override
    public String getDescription() {
        StringBuffer sb = new StringBuffer(super.getDescription());
        sb.append("\nDescription: <insert ability description here>");
        return sb.toString();
    }
}
