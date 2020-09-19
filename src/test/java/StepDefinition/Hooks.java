package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.CommonUtils;
import utilities.Driver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Hooks {
    WebDriver driver= Driver.getDriver(CommonUtils.getProperty("browser"));

    @Before
    public void setup(){

       driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Before Scenario");


    }
    @After
    public void tearDown(Scenario scenario) throws IOException {
        if(scenario.isFailed()){
          //  CommonUtils.takeScreenshot(driver,"Test Scenario");
            byte[]screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
         scenario.embed(screenshot, "impage/png","Failed part");
        }else{
        //      driver.quit();
        }
    }
}
