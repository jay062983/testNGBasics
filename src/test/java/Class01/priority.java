package Class01;


import org.testng.annotations.Test;
public class priority {
    @Test (priority=3)
    public void Atest(){
        System.out.println("I am test A");
    }
    @Test (priority=1)
    public void Btest(){
        System.out.println("I am test B");
}
    @Test(priority=2)
    public void Ctest() {
        System.out.println("I am test c");

    }}