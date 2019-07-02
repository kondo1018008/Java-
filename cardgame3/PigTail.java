package cardgame3;
import java.util.*;
/**
 * @author b1018008 Shogo Kondo
 *
 */
public class PigTail extends GameMain {
	private ArrayList<Card> trash;
	public PigTail() {
		super();
		this.trash = new ArrayList<>();
	}
	
	public boolean drawCard(Player p) {
		//p.addCard(super.deck.remove(0));
		if(!super.deck.isEmpty()) {
			Card c = super.deck.remove(0);//カードを引く
			System.out.println(p.getName()+" draws "+p.toString());
			if(this.trash.isEmpty()) {//trashが空だったら
				this.trash.add(c);//引いたカードをtrashに捨てる
			}else if(c.getSuit() == this.trash.get(this.trash.size()-1).getSuit() || c.getNumber() == this.trash.get(this.trash.size()-1).getNumber()){//equals?
				//引いたカードとtrashの一番上のカードが同じマークか同じ数値であれば
				p.addCard(c);//playerの手札に引いたカードを加える
				System.out.println(p.getName()+" incurs "+trash.size() + " cards");
				for(Card i: trash) {//trashにあるカードをfor文で回して全て手札に加える
					p.addCard(i);
				}
				this.trash.clear();//trashを空にする
			}else {
				//マークも数値も異なる場合
				this.trash.add(c);//カードをtrashに捨てる
			}
			p.setScore(p.getHands().size());
			return true;
		}else{
			return false;
		}
	}
	
	public Player getWinner() {
		Player winner = super.players.get(0);//スコアが一番少ない人が優勝
		int score = winner.getScore();
		for(Player p: super.players) {
			if(score>p.getScore()) {
				winner = p;
				score = p.getScore();
			}
		}
		return winner;
	}
}
