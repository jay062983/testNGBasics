package Class02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class dataProvider {
    public static WebDriver driver;
    //test Scenario
    // login into website using following credentials
    //1. User nam="Admin
    @DataProvider(name="credentials")
    public Object[][] data(){
        Object[][] loginData={
                {"Admin","1234","Invalid credentials"},
                {"qwerr","Hum@anhram123","Invalid credentials"},
                {" ","humas1234","username cannot be empty"}};

    return loginData;

}

@Test(dataProvider = "credentials")// connect your test case with data provider
public void invalidCredentials(String username,String password,String errormsg){
driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

WebElement error=driver.findElement(By.xpath("//span[@id='spanMessage']"));
String actualError=error.getText();
    Assert.assertEquals(actualError,errormsg);
    }
@BeforeMethod
public void SetupBrowser() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
