package testScripts;

import org.testng.annotations.Test;

public class SampleTest4 {
	@Test(groups = {"feature2"})
	public void testOne() {
		System.out.println("I am in testOne");
	}
	@Test(groups = {"feature1"})
	public void testTwo() {
		System.out.println("I am in testTwo");
	}
	@Test(groups = {"feature3"})
	public void testThree() {
		System.out.println("I am in testThree");
	}
	@Test
	public void testFour() {
		System.out.println("I am in testFour");
	}

}
