import java.util.ArrayList;
import java.util.Random;
public class Enemylist extends Pokemon{
    static final Random ran =new Random();
    protected ArrayList<Enemylist> enemylist;
    protected Enemy1 enemy1 ;
    protected Enemy2 enemy2 ;
    protected Enemy3 enemy3 ;
    protected Enemy4 enemy4 ;
    public Enemylist(){
        enemylist = new ArrayList<>();
        enemy1=new Enemy1();
        enemy2=new Enemy2();
        enemy3=new Enemy3();
        enemy4 =new Enemy4();
        enemylist.add(enemy1);
        enemylist.add(enemy2);
        enemylist.add(enemy3);
        enemylist.add(enemy4);
        System.out.print("野生動物のが現れた！\n");
        //System.out.print("野生動物の"+enemylist.get(0)+"が現れた！\n");
        for(int i = 0; i < enemylist.size(); i++){
            System.out.println(enemylist.get(i).name);
        }
        
    }
    public void attack(Pokemon pokemon){
        int flag;
        flag=ran.nextInt(4);
        super.attack(flag,pokemon);

    }

    
}
