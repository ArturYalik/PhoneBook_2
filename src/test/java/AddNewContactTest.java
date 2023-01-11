import manager.NGListener;
import manager.ContactData;
import model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(NGListener.class)
public class AddNewContactTest extends TestBase {
    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        if (app.getUser().isLogGet()) {
            app.getUser().pause(3000);
        } else {
            User data = new User().withEmail("abc@mail.com").withPassword("$Sens1234");
            app.getUser().openLoginRegForm();
            app.getUser().fillLoginRegForm(data);
            app.getUser().submitLogin();
            app.getUser().pause(3000);

        }
    }

    @Test(invocationCount = 1,groups = {"positiveGroup","sg_tests"},dataProvider = "regData",dataProviderClass = ContactData.class)
    public void addNewContactTest(User data) {
        app.getCon().openAddContactForm();
        app.getCon().fillContactForm(data);
        app.getCon().susseccAddContactForm();
        Assert.assertTrue(
        app.getUser().getText(By.xpath("//div[@class='contact-item_card__2SOIM'][last()]//h3")).equals(data.getPhone()));
    }
}
