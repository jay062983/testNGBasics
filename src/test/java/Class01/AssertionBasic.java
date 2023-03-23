package Class01;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AssertionBasic {
    public static WebDriver driver;


    @BeforeMethod
    public  void SetupBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
                driver.manage().window().maximize();
     //   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    //    post-condition--> to  close the browser
   @AfterMethod
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    //    testcase
//    enter the username :Admin
//    enter the password :abracadbara
//    click login button
//    verify that the message invalid credentials is displayed
    @Test
    public void invalidCredentials(){

        WebElement username=driver.findElement(By.xpath("//input[@id='txtUsername']"));
               username.sendKeys("alpaalpa");
               WebElement password=driver.findElement(By.xpath("//input[@id='txtPassword']"));
               password.sendKeys("wrongpassword");
        WebElement loginBtn=driver.findElement(By.xpath("//input[@id='btnLogin']"));
       loginBtn.click();
       WebElement error=driver.findElement(By.xpath("//span[text()='Invalid credentials']"));
       String errorMsg=error.getText();
       String expectedError="Invalid credentials";
      Assert.assertEquals(expectedError,errorMsg);
       //      password text box is displayed
      boolean pswrdDisplayed = password.isDisplayed();
//        verify that the text box is displayed
       Assert.assertTrue(pswrdDisplayed);
    }
}
