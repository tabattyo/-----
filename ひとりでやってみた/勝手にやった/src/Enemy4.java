import java.util.ArrayList;
import java.util.Random;
public class Enemy4 extends Enemylist{
    static final Random ran =new Random();

    public Enemy4(){
        name="黒崎君";//メソッド内に定義するローカル変数はフィールド名を使いまわせる
        move = new ArrayList<>();
        movepower = new ArrayList<>();
        move.add("1:そっか...");
        move.add("2:スイーツ巡り");
        move.add("3:なんでそんなん言うん");
        move.add("4:ラプハラ");
        movepower.add(40);
        movepower.add(20);
        movepower.add(90);
        movepower.add(130);
        
    }
    public void attack(Pokemon pokemon){
        int flag;
        flag=ran.nextInt(4);
        super.attack(flag,pokemon);

    }

    
}
