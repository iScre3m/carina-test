package com.solvd.qa.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.qa.carina.demo.gui.pages.AccountPage;
import com.solvd.qa.carina.demo.gui.pages.ContactUsPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FooterStore extends AbstractUIObject {

    @FindBy(xpath = "//a[@title='Contact us']")
    private ExtendedWebElement contactUs;

    @FindBy(css = "[title='Manage my customer account']")
    private ExtendedWebElement myAccount;

    public FooterStore(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ContactUsPage openContactUsPage() {
        contactUs.click();
        return new ContactUsPage(driver);
    }

    public AccountPage openAccountPage() {
        myAccount.click();
        return new AccountPage(driver);
    }

}
