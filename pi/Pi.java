package pi;

import java.util.Random;

/**
 * 
 * @author b1018008 Shogo Kondo
 *
 */

public class Pi {
	static Random  rnd = new Random();
	
	public static double calc (int n) {
		double p = 0.0;
		// ここに，πの近似値を求めるプログラムを記述．結果はpに入れる．
		double [] x  = new double[n];
		double [] y  = new double[n];
		for( int i = 0 ; i < n ; i++ ) {
			x[i] = rnd.nextDouble();
			y[i] = rnd.nextDouble();
		}
		int num = 0;
		for(int i = 0; i < n; i++ ) {
			double d = Math.sqrt(x[i]*x[i] + y[i]*y[i]);
			if(d < 1) {
				num ++;
			}		
		}
		double s = 4.00*num/n;
		p = s/1.0*1.0;
		
		// 「n個」の砂粒をまくものとする．
		// 0から1未満の乱数は，「rnd.nextDouble()」とすれば得られる

		return p;
	}
	
	// n=100回と10万回について，近似実数値を表示
	public static void main(String[] args) {
		System.out.println( calc(100) );
		System.out.println( calc(100000) );
	}
}
