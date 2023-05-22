import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

//import javax.security.auth.callback.ChoiceCallback;
public class App {
    public static void main(String[] args) throws Exception {
        final Random RAN = new Random();
        ArrayList<String> bata_move_list;//ArrayList型でstring型の要素を持つことが出来る配列
        //protected String str_move1=String.join(",",move1);
        ArrayList<Integer> bata_move_power_lsit;
        int bata_speed=90;
        bata_move_list = new ArrayList<>();
        bata_move_power_lsit = new ArrayList<>();
        bata_move_list.add("1:はどうだん");
        bata_move_list.add("2:グラスミキサー");
        bata_move_list.add("3:ハードプラント");
        bata_move_list.add("4:ベノムショック");
        bata_move_power_lsit.add(80);
        bata_move_power_lsit.add(70);
        bata_move_power_lsit.add(150);
        bata_move_power_lsit.add(30);

        ArrayList<String> musasi_move_list;//ArrayList型でstring型の要素を持つことが出来る配列
        //protected String str_move1=String.join(",",move1);
        ArrayList<Integer> musasi_move_power_lsit;
        int musasi_speed=100;
        musasi_move_list = new ArrayList<>();
        musasi_move_power_lsit = new ArrayList<>();
        musasi_move_list.add("1:からさ4しょうゆ");
        musasi_move_list.add("2:面大盛り肉増し温玉");
        musasi_move_list.add("3:定休日");
        musasi_move_list.add("4:学割");
        musasi_move_power_lsit.add(80);
        musasi_move_power_lsit.add(70);
        musasi_move_power_lsit.add(150);
        musasi_move_power_lsit.add(60);
        Player player = new Player(320,"バータ",bata_move_list,bata_move_power_lsit,bata_speed);
        Player hikae =new Player(350,"武蔵坊主",musasi_move_list,musasi_move_power_lsit,musasi_speed);
        

        
        Pokemon enemy = null;
        int same_speed;//同速
        int speed=0;
        int result;
        ArrayList<String> battle_command_list;
        battle_command_list=new ArrayList<>();
        battle_command_list.add("戦う");
        battle_command_list.add("道具");
        battle_command_list.add("逃げる");
        battle_command_list.add("交代");
        ArrayList<String> goods_command_list;
        goods_command_list=new ArrayList<>();
        goods_command_list.add("ボール");
        goods_command_list.add("回復");
        goods_command_list.add("状態回復");
        goods_command_list.add("ドーピング");
        ArrayList<String> ball_command_list;
        ball_command_list=new ArrayList<>();
        ball_command_list.add("モンスターボール");
        ball_command_list.add("サッカーボール");
        ball_command_list.add("テニスボール");
        ball_command_list.add("ドーナツホール");
        ArrayList<String> recovery_command_list;
        recovery_command_list=new ArrayList<>();
        recovery_command_list.add("きずぐすり");
        recovery_command_list.add("満タンのくすり");
        recovery_command_list.add("ニキビに効くくすり");
        recovery_command_list.add("怪しい薬");
        ArrayList<String> dopingu_command_list;
        dopingu_command_list=new ArrayList<>();
        dopingu_command_list.add("スピーダー");
        dopingu_command_list.add("プラスパワー");
        dopingu_command_list.add("ヨクあた－ーる");
        dopingu_command_list.add("ガチのドーピング");
        ArrayList<String> status_recovery_command_list;
        status_recovery_command_list=new ArrayList<>();
        status_recovery_command_list.add("やけどなおし");
        status_recovery_command_list.add("麻痺直し");
        status_recovery_command_list.add("ねむけざましのコーヒー");
        status_recovery_command_list.add("怪しい薬");

        int random_enemy;//どの敵が選ばれるか
        random_enemy = RAN.nextInt(4);
        enemy=enemyChoice(random_enemy);//敵作る

        
        System.out.println("野生動物の"+enemy.name+"が現れた！");
        System.out.println(""+player.name+"はどうする？");
        while(true){//こっからバトル開始
            choice(battle_command_list);
            Scanner scanner = new Scanner(System.in);
            String input_text1 = scanner.nextLine();//どのコマンドか選ぶ
            int battle_command=Integer.parseInt(input_text1);
            if(0<battle_command && battle_command<5){//ちゃんと選択肢の中の番号が押せているか確認
                if(battle_command==1){//銭湯コマンドの場合
                    player.choice_move(player);
                    if(player.getSpeed()>enemy.getSpeed()){//味方の方が早かったら
                        result = player.attack(enemy);//味方の攻撃
                        if (result == 0) {//どっちかが死んだら
                            break;
                        }
                        result= enemy.attack(player);
                        if (result == 0) {//どっちかが死んだら
                            break;
                        }
                    }else if(enemy.getSpeed()>player.getSpeed()){//敵の方が早かったら
                        result= enemy.attack(player); 
                        if (result == 0) {//もしどっちかが死んだら
                            break;
                        }
                        result = player.attack(enemy);
                        if (result == 0) {//もしどっちが死んだら
                            break;
                        }
                    }else{//同速だったら
                        System.out.println("どうそくだった！");
                        same_speed = RAN.nextInt(2);
                        if(same_speed==0){
                            result = player.attack(enemy);
                            if (result == 0) {//もしどっちかが死んだら
                                break;
                            }
                            result= enemy.attack(player);
                            if (result == 0) {//もしどっちかが死んだら
                                break;
                            }
                        }else{
                            result= enemy.attack(player);
                            if (result == 0) {//もしどっちかが死んだら
                                break;
                            }
                            result = player.attack(enemy);
                            if (result == 0) {//もしどっちかが死んだら
                                break;
                            }
                        }
                    }            
                }else if(battle_command==2){//道具コマンドの場合
                        System.out.println(""+player.name+"はどの道具を使う？");
                        choice(goods_command_list);            
                        String input_text2 = scanner.nextLine();//どのコマンドか選ぶ
                        int goodscommand=Integer.parseInt(input_text2);
                        if(goodscommand==1){//ボール表示
                            boolean capture_flag;
                            System.out.println(""+player.name+"はどのボールを投げる？");
                            choice(ball_command_list);
                            capture_flag=capture(player,enemy);
                            if(capture_flag){
                                break;
                            }      
                        }else if(goodscommand==2){//回復表示
                            System.out.println(""+player.name+"はどの薬を使う？");
                            choice(recovery_command_list);
                            recover(player);
                        }else if(goodscommand==3){//状態回復表示
                            System.out.println(""+player.name+"はどの薬を使う？");
                            choice(status_recovery_command_list);
                            statusrecover(player);       
                        }else if(goodscommand==4){//ドーピング表示
                            System.out.println(""+player.name+"はどの薬を使う？");
                            choice(dopingu_command_list);
                            dopingu(player);
                        }
                        result=enemy.attack(player);
                        if (result == 0) {//模試敵が死んだら
                            break;
                        }
                }else if(battle_command==3){//逃げるコマンドの場合
                    boolean escape_flag;
                    escape_flag=escape(player);
                    if(escape_flag){
                        System.out.println(""+player.name+"は上手く逃げることが出来た！");
                        break;
                    }
                    result=enemy.attack(player);
                    if (result == 0) {//模試敵が死んだら
                        break;
                    } 
                }else if(battle_command==4){//交代コマンドの場合
                    System.out.println("どのポケモンに交代しますか？");
                    System.out.println("戻れ！"+player.name+"!");
                    System.out.println("ででこい！"+hikae.name+"!");

                    Player tmp=player;
                    player=hikae;
                    hikae=tmp;
                    result=enemy.attack(player);
                    if (result == 0) {//模試敵が死んだら
                        break;
                    }
                }
            }else{//押せていない時
                System.out.println("そんな選択技はありません。ちゃんとよく文字を読んでください");
            }
        }
        
    }
    static public Pokemon enemyChoice(int num){//敵作る関数
        final Random RAN = new Random();
        ArrayList<String> enemy_move_lsit;//ArrayList型でstring型の要素を持つことが出来る配列
        enemy_move_lsit = new ArrayList<>();
        ArrayList<Integer> enemy_move_power;
        int speed=0;

        enemy_move_power = new ArrayList<>();
        int random_enemy_speed;//素早さ
        int random_enemy=num;
        Pokemon enemy = null;
        if (random_enemy == 0) {
            enemy_move_lsit.add("1:オブジェクト指向について６時間語る");
            enemy_move_lsit.add("2:納得");
            enemy_move_lsit.add("3:胃の調子が悪い");
            enemy_move_lsit.add("4:森さんを招集");
            enemy_move_power.add(140);
            enemy_move_power.add(80);
            enemy_move_power.add(0);
            enemy_move_power.add(90);
            random_enemy_speed = RAN.nextInt(10);
            if(0<=random_enemy_speed && random_enemy_speed<=3){
                speed=90;
            }else if(4<=random_enemy_speed && random_enemy_speed<=6){
                speed=100;
            }else{
                speed=110;
            }
            enemy = new Enemy(320,"ぱちるす",enemy_move_lsit,enemy_move_power,speed);
            return enemy;
        }else if (random_enemy == 1) {
            enemy_move_lsit = new ArrayList<>();
            enemy_move_power = new ArrayList<>();
            enemy_move_lsit.add("1:とっくー");
            enemy_move_lsit.add("2:音ゲー台パンアタック");
            enemy_move_lsit.add("3:めがねクイッ");
            enemy_move_lsit.add("4:リーチ一発ツモ平和純チャン三色一盃口ドラドラドラ！");
            enemy_move_power.add(140);
            enemy_move_power.add(60);
            enemy_move_power.add(0);
            enemy_move_power.add(100);
            random_enemy_speed = RAN.nextInt(10);
            if(0<=random_enemy_speed && random_enemy_speed<=3){
                speed=90;
            }else if(4<=random_enemy_speed && random_enemy_speed<=6){
                speed=100;
            }else if(7<=random_enemy_speed && random_enemy_speed<=9){
                speed=110;
            }
            enemy = new Enemy(320,"おっとー",enemy_move_lsit,enemy_move_power,speed);
            return enemy;
        }else if (random_enemy == 2) {
            enemy_move_lsit.add("1:そっか...");
            enemy_move_lsit.add("2:スイーツ巡り");
            enemy_move_lsit.add("3:なんでそんなん言うん");
            enemy_move_lsit.add("4:ラプハラ");
            enemy_move_power.add(40);
            enemy_move_power.add(20);
            enemy_move_power.add(90);
            enemy_move_power.add(130);
            random_enemy_speed = RAN.nextInt(10);
            if(0<=random_enemy_speed && random_enemy_speed<=3){
                speed=90;
            }else if(4<=random_enemy_speed && random_enemy_speed<=6){
                speed=100;
            }else if(7<=random_enemy_speed && random_enemy_speed<=9){
                speed=110;
            }
            enemy = new Enemy(320,"黒崎君",enemy_move_lsit,enemy_move_power,speed);
            return enemy;
        }else if (random_enemy == 3) {
            enemy_move_lsit.add("1:せやな");
            enemy_move_lsit.add("2:スーッ...せやな..");
            enemy_move_lsit.add("3:万札でケツ拭き");
            enemy_move_lsit.add("4:アルハラ");
            enemy_move_power.add(40);
            enemy_move_power.add(10);
            enemy_move_power.add(100);
            enemy_move_power.add(130);
            random_enemy_speed = RAN.nextInt(10);
            if(0<=random_enemy_speed && random_enemy_speed<=3){
                speed=90;
            }else if(4<=random_enemy_speed && random_enemy_speed<=6){
                speed=100;
            }else if(7<=random_enemy_speed && random_enemy_speed<=9){
                speed=110;
            }
            enemy = new Enemy(320,"谷口きゃにお",enemy_move_lsit,enemy_move_power,speed);
            return enemy;
        }else{
            System.out.println("ドンマイ");
            enemy=null;
            return enemy;
        }
        
    }

