/**
 *
 */
package exercise3d;



/**
 * @author b1018008 Shogo Kondo
 *
 */
public class Circle {

	private String name = "no_name";    //   円の名称
	private int x = 0;                             //   円の中心位置 x
	private int y = 0;                             //   円の中心位置 y
	private double r = 1.0;                    //   円の半径
	//private double z;

	/*
	 *   コンストラクタ
	 *   TODO: 課題3-1で指定されたコンストラクタを実装する
	 */
	
	public Circle(String name, int x, int y, double r) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.r = r;
		//this.z = area(r);
	}
	public Circle() {
		//this.z = area(r);
	}

	/*
	 * インスタンスメソッド（ゲッターとセッター）
	 * TODO: 課題3-0で指定されたメソッドを実装する
	 */
	
	public String getName() {
		return this.name;
	}

	public int getX() { return this.x; }
	
	public int getY() {
		return this.y;
	}
	
	public double getR() {
		return this.r;
	}

	public void setName(String name) { this.name = name; }
	
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setR(double r) {
		this.r = r;
	}


	/*
	 * インスタンスメソッド（その他）
	 * TODO: 課題3-2で指定されたメソッドを実装する
	 */

	public boolean isAligned(Circle c) {
		if(c.x == this.x || c.y == this.y) {
				return true;
		}else{
				return false;
		}
	}
	public void adjust(Circle c){
		this.x = c.x;
		this.y = c.y;
		this.r = c.r;
	}

	
	public String toString() {
		return "Circle <" + name + ">: Position (" + x + "," + y + ") Radius " + r;
	}
	
	public double area() {
		return this.r*this.r*Math.PI;
	}
	public void expand(double j) {
		this.r = this.r*j;
	}
	

	/*
	 * クラスメソッド
	 * TODO: 課題3-3で指定されたメソッドを実装する
	 */
	
	public static double distance(Circle c1,Circle c2) {
		return Math.sqrt(((double)c1.x-(double)c2.x)*((double)c1.x-(double)c2.x)+((double)c1.y-(double)c2.y)*((double)c1.y-(double)c2.y));
	}
	public static boolean isClose(Circle c1, Circle c2) {
		double r = c1.r + c2.r;
		double d = distance(c1,c2);
		double z = Math.sqrt((c1.r - c2.r)*(c1.r - c2.r));
		if(d > r || d < z) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//   コンストラクタとインスタンスメソッド（ゲッターとセッター）の動作確認
		Circle c1 = new Circle();
		System.out.println(c1.toString());
		
		/*
		 *   これ以降は必要に応じてコメントを外して利用する
		 */
		//  課題3-0 チェック用
		
		c1.setName("c1");
		c1.setXY(1, 1);
		c1.setR(1.5);
		System.out.println(c1.toString());
		

		//  課題3-1 チェック用
		
		Circle c2 = new Circle("c2", 5, 3, 2.0);
		System.out.println(c2.toString());
		

		//   インスタンスメソッド（その他）の動作確認
		//   課題3-2(1) チェック用
		
		c1.expand(1.1);
		System.out.println(c1.toString());
		System.out.println("Area of Circle <" + c1.getName() + "> is " + c1.area());
		

		//   課題3-2(2) チェック用
		
		c1.adjust(c2);
		System.out.println(c1.toString());
		c2.expand(1.5);
        System.out.println(c2.toString());

        System.out.print("Circle <" + c1.getName() + "> is ");
		if (!c1.isAligned(c2)) { System.out.print(" not");	}
		System.out.println(" aligned Circle <" + c2.getName() + ">");

		c2.setXY(4, 1);
		System.out.println(c2.toString());
		System.out.print("Circle <" + c2.getName() + "> is ");
		if (!c2.isAligned(c1)) { System.out.print(" not");	}
		System.out.println(" aligned Circle <" + c1.getName() + ">");
		

		//   クラスメソッドの動作確認
		//  課題3-3 (1) チェック用
		
 		System.out.println("Distance  of <" + c1.getName() + "> and <" + c2.getName() + "> is " + Circle.distance(c1, c2));
		

		//  課題3-3(2) チェック用
 		
		System.out.print("Circle <" + c1.getName() + "> and <" + c2.getName() + "> are ");
		if (Circle.isClose(c1, c2)) {
			System.out.println("closed");
		} else {
			System.out.println("separated");
		}

		c1.expand(0.3);
		c2.setR(1.2);
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.print("Circle <" + c1.getName() + "> and <" + c2.getName() + "> are ");
		if (Circle.isClose(c1, c2)) {
			System.out.println("closed");
		} else {
			System.out.println("separated");
		}
		
	}

}
