import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {
    WebDriver wd;
    @BeforeMethod
    public void preCondition(){
        if(isLogGet()){
            logout();
        }
    }

    @Test
    public void RegistrationPositiveTest() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "name" + i + "@gmail.com";
        String password = "1699Sens$";

        openLoginRegForm();
        fillLoginRegForm(email, password);
        submitReg();
        pause(30);
        Assert.assertTrue(isElementPresent(By.xpath("//button")));

    }

    @Test
    public void RegistrationWrongEmailTest() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "name" + i + "@gmail,com";
        String password = "1699Sens$";

        openLoginRegForm();
        fillLoginRegForm(email, password);
        submitReg();
        pause(30);
        Assert.assertFalse(isElementPresent(By.xpath("//button")));

    }
}
