package exercise42;
/**
 * @author b1018008 Shogo Kondo
 *
 */
public class Ball {
	private double x;
    private double y;
    private double vx;
    private double vy;
    private double L;
    private Field field;
    static final private double gravity = 9.80665;
    
    public double getX() {
    	return this.x;
    }
	 
    public void tictac(double deltaTime) {
    	this.x += this.vx*deltaTime;
    	this.y += this.vy*deltaTime;
    	this.vy -= gravity*deltaTime;
    	if(this.y <= 0)
    		field.stopTime();
    }

	  public Ball (Field field, double vx, double vy) {
		this.field = field;
	    this.vx = vx;

	    this.vy = vy;

	    this.L = 2.0*vx*vy/gravity;

	  }  
	  
	  
	  



	  public double getL() {

	    return this.L;

	  }


}
