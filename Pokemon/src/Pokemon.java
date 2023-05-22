import java.util.ArrayList;
import java.util.Scanner;
public abstract class  Pokemon {

    protected ArrayList<String> move_list;//ArrayList型でstring型の要素を持つことが出来る配列
    //protected String str_move1=String.join(",",move1);
    protected ArrayList<Integer> move_power_lsit;
    protected String name;
    protected int hp;
    protected int maxhp;
    protected int speed;
    protected int result=3;
    public Pokemon(){

    }
    public abstract int attack(Pokemon pokemon);

    public int getSpeed(){
        return this.speed;

    }

    public int attack(int move_number,Pokemon pokemon){
        System.out.println(name+"は"+move_list.get(move_number)+"を使った！");
        System.out.println(""+pokemon.name+"は"+move_power_lsit.get(move_number)+"のダメージを受けた！");
        pokemon.hp=pokemon.hp-move_power_lsit.get(move_number);
        //hp=hp-movepower.get(num);
        System.out.println(""+pokemon.name+"の残り体力は"+pokemon.hp+"だ！");
        
        if(pokemon.hp<=0){
            System.out.println(""+pokemon.name+"は力尽きた....");
            result=0;
            return result;
        }else{
            result=1;
            return result;
        }

    }

    
}
