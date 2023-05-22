import java.util.ArrayList;
import java.util.Scanner;
public abstract class  Pokemon {

    protected ArrayList<String> move;//ArrayList型でstring型の要素を持つことが出来る配列
    //protected String str_move1=String.join(",",move1);
    protected ArrayList<Integer> movepower;
    protected String name;
    

    public Pokemon(){

    }
    public abstract void attack(Pokemon pokemon);

    public void attack(int num,Pokemon pokemon){
        System.out.println(name+"は"+move.get(num)+"を使った！");
        System.out.println(""+pokemon.name+"は"+movepower.get(num)+"のダメージを受けた！");
        
    }

    
}
