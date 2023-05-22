import java.util.ArrayList;
import java.util.Random;
public class Enemy extends Pokemon{
    static final Random ran =new Random();

    public Enemy(int hp,String name,ArrayList<String>move,ArrayList<Integer> movepower,int speed){
        this.hp=hp;
        this.name=name;
        this.move_list=move;
        this.move_power_lsit=movepower;
        this.speed=speed;
    }
    public int attack(Pokemon pokemon){
        int enmey_random_move;
        enmey_random_move=ran.nextInt(4);
        result=super.attack(enmey_random_move,pokemon);
        return result;
    }
    

    
}
