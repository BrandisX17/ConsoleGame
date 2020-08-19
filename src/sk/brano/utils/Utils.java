package sk.brano.utils;

public class Utils {
    public static int calculateCharacterHit(int strength, int agility){
        return strength + ((agility/100)*strength);
            }

    public static int calculateWeaponHit(int damage, int speed){
        return damage + ((100/speed)*damage);
    }
}
