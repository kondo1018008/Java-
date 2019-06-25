package exercise40;
/**
 * @author b1018008 Shogo Kondo
 *
 */
public class Ball {
	private double vx = 0.0;

	  private double vy = 0.0;

	  private final double gravity = 9.80665; 

	  private double L;

	 

	  public Ball (double vx, double vy) {

	    this.vx = vx;

	    this.vy = vy;

	    this.L = 2.0*vx*vy/gravity;

	  }  



	  public double getL() {

	    return this.L;

	  }


}
