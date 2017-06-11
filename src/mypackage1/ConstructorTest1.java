package mypackage1;

public class ConstructorTest1 {
	final int test;
	protected ConstructorTest1() {
		this(0);
	}
	
	protected ConstructorTest1(int test) {
		this.test = test;
	}
	
	public void testFinal(final int test1) {
	}

	public static void main(String[] args) {
		final int test2;
		test2 = 0;
	}

}
