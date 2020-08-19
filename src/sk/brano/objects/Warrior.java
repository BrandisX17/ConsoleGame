package sk.brano.objects;

import sk.brano.utils.Utils;

public class Warrior extends Character{

    private Weapon weapon;

    public Warrior(int health, int mana, int strength, int agility) {
        super(health, mana, strength, agility);
        this.setHealth(200);
        this.setMana(1);
        this.setStrength(50);
        this.setAgility(50);
        this.weapon = new Axe(50, 20, "Poor");
    }


    public void attack(Character character){
        int weaponHit = Utils.calculateWeaponHit(weapon.getDamage(), weapon.getSpeed());
        super.attack(character, weaponHit);
    }

    public boolean block(Character character) {
        return super.block();
    }
}
