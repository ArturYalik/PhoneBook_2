import manager.NGListener;
import model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(NGListener.class)
public class RegistrationTest extends TestBase {
    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        if(app.getUser().isLogGet()){
            app.getUser().logout();
        }
    }

    @Test(groups = {"positiveGroup","sg_tests"})
    public void RegistrationPositiveTest() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User data = new User().withEmail("name" + i + "@gmail.com").withPassword("1699Sens$");
        logger.info("PositiveRegistrationTest with email: " + data.getEmail() +" password:"+data.getPassword());

        app.getUser().openLoginRegForm();
        app.getUser().fillLoginRegForm(data);
        app.getUser().submitReg();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));

    }

}
