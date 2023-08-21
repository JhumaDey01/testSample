package testScripts;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	
	private  int retrycount = 0;
	private static final int maxRetryCountn = 3 ;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(!result.isSuccess()) {
			retrycount++;
			return true;
		}
		
		return false;
	}

}
