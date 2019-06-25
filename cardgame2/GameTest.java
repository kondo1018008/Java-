package cardgame2;

import java.util.*;

/**
 * @author b1018008 Shogo Kondo
 *
 */
public class GameTest {
	public static void main(String[] args) {
	    GameMain gm = new GameMain();
	  
	    gm.addPlayer("Marks");
	    gm.addPlayer("Bob");
	    gm.addPlayer("Alice");
	    gm.addPlayer("Linda");
			
	    //各プレイヤーに3枚配る
	    gm.dealCards(3);
		
	    //getWinner(とgetPlayers)のテストのために，各プレイヤーに得点を乱数で与える
	    Random r = new Random();
	    for(Player p : gm.getPlayers()) {
	        p.setScore(r.nextInt(100));
	    }
			
	    System.out.println(gm);
	    System.out.println("Winner : " + gm.getWinner().getName());
	}
}
