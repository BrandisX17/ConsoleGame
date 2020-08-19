package sk.brano.objects;

public abstract class Weapon {

    private int damage;
    private int speed;
    private String rarity;
    private boolean equipped;

    public Weapon(int damage, int speed, String rarity) {

        this.damage = damage;
        this.speed = speed;
        this.rarity = rarity;
        equipped = true;
    }



    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
    }

    public String getRarity() {
        return rarity;
    }
}
