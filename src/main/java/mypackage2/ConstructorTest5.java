package mypackage2;

public class ConstructorTest5 extends ConstructorTest4 {

	private int var1;
	private int var2;

	public ConstructorTest5(){
		System.out.println("Default Constructor of ConstructorTest5");
	}

	public ConstructorTest5(int var1) {
		System.out.println("Constructor(int var1) of ConstructorTest5");
		this.var1 = var1;
	}

	public ConstructorTest5(int var1, int var2) {
		this();
		System.out.println("Constructor(int var1) of ConstructorTest5");
		this.var1 = var1;
		this.var2 = var2;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ConstructorTest5(10, 20);
		System.out.println("------------------------------------------------");
		new ConstructorTest5(10);
		System.out.println("------------------------------------------------");
		new ConstructorTest5();
	}

}