    static public void choice(ArrayList<String>choice){//選択肢の中から選ぶ関数
        for(int i=0;i<choice.size();i++){
            int num=i+1;
            System.out.println(""+num+":"+choice.get(i));
        }
    }
    static public void recover(Pokemon player){//回復関数
        Scanner scanner = new Scanner(System.in);
        String input_text4 = scanner.nextLine();//どのコマンドか選ぶ
        int recoverycommand=Integer.parseInt(input_text4);
        if(recoverycommand==1){
            System.out.println(""+player.name+"はきずぐすりを使った！");
            System.out.println(""+player.name+"の体力は20回復した!");
            player.hp=player.hp+20;
            System.out.println(""+player.name+"の残り体力は"+player.hp+"だ！");
        }else if(recoverycommand==2){
            System.out.println(""+player.name+"は満タンのくすりを使った！");
            System.out.println(""+player.name+"の体力は全回復した!");
            player.hp=player.maxhp;
            System.out.println(""+player.name+"の残り体力は"+player.hp+"だ！");
        }else if(recoverycommand==3){
            System.out.println(""+player.name+"はニキビに効くくすりを塗った！");
            System.out.println(""+player.name+"のニキビが減った!");
        }else if(recoverycommand==4){
            System.out.println(""+player.name+"は怪しい薬をキメた！");
            System.out.println(""+player.name+"の素早さがぐぐーんと上がった!");
            player.speed=player.speed+400;
        }


    }
    static public void statusrecover(Pokemon player){//状態回復関数
        Scanner scanner = new Scanner(System.in);
        String input_text5 = scanner.nextLine();//どのコマンドか選ぶ
        int statusrecoverycommand=Integer.parseInt(input_text5);
        if(statusrecoverycommand==1){
            System.out.println(""+player.name+"はやけど直しを使った！");
            System.out.println();
            System.out.println(""+player.name+"のやけどはきれいさっぱり無くなった!");
            System.out.println();
        }else if(statusrecoverycommand==2){
            System.out.println(""+player.name+"は麻痺直しを使った！");
            System.out.println();
            System.out.println(""+player.name+"の麻痺はきれいさっぱり無くなった!");
            System.out.println();
        }else if(statusrecoverycommand==3){
            System.out.println(""+player.name+"はねむけざましのコーヒーを使った！");
            System.out.println();
            System.out.println(""+player.name+"のねむけは無くなった!");
            System.out.println();
        }else if(statusrecoverycommand==4){
            System.out.println(""+player.name+"は怪しい薬を使った！");
            System.out.println();
            System.out.println(""+player.name+"は薬物中毒になった！");
            System.out.println();
        }

    }
    static public boolean capture(Pokemon player,Pokemon enemy){//ボール関数
        ArrayList<String> two_choice;
        two_choice=new ArrayList<>();
        two_choice.add("はい");
        two_choice.add("いいえ");
        final Random RAN = new Random();
        int choice_ball;//ボール
        Scanner scanner = new Scanner(System.in);
        String input_text3 = scanner.nextLine();//どのコマンドか選ぶ
        int ballcommand=Integer.parseInt(input_text3);
        if(ballcommand==1){
            try{
                System.out.println(""+player.name+"はモンスターボールを使った！");
                choice_ball = RAN.nextInt(10);
                if(0<=choice_ball &&choice_ball<=1){
                    System.out.println("コロ");
                    System.out.println();
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("コロ");
                    System.out.println();
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("コロ");
                    System.out.println();
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("カチッ！");
                    System.out.println(""+player.name+"は"+enemy.name+"を捕まえることが出来た！");
                    System.out.println(""+enemy.name+"の情報がポケモン図鑑に登録されます");
                    System.out.println(""+enemy.name+"をボックスに送りますか？");
                    choice(two_choice);
                    String input_text5 = scanner.nextLine();//どのコマンドか選ぶ
                    int boxcommand=Integer.parseInt(input_text5);
                    if(boxcommand==1){
                        System.out.println(""+enemy.name+"をボックスに送った\n");
                        return true;
                    }else if(boxcommand==2){
                        System.out.println(""+enemy.name+"を手持ちに加えた\n");
                        return true;
                    }
                }else if(2<=choice_ball && choice_ball<=3){
                    System.out.println("コロ");
                    System.out.println();
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("コロ");
                    System.out.println();
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("コロ");
                    System.out.println();
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("ざんねん！もうすこしでつかまえられたのに！");
                    return false;
                }else if(4<=choice_ball && choice_ball<=6){
                    System.out.println("コロ");
                    System.out.println();
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("コロ");
                    System.out.println();
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("ああ！つかまえたとおもったのに！");
                    return false;
                }else if(7<=choice_ball && choice_ball<=9){
                    System.out.println("コロ");
                    System.out.println();
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("ダメだ！ポケモンがボールから出てしまった！");
                    return false;
                   }   
            }catch(Exception e){
                System.out.println("ドンマイ");
                return false;
            }
        }else if(ballcommand==2){
            System.out.println(""+player.name+"はサッカーボールを蹴った！");
            return false;
        }else if(ballcommand==3){
            System.out.println(""+player.name+"はテニスボールを打ち返した！");
            return false;
        }else if(ballcommand==4){
            System.out.println(""+player.name+"はドーナツホールを歌った！");
            return false;
        }
         return false;
    
    }
    static public void dopingu(Pokemon player){//ドーピング関数
        Scanner scanner = new Scanner(System.in);
        String input_text6 = scanner.nextLine();//どのコマンドか選ぶ
        int dopingucommand=Integer.parseInt(input_text6);
        if(dopingucommand==1){
            System.out.println(""+player.name+"はスピーダーを使った！");
            player.speed=player.speed+50;
            System.out.println();
            System.out.println(""+player.name+"の素早さがあがった!");
            System.out.println();
        }else if(dopingucommand==2){
            System.out.println(""+player.name+"はプラスパワーを使った！");
            System.out.println();
            System.out.println(""+player.name+"の攻撃力があがった!");
            System.out.println();
        }else if(dopingucommand==3){
            System.out.println(""+player.name+"はヨクあた－ーるを使った！");
            System.out.println();
            System.out.println(""+player.name+"の命中率があがった!");
            System.out.println();
        }else if(dopingucommand==4){
            System.out.println(""+player.name+"はガチのドーピングをキメた！");
            System.out.println();
            System.out.println(""+player.name+"は大会の参加資格を失った!");
            System.out.println();
        }
        
    }
    static public boolean escape(Pokemon player){ //逃げる関数ひえひえ
        final Random RAN = new Random();
        int escape;//逃げeeeeeeeeeeeee
        escape = RAN.nextInt(7);
        if(0<=escape &&escape<=2){
            return true;
        }else{
            System.out.println(""+player.name+"は逃げられなかった..");
            return false;   
        }
    }
}


