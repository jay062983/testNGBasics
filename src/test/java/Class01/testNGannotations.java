package Class01;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class testNGannotations {
    @BeforeMethod
    public  void beforeMethods(){
        System.out.println("I am before Method");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("I am after Method");
    }

@Test
    public void aFirstTestCase(){
    System.out.println("I am the first test case");
}
@Test
    public void bSecondTestcase(){
    System.out.println("I am the second test case");
}
@Test
    public void cThirdTestCase(){
    System.out.println("I am thirdTest Case");
}
}
