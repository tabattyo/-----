import java.util.ArrayList;
import java.util.Random;
public class Enemy3 extends Enemylist{
    static final Random ran =new Random();

    public Enemy3(){
        name="谷口きゃにお";//メソッド内に定義するローカル変数はフィールド名を使いまわせる
        move = new ArrayList<>();
        movepower = new ArrayList<>();
        move.add("1:せやな");
        move.add("2:スーッ...せやな..");
        move.add("3:服を買いに行く");
        move.add("4:アルハラ");
        movepower.add(40);
        movepower.add(90);
        movepower.add(50);
        movepower.add(130);
        
    }
    public void attack(Pokemon pokemon){
        int flag;
        flag=ran.nextInt(4);
        super.attack(flag,pokemon);

    }

    
}
