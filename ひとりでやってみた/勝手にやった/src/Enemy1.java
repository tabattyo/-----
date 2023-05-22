import java.util.ArrayList;
import java.util.Random;
public class Enemy1 extends Enemylist{
    static final Random ran =new Random();

    public Enemy1(){
        name="ぱちるす";//メソッド内に定義するローカル変数はフィールド名を使いまわせる
        move = new ArrayList<>();
        movepower = new ArrayList<>();
        move.add("1:電気ショック");
        move.add("2:１０万ボルト");
        move.add("3:あまえる");
        move.add("4:ほっぺすりすり");
        movepower.add(40);
        movepower.add(90);
        movepower.add(0);
        movepower.add(50);
        
    }
    public void attack(Pokemon pokemon){
        int flag;
        flag=ran.nextInt(4);
        super.attack(flag,pokemon);

    }

    
}
