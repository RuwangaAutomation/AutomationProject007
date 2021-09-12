package main.java.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;
import main.java.Base.BaseConfigurations;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class SuitListener implements ITestListener, IAnnotationTransformer {

    //Takes screenshot on FAILURE of testcase and copy to the screenshots folder
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        String fileName = System.getProperty("user.dir")+ File.separator+"screenshots"+File.separator+iTestResult.getMethod().getMethodName();
        File screenshot = ((TakesScreenshot) BaseConfigurations.driver).getScreenshotAs(OutputType.FILE);

        try{
            FileUtils.copyFile(screenshot,new File(fileName+".png"));
        }catch (IOException exception){
            exception.printStackTrace();
        }

    }

    //Call the retry analyzer inorder to retry the testcase
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }
}
