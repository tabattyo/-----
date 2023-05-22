import java.util.ArrayList;
import java.util.Scanner;
public class Player extends Pokemon {


    public Player(){
        name="バータ";//メソッド内に定義するローカル変数はフィールド名を使いまわせる
        move = new ArrayList<>();
        movepower = new ArrayList<>();
        move.add("1:はどうだん");
        move.add("2:グラスミキサー");
        move.add("3:ハードプラント");
        move.add("4:ベノムショック");
        movepower.add(80);
        movepower.add(40);
        movepower.add(150);
        movepower.add(60);
        

    }

    public void attack(Pokemon pokemon){
        System.out.print("野生動物の"+pokemon.name+"が現れた！\n");
        System.out.print(""+name+"はどうする？\n");

        
        for(int i=0;i<move.size();i++){
            System.out.println(move.get(i));
        }

        Scanner scanner = new Scanner(System.in);
        String input_text1 = scanner.nextLine();

        //入力を文字から数字
        int num=Integer.parseInt(input_text1);
        
        if(0<num && num<5){
            //技を使う
            num=num-1;
            super.attack(num,pokemon);//相手のオブジェクトの情報をとってくる方法　ひきすうでとるか、スタティックでやるか、コンストラクタでとりこむでやるか
        }else{
            System.out.println("そんな技はありません。ちゃんとよく文字を読んでください");
        }


    }
    
}
