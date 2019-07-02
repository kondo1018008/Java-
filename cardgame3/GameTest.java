package cardgame3;

import java.util.*;

/**
 * @author b1018008 Shogo Kondo
 *
 */
public class GameTest {
	public static void main(String[] args) {
	    PigTail pt = new PigTail();

	    //プレイヤーの追加
	    pt.addPlayer("Marks");
	    pt.addPlayer("Bob");
	    pt.addPlayer("Alice");
	    pt.addPlayer("Linda");
	    
	    //ゲームの進行
	    boolean flag = false;
	    while(true) {
	        for(Player p : pt.getPlayers()) {
	            if(!pt.drawCard(p)) {
	                flag = true;
	                break;
	            }
	        }
	        if(flag)
	            break;
	    }
	    
	    //結果表示
	    System.out.println(pt);
	    System.out.println("Winner : " + pt.getWinner().getName());
	} 
}
