package com.it.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	@FindBy(xpath = "//input[@name='login']")
	private WebElement inputLogin;
	@FindBy(xpath = "//input[@name='pass']")
    private WebElement inputPassword;
	@FindBy(xpath = "//form[@name='lform']//input[@type='submit']")
	private WebElement btLogin;


public void  login(String name, String password){
    inputLogin.clear();
    inputLogin.sendKeys(name);
    inputPassword.clear();
    inputPassword.sendKeys(password);
    btLogin.click();
}



}
