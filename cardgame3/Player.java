package cardgame3;
/**
 * @author b1018008 Shogo Kondo
 *
 */
import java.util.ArrayList;

public class Player {
private String name;
private ArrayList<Card> hands;
private int score;
 public Player(String name) {
	 this.name= name;
	 this.hands = new ArrayList<>();
	 this.score = 0;
 }
 
 public String getName() {
	 return this.name;
 }

 public ArrayList<Card> getHands() {
	 return this.hands;
 }
 
 public int getScore() {
	 return this.score;
 }
 
 public void setScore(int score) {
	 this.score= score;
 }
 
 public String toString() {
	 
	 String s ="";
	 for(Card i: this.hands) {
		 s = s +" "+i.toString();
	 }
	 
	 return this.name + " "+this.score +s;
 }
 
 public void addCard(Card card) {
	 this.hands.add(card);
 }
 
 public void addCard(ArrayList<Card> cards) {
	 this.hands.addAll(cards);
 }
}
