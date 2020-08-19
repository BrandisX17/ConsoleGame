package sk.brano.objects;


import sk.brano.utils.Utils;

public abstract class Character {

    private int health;
    private int mana;
    private int strength;
    private int agility;
    private boolean attackable;
    private int blockCount;

    public Character(int health, int mana, int strength, int agility) {
        this.health = health;
        this.mana = mana;
        this.strength = strength;
        this.agility = agility;
        //always attackable at the beginning, could block after using the block move
        attackable = true;
        blockCount = 0;

    }
    protected void attack(Character character, int weaponHit){
        if (character.attackable){
            //hit for now only uses the strength of a character and weapon properties
            int characterDamage = Utils.calculateCharacterHit(strength, agility) + weaponHit;
            character.setHealth(character.getHealth()-characterDamage);
        }
    }

    protected boolean block() {
        //can only block 2x in a row
        if (blockCount <= 2) {
            attackable = false;
            blockCount++;
            return true;
        }
        return false;
    }

//    public void dodge(){
//
//    }

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setHealth(int health) {

        this.health = health;
    }

    public void setMana(int mana) {

        this.mana = mana;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }
}
