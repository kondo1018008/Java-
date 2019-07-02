package cardgame3;
/**
 * @author b1018008 Shogo Kondo
 *
 */
import java.util.*;

public class GameMain {
	protected ArrayList<Player> players;
	protected ArrayList<Card> deck;
	
	public GameMain(){
		this.players = new ArrayList<>();
		this.deck = new ArrayList<>();
		for(int i = 0; i < 4; i++ ) {
			for(int j = 1; j <= 13;j++) {
				if(i==0) {
					deck.add(new Card('S',j));
				}else if(i==1) {
					deck.add(new Card('H', j));
				}else if(i==2) {
					deck.add(new Card('D',j));
				}else {
					deck.add(new Card('C',j));
				}
			}
		}
		Collections.shuffle(deck);
	}
	
	public ArrayList<Player> getPlayers(){
		return this.players;
	}
	public ArrayList<Card> getDeck(){
		return this.deck;
	}
	
	public void addPlayer(String name) {
		this.players.add(new Player(name));
	}
	
	public void dealCards(int N) {
		
		for(int i = 0; i < N ; i++) {
			for(Player p : this.players) {
				p.addCard(deck.remove(0));
			}
		}
	}
	public Player getWinner() {
		Player winner = players.get(0);
		int score = 0;
		for(Player p: this.players) {
			if(score<p.getScore()) {
				winner = p;
				score = p.getScore();
			}
		}
		return winner;
	}
	
	public String toString() {
		String n = "";
		for(Player p: players) {
			n = n + p.toString()+"\n";
		}
		return n+"Deck remain "+this.deck.size();
	}
}
