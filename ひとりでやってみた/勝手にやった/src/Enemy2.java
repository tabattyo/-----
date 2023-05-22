import java.util.ArrayList;
import java.util.Random;
public class Enemy2 extends Enemylist{
    static final Random ran =new Random();

    public Enemy2(){
        name="おっとー";//メソッド内に定義するローカル変数はフィールド名を使いまわせる
        move = new ArrayList<>();
        movepower = new ArrayList<>();
        move.add("1:とっくー");
        move.add("2:チューニズム");
        move.add("3:めがねクイッ");
        move.add("4:お酒を楽しむ");
        movepower.add(140);
        movepower.add(60);
        movepower.add(0);
        movepower.add(100);
        
    }
    public void attack(Pokemon pokemon){
        int flag;
        flag=ran.nextInt(4);
        super.attack(flag,pokemon);

    }

    
}
