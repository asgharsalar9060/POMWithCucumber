package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	//1. By locators:
	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By signInButton = By.id("SubmitLogin");
	private By forgotPwdLink = By.xpath("//a[contains(text(),'Forgot your password?')]");

	//2. constructor of the page:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//3. page actions: behavior of the page
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean doesForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	
	public void enterUsername(String username) {
		driver.findElement(emailId).sendKeys(username);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickOnSignInButton() {
		driver.findElement(signInButton).click();
	}
	
	public AccountPage doLogin(String un, String pwd) {
		System.out.println("login with: " + un + " and " + pwd);
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signInButton).click();
		return new AccountPage(driver);
	}

}
