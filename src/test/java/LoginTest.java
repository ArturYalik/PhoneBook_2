import manager.TestBase;
import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    WebDriver wd;

//    @BeforeMethod
//    public void init() {
//        wd = new ChromeDriver();
//        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
//
//    }

    @Test
    public void loginTestPositive() {

 //       //open login/reg form
//        WebElement loginBtn = wd.findElement(By.xpath("//a[@href = '/login']"));
//        loginBtn.click();
//        //fill login/reg form
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("Qwerty@gmail.com");
//        WebElement passwordInput = wd.findElement(By.xpath("//input[2]"));
//        passwordInput.click();
//        passwordInput.clear();
//        passwordInput.sendKeys("1699Sens$");
//        //click on Login button
//        wd.findElement(By.xpath("//button[1]")).click();
//        //Assert
//        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        wd.findElement(By.xpath("//a[@href='/add']")).click();
//        Assert.assertTrue(wd.findElement(By.xpath("//a[@href='/add']"))!=null);
        User data = new User().withEmail("abc@mail.com").withPassword("$Sens1234");
        app.getUser().openLoginRegForm();
        app.getUser().fillLoginRegForm(data);
        app.getUser().submitLogin();

        app.getUser().pause(30);
       Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[@href='/add']")));

    }

//    @AfterMethod
//    public void tearDown(){
//        wd.quit();
//    }
}
