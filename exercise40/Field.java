package exercise40;

/**
 * @author b1018008 Shogo Kondo
 *
 */
public class Field {

		  public Field() {  // コンストラクタ

		  }

		 

		  public void simulate(Ball ball) {
			  System.out.println(ball.getL());
		  }

		 

		  public static void main(String[] args) {
			  Ball ball = new Ball(13.0,29.0);
		    Field f =new Field();
		    f.simulate(ball);

		  }

		}
