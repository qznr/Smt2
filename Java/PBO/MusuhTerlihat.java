import java.io.*;
import java.util.*;

class Player{
    private long health;
    private long damage;
    private long koin;
    
    public Player(){
    }

    public void setHealth(long health){
        this.health = health;
    }

    public void setDamage(long damage){
        this.damage = damage;
    }

    public void addKoin(long koin){
        this.koin += koin;
    }

    public long getHealth(){
        return health;
    }

    public long getDamage(){
        return damage;
    }

    public void upgrade(long koin, long upDamage, long upHealth) {
        for (long i = 0; i < koin; i++) {
            if (i % 2 == 0) {
                this.damage += upDamage;
            } else {
                this.health += upHealth;
            }
        }
    }
}

class Monster{
    private long health;
    private long damage;
    
    public Monster(){
    }

    public void setHealth(long health){
        this.health = health;
    }

    public void setDamage(long damage){
        this.damage = damage;
    }

    public long getHealth(){
        return health;
    }

    public long getDamage(){
        return damage;
    }
}

public class MusuhTerlihat {
    static void battle(Player player, Monster monster){
        String result = "";
        while (player.getHealth() > 0 && monster.getHealth() > 0) {
            monster.setHealth(monster.getHealth() - player.getDamage());
            if (monster.getHealth() <= 0) {
                result = "YES";
                System.out.prlongln(result);
                break;
            }
            player.setHealth(player.getHealth() - monster.getDamage());
            if (player.getHealth() <= 0) {
                result = "NO";
                System.out.prlongln(result);
                break;
            }
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Prlong output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        long n = in.nextlong();
        Player player = new Player();
        Monster monster = new Monster();
        for (long i = 0; i < n; i++) {
            long pHealth = in.nextLong();
            long pDamage = in.nextLong();
            long mHealth = in.nextLong();
            long mDamage = in.nextLong();
            long c = in.nextLong();
            long cD = in.nextLong();
            long cH = in.nextLong();
            
            player.setHealth(pHealth);
            player.setDamage(pDamage);
            monster.setHealth(mHealth);
            monster.setDamage(mDamage);
            player.upgrade(c, cD, cH);
            battle(player,monster);
        }
    }
}