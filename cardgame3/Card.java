package cardgame3;

/**
 * @author b1018008 Shogo Kondo
 *
 */
public class Card {
	private char suit;
	private int number;
	
	public Card(char suit, int number){
		this.suit =  suit;
		this.number = number;
	}
	
	public char getSuit(){
		return this.suit; 
	}
	
	private void setSuit(char suit) {
		this.suit = suit;
	}
	
	public int getNumber(){
		return this.number;
	}
	
	private void setNumber(int number){
		this.number = number;
	}
	
	public String toString() {
		if(this.number == 1) {
			return (this.suit+"-"+'A').toString();
		}else if(this.number == 10) {
			return (this.suit+"-"+'T').toString();
		}else if(this.number == 11) {
			return (this.suit+"-"+'J').toString();
		}else if(this.number == 12) {
			return (this.suit+"-"+'Q').toString();
		}else if(this.number == 13) {
			return (this.suit+"-"+'K').toString();
		}
		return (this.suit+"-"+this.number).toString();
	}
}
