package exercise42;

/**
 * @author b1018008 Shogo Kondo
 *
 */
public class Field {
		private boolean stop;

		  public Field() {  // コンストラクタ
			  this.stop = false;

		  }
		 

		  public void simulate(Ball ball) {
			  while(this.stop == false) {
				  ball.tictac(0.001);
				  
			  }
			  System.out.println("A1: " + ball.getL());
			  System.out.println("A2: " + ball.getX());
			  //System.out.println(ball.getL());
			  
		  }
		  
		  public void stopTime() {
			  this.stop = true;
		  }

		 

		  public static void main(String[] args) {
			  Field f =new Field();
			  Ball ball = new Ball(f,13.0,29.0);
		    f.simulate(ball);

		  }

		}
