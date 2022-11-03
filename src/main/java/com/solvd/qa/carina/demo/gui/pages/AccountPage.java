package com.solvd.qa.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends AbstractPage {

    @FindBy(id = "email")
    private ExtendedWebElement emailAddress;

    @FindBy(id = "passwd")
    private ExtendedWebElement password;

    @FindBy(id = "SubmitLogin")
    private ExtendedWebElement submitButton;

    @FindBy(xpath = "//p[contains(text(),'error')]")
    private ExtendedWebElement logInFailed;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void setInputEmailAddress(String inputEmailAddress) {
        setText(emailAddress, inputEmailAddress);
    }

    public void setInputPassword(String inputPassword) {
        setText(password, inputPassword);
    }

    private void setText(ExtendedWebElement element, String text) {
        element.click();
        element.type(text);
        element.sendKeys(Keys.TAB);
    }

    public void submitLogin() {
        submitButton.click();
    }

    public boolean isLogInFailed() {
        return logInFailed.isElementPresent();
    }

}
