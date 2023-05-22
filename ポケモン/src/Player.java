import java.util.ArrayList;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;
public class Player extends Pokemon {
    int next_move;

    public Player(int hp,String name,ArrayList<String>move,ArrayList<Integer> movepower,int speed){
        this.hp=hp;
        maxhp=hp;
        this.name=name;
        this.move_list=move;
        this.move_power_lsit=movepower;
        this.speed=speed;
    }

    public void choice_move(Pokemon player){
        System.out.println(""+name+"はどうする？");
        for(int i=0;i<move_list.size();i++){
            System.out.println(move_list.get(i));
        }
        Scanner scanner = new Scanner(System.in);
        String input_text1 = scanner.nextLine();
        //入力を文字から数字
        next_move=Integer.parseInt(input_text1);
    }

    public int attack(Pokemon pokemon){
        if(0<next_move && next_move<5){
            //技を使う
            next_move=next_move-1;
            result=super.attack(next_move,pokemon);//相手のオブジェクトの情報をとってくる方法　ひきすうでとるか、スタティックでやるか、コンストラクタでとりこむでやるか
            return result;   
        }else{
            System.out.println("そんな技はありません。ちゃんとよく文字を読んでください");
            return result;
        }
    }
    
}
