package org.imperium.game.core.gameObject.fight;

import lombok.Data;

@Data
public class FightStats {
    private float attackRange;
    private float maxHealth;
    private float defence;
    private float health;
    private float damage;

    public FightStats(float attackRange, float damage, float maxHealth, float defence){
        this.attackRange = attackRange;
        this.damage = damage;
        this.maxHealth = maxHealth;
        this.defence = defence;
        this.health = maxHealth;
    }

    public void acceptDamage(float damage){
        this.health -= (damage - this.defence);
    }

}
