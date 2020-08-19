package sk.brano.objects;

import sk.brano.utils.Utils;

public class Hunter extends Character{

    private Weapon weapon;

    public Hunter(int health, int mana, int strength, int agility) {
        super(health, mana, strength, agility);
        this.setHealth(150);
        this.setMana(0);
        this.setStrength(40);
        this.setAgility(100);
        this.weapon = new Bow(30, 50, "Poor");
    }

    public void attack(Character character){
        int weaponHit = Utils.calculateWeaponHit(weapon.getDamage(), weapon.getSpeed());
        super.attack(character, weaponHit);
    }

    public boolean block() {
        return super.block();
    }
}
