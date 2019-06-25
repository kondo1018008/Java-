package cardgame0;
/**
 * @author b1018008 Shogo Kondo
 *
 */
public class GameTest {
	public static void main(String[] args) {
		  char[] suits = {'S', 'H', 'D', 'C'};	
		  
		  for(char s : suits) {
		    for(int i=1; i<=13; i++){
		      Card c = new Card(s, i);
		      System.out.println(c);
		    }
		  }
		}
}
