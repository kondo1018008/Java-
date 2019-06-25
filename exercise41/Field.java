package exercise41;

/**
 * @author b1018008 Shogo Kondo
 *
 */
public class Field {

		  public Field() {  // コンストラクタ

		  }

		 

		  public void simulate(Ball ball) {
			  for(int i = 0; i < 1000; i++) {
				  ball.tictac(0.001);
			  }
			  System.out.println("A1: " + ball.getL());
			  System.out.println("A2: " + ball.getX());
			  //System.out.println(ball.getL());
			  
		  }

		 

		  public static void main(String[] args) {
			  Ball ball = new Ball(13.0,29.0);
		    Field f =new Field();
		    f.simulate(ball);

		  }

		}
