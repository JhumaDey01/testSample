package parallelScripts;

import org.testng.annotations.Test;

public class SampleTest4 {
	@Test
	public void testOne() {
		long id = Thread.currentThread().getId();
		System.out.println("test41 I am in testFour..."+id);
	}
	@Test
	public void testTwo() {
		long id = Thread.currentThread().getId();
		System.out.println("test42 I am in testFour..."+id);
	}
	@Test
	public void testThree() {
		long id = Thread.currentThread().getId();
		System.out.println("test43 I am in testFour..."+id);
	}
	@Test
	public void testFour() {
		long id = Thread.currentThread().getId();
		System.out.println("test44 I am in testFour...."+id);
	}


}
