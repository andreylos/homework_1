package test.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int count = 1;
    private final int max = 2;


    @Override
    public boolean retry(ITestResult iTestResult) {
        if (count < max) {
            count++;
            return true;
        }
    return false;
    }
}
