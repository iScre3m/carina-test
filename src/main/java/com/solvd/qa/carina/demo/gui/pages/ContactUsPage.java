package com.solvd.qa.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends AbstractPage {

    @FindBy(id = "email")
    private ExtendedWebElement emailAddress;

    @FindBy(id = "id_contact")
    private ExtendedWebElement subjectSelector;

    @FindBy(css = "textarea[id='message']")
    private ExtendedWebElement messageBox;

    @FindBy(className = "alert-success")
    private ExtendedWebElement messageSuccessfullySent;

    @FindBy(id = "submitMessage")
    private ExtendedWebElement submitButton;

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public void setInputEmailAddress(String inputEmailAddress) {
        setText(emailAddress, inputEmailAddress);
    }

    private void setText(ExtendedWebElement element, String text) {
        element.click();
        element.type(text);
        element.sendKeys(Keys.TAB);
    }

    public String getInputEmailAddress() {
        return emailAddress.getAttribute("value");
    }

    public void selectSubject(String subject) {
        subjectSelector.select(subject);
    }

    public String getSelectedSubject() {
        return subjectSelector.getSelectedValue();
    }

    public void setMessageBox(String inputMessage) {
        setText(messageBox, inputMessage);
    }

    public boolean isMessageSentSuccessfully() {
        return messageSuccessfullySent.isElementPresent(1);
    }

    public void submitMessage() {
        submitButton.click();
    }
}
