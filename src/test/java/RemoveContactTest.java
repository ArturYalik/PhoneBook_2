import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTest extends TestBase{
    @BeforeMethod
    public void preCondition() {
        if (app.getUser().isLogGet()) {
            app.getUser().pause(30);
        } else {
            User data = new User().withEmail("abc@mail.com").withPassword("$Sens1234");
            app.getUser().login(data);
        }
    }

    @Test
    public void removeOneContact(){
        int result = app.getCon().removeOneContact();
        Assert.assertEquals(result,1);
    }
    @Test
    public void romoveAllContacts(){
        app.getCon().removeAllContacts();
    }
}
