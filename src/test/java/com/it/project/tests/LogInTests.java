package com.it.project.tests;

import com.it.project.helpers.CommonHelper;
import com.it.project.pages.BasePage;
import com.it.project.pages.LoginPage;
import com.it.project.users.UserFactory;
import com.it.project.utils.Utils;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LogInTests extends BaseTest {
    @AfterTest
    public void afterTest() {
        app.common.close();
    }

    @Test(priority = 1)
    public void validLogIn() throws InterruptedException {

        app.login.login(validUser);
        Assert.assertEquals(app.login.getUserName(), validUser.userName);
        app.login.logOut();
    }

    @Test(priority = 2)
    public void invalidLogInEmail() throws InterruptedException {
        app.login.incorrectLogin();
        Assert.assertEquals(app.login.modalUserNotFound.getText(), "User not found");

    }

    @Test(priority = 3)
    public void invalidLogInPassword() {
        app.login.incorrectLoginWrongPassword(validUser.email);
        Assert.assertEquals(app.login.modalUserNotFound.getText(), "Please check your credentials.");

    }

    @Test(priority = 4)
    public void loginByFacebook() throws InterruptedException {
        app.login.facebookLogin(validUser.facebookPhone, validUser.facebookPassword);

    }

//    @Test(priority = 5)
//    public void loginByGoogle() throws InterruptedException {
//        app.login.googleLogin(validUser.gmailEmail, validUser.password);
//        Assert.assertEquals(app.login.getUserName(), validUser.userName);
//    }


}