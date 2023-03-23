package Class01;
import org.testng.annotations.Test;
public class dependsOn {
    @Test
    public void Login(){
        System.out.println("I  am here");
     //   System.out.println(6/0); if login fails Dashboardverfication does not execute
        //because we are using dependsOnMethod
    }
    @Test (dependsOnMethods = {"Login"})
    public void DashBoardverification(){
        System.out.println("After login I ma verifying dashboard");

    }

}
