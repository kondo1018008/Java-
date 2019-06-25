package selection;
/**
 * 
 * @author b1018008 Shogo Kondo
 *
 */
import java.util.*;

public class Selection {
	static Random  rnd = new Random();
	
	public static int choose(int[] s) {
    // ここにプログラムを作成
		int sum = 0;
		for(int i = 0; i < s.length ; i ++) 
			sum = sum + s[i];
		double k = rnd.nextDouble()*sum;
		int x = s[0];
		int num = 0;
		while(x<k) {
			num++;
			x += s[num];
		}
		return num;
	}
  
	public static void main(String[] args) {
		// TEST1
		int[] p1 = {12, 31, 25, 20, 8, 4};
		for(int i = 0; i < 30; ++i) {
			System.out.print(choose(p1)+" ");
		}
		
		System.out.println();
		
		// TEST2
		int[] p2 = {10, 5};
		for(int i = 0; i < 30; ++i) {
			System.out.print(choose(p2)+" ");
		}
	}
}
