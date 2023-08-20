package parallelScripts;

import org.testng.annotations.Test;

public class SampleTest3 {
	@Test
	public void testOne() {
		long id = Thread.currentThread().getId();
		System.out.println("test31 I am in testThree..."+id);
	}
	@Test
	public void testTwo() {
		long id = Thread.currentThread().getId();
		System.out.println("test32 I am in testThree..."+id);
	}
	@Test
	public void testThree() {
		long id = Thread.currentThread().getId();
		System.out.println("test33 I am in testThree..."+id);
	}
	@Test
	public void testFour() {
		long id = Thread.currentThread().getId();
		System.out.println("test34 I am in testThree...."+id);
	}

}
