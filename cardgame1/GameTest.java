package cardgame1;

import java.util.ArrayList;

/**
 * @author b1018008 Shogo Kondo
 *
 */
public class GameTest {
	public static void main(String[] args) {
		  Player p1 = new Player("Alice");
		  Player p2 = new Player("Bob");
		  
		  //Aliceの手札にダイヤのAとクラブの3を追加，得点を10にセット
		  p1.addCard(new Card('D', 1));
		  p1.addCard(new Card('C', 3));
		  p1.setScore(10);
		  System.out.println(p1);    //p1.toString()と同じ
		  
		  //Bobの手札にダイヤのQとクラブのKを追加，得点を20にセット
		  p2.addCard(new Card('D', 12));
		  p2.addCard(new Card('S', 13));
		  p2.setScore(20);
		  System.out.println(p2);    //p2.toString()と同じ
		  
		  //Bobの手札に，スペードのAとクラブのAを一度に追加
		  ArrayList<Card> cs = new ArrayList<>();
		  cs.add(new Card('S', 1));
		  cs.add(new Card('C', 1));
		  p2.addCard(cs);
		  System.out.println(p2);    //p2.toString()と同じ
		}
}
