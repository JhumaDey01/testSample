package parallelScripts;

import org.testng.annotations.Test;

public class SampleTest2 {
	@Test
	public void testOne() {
		long id = Thread.currentThread().getId();
		System.out.println("test21 I am in testTwo..."+id);
	}
	@Test
	public void testTwo() {
		long id = Thread.currentThread().getId();
		System.out.println("test22 I am in testTwo..."+id);
	}
	@Test
	public void testThree() {
		long id = Thread.currentThread().getId();
		System.out.println("test23 I am in testTwo..."+id);
	}
	@Test(invocationCount = 4, threadPoolSize = 3, timeOut = 2000)
	public void testFour() {
		long id = Thread.currentThread().getId();
		System.out.println("test24 I am in testTwo...."+id);
	}

}
