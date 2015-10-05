package com.wimduQA;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({LoginTest.class,RegisterTest.class})
public class RunTestSuite {
	public static void main(String[] args) throws Exception {                    
		Result result = JUnitCore.runClasses(RunTestSuite.class);
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
	      System.out.println(result.wasSuccessful());

}
}
