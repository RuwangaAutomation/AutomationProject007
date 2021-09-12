package main.java.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/*
Configure the retry count of testcase when it fails.
 */
public class RetryAnalyzer implements IRetryAnalyzer {

    int count =0;
    int reTryCount =1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        while (count<reTryCount){
            count++;
            return true;
        }
        return false;
    }
}
