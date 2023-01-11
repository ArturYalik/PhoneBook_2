import manager.NGListener;
import model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(NGListener.class)
public class LoginTest extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        if(app.getUser().isLogGet()){
            app.getUser().logout();
        }
    }
    @Test(groups = {"positiveGroup","sg_tests"})
    public void loginTest(){
        User data = new User().withEmail("abc@mail.com").withPassword("$Sens1234");
        app.getUser().openLoginRegForm();
        app.getUser().fillLoginRegForm(data);
        app.getUser().submitLogin();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[@href='/add']")));
    }

}
