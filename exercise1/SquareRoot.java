package exercise1;

/**
 * 
 * @author b1018008 近藤勝伍
 *
 */
public class SquareRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = (int)(Math.random()*Integer.MAX_VALUE);
		System.out.println(n);
		double sqrt = calcSQRoot(n);
		System.out.println(sqrt);
		System.out.println("=>");
		System.out.println(sqrt*sqrt);
		//System.out.println(calcSQRoot());
	}
	
	public static double calcSQRoot(int s) {
		double x0 = 1.0, x1 = 0.0;
		//x1 = (x0 + s/x0)/2;
		if(s > 0) {
			while(true) {
				x1 = (x0 + s/x0)/2;
				if(x1 == x0) {
					break;
				}else {
					x0 = x1;
				}
				//System.out.println(x1);
			}
		}
		
		return x1;	
	}	

}
