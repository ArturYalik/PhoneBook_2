package manager;

import model.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUse extends HelperBase {



    public HelperUse(WebDriver wd) {
        super(wd);
    }
    public void openLoginRegForm() {
        click(By.xpath("//a[@href = '/login']"));
    }

    public void fillLoginRegForm(String email, String password) {
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password);
    }
    public void fillLoginRegForm(User data) {
        type(By.xpath("//input[1]"), data.getEmail());
        type(By.xpath("//input[2]"), data.getPassword());
    }


    public void submitLogin() {
        click(By.xpath("//button[1]"));
    }

    public void submitReg() {
        click(By.xpath("//button[2]"));
    }

    public boolean isLogGet() {
        return isElementPresent(By.xpath("//a[@href='/add']"));
    }

    public void logout() {
        click(By.xpath("//button"));
    }

    public void login(User data){
        openLoginRegForm();
        fillLoginRegForm(data);
        submitLogin();
        pause(3000);
    }

    public boolean isAlertPresent() {
       Alert alert = new WebDriverWait(wd,18).until(ExpectedConditions.alertIsPresent());
        if(alert == null){
            return false;
        }else {
            wd.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();// for OK button
            //alert.dismiss() for Cancel button
            //alert.sendKeys() for input data
            return true;
        }
    }
    public boolean isErrorMessageInFormat(){
        Alert alert = new WebDriverWait(wd, 10)
                .until(ExpectedConditions.alertIsPresent());
        String errorMessage ="Wrong email or password";
        return alert.getText().contains(errorMessage);
    }
}
