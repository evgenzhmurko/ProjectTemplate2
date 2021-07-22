package com.it.project.pages;

import com.github.javafaker.Faker;
import com.it.project.common.Constants;
import com.it.project.driver.MyDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//button[@class='Button_button__1M_jL Button_size-xSmall__3l0ss Button_color-harvest-gold__1OHpp']")
    public WebElement loginModalOpener;
    @FindBy(xpath = "//input[@id='email-text-field']")
    public WebElement inputLogin;
    @FindBy(xpath = "//input[@id='password-text-field']")
    public WebElement inputPassword;
    @FindBy(xpath = "//button[@class='Button_button__1M_jL Button_size-large__1stCx Button_color-black__1hQ2Q SignInByEmailForm_formSubmit__ajTBP']")
    public WebElement btLogin;
    @FindBy(xpath = "//span[@class='LoggedUserMenu_userName__3GU8c']")
    public WebElement accountLink;
    @FindBy(xpath = "//p[@class='NotificationModal_description__1TFc5']")
    public WebElement modalUserNotFound;
    @FindBy(xpath = "//form[@aria-label='Login with social accounts']//button[2]")
    public WebElement modalFacebookLoginOpener;
    @FindBy(xpath = "//input[@class='inputtext _55r1 inputtext inputtext']")
    public WebElement modalFacebookLoginName;
    @FindBy(xpath = "//input[@id='pass']")
    public WebElement modalFacebookLoginPass;
    @FindBy(xpath = "//label[@class='uiButton uiButtonConfirm uiButtonLarge']/input")
    public WebElement modalFacebookLoginButton;
    @FindBy(xpath = "//form[@aria-label='Login with social accounts']//button[1]")
    public WebElement modalGoogleLoginOpener;
    @FindBy(xpath = "//input[@class='whsOnd zHQkBf']")
    public WebElement modalGoogleLoginEmail;
    @FindBy(xpath = "//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qIypjc TrZEUc lw1w4b']")
    public WebElement modalGoogleLoginNextButton2;
    @FindBy(xpath = "//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qIypjc TrZEUc lw1w4b']")
    public WebElement modalGoogleLoginNextButton;
    @FindBy(xpath = "//div[@class='Xb9hP']/input")
    public WebElement modalGoogleLoginPassword;
    @FindBy(xpath = "//div[@id='selectionc0']")
    public WebElement modalGoogleShowPassword;
    @FindBy(xpath = "//button[@class='LoggedUserMenu_logoutButton__1EE9D']")
    public WebElement logOutButtonHeader;

    public void login(String email, String password ) throws InterruptedException {
        driver.get(Constants.BASE_URL);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        loginModalOpener.click();
        wait.until(ExpectedConditions.visibilityOf(inputLogin)).clear();
        inputLogin.clear();
        inputLogin.sendKeys(email);
        inputPassword.clear();
        inputPassword.sendKeys(password);
        btLogin.click();
        wait.until(ExpectedConditions.visibilityOf(accountLink)).isDisplayed();


    }
    public String getUserName() {
        return accountLink.getText();
    }

public void incorrectLogin (){
    driver.get(Constants.BASE_URL);
    Faker faker = new Faker();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    loginModalOpener.click();
    wait.until(ExpectedConditions.visibilityOf(inputLogin)).clear();
    inputLogin.clear();
    inputLogin.sendKeys(faker.internet().safeEmailAddress());
    inputPassword.clear();
    inputPassword.sendKeys(faker.internet().password());
    btLogin.click();
    wait.until(ExpectedConditions.visibilityOf(modalUserNotFound)).isDisplayed();

}
    public void incorrectLoginWrongPassword (String email){
        driver.get(Constants.BASE_URL);
        Faker faker = new Faker();
        WebDriverWait wait = new WebDriverWait(BasePage.driver, 10);
        loginModalOpener.click();
        wait.until(ExpectedConditions.visibilityOf(inputLogin)).clear();
        inputLogin.clear();
        inputLogin.sendKeys(email);
        inputPassword.clear();
        inputPassword.sendKeys(faker.internet().password());
        btLogin.click();
        wait.until(ExpectedConditions.visibilityOf(modalUserNotFound)).isDisplayed();

    }

    public void facebookLogin (String facebookPhone, String facebookPassword) throws InterruptedException {
        driver.get(Constants.BASE_URL);
        loginModalOpener.click();
        modalFacebookLoginOpener.click();
        String parentHandle = driver.getWindowHandle();
        Thread.sleep(5000);
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        modalFacebookLoginName.sendKeys(facebookPhone);
        modalFacebookLoginPass.sendKeys(facebookPassword);
        Thread.sleep(5000);

        modalFacebookLoginButton.click();
        Thread.sleep(5000);

        driver.switchTo().window(parentHandle);

        Thread.sleep(5000);

    }
    public void googleLogin(String gmailEmail, String password) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(BasePage.driver, 10);
        loginModalOpener.click();
        modalGoogleLoginOpener.click();
        String parentHandle = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        modalGoogleLoginEmail.sendKeys(gmailEmail);
        modalGoogleLoginNextButton.click();

        wait.wait(10);
        modalGoogleLoginPassword.sendKeys(password);
        modalGoogleLoginNextButton.click();
        Thread.sleep(5000);


        driver.switchTo().window(parentHandle);

    }
    public void logOut(){
        accountLink.click();
        logOutButtonHeader.click();
    }
}
