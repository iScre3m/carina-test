package com.solvd.qa.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.solvd.qa.carina.demo.gui.components.FooterStore;
import com.solvd.qa.carina.demo.gui.pages.ContactUsPage;
import com.solvd.qa.carina.demo.gui.pages.StoreHomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebAutomationTest implements IAbstractTest {
    By tShirtLocator = By.xpath("//a[text()='T-shirts']");
    By textShirtLocator = By.xpath("//p[text()='shapes and style of our collection!']");

    @Test()
    @TestPriority(Priority.P1)
    public void homePageLoad() {
        StoreHomePage homePage = new StoreHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }

    @Test
    @TestPriority(Priority.P2)
    public void contactCustomerService() {
        StoreHomePage homePage = new StoreHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        FooterStore footerStore = homePage.getFooterStore();

        ContactUsPage contactUsPage = footerStore.openContactUsPage();
        String title = contactUsPage.getTitle();
        Assert.assertEquals(title, "Contact us - My Store", "Contact Us page didn't load correctly");

        String inputEmailAddress = "nahuel_1.5@outlook.com";
        contactUsPage.setInputEmailAddress(inputEmailAddress);
        String displayedText = contactUsPage.getInputEmailAddress();
        Assert.assertEquals(displayedText, inputEmailAddress, "Unable to verify email address inserted");

        String customerServiceSubject = "Customer service";
        contactUsPage.selectSubject(customerServiceSubject);
        String subjectSelected = contactUsPage.getSelectedSubject();
        Assert.assertEquals(subjectSelected, customerServiceSubject, "Unable to select Customer service option");

        String message = "Hello i need to make some orders but it doesn't work.";
        contactUsPage.setMessageBox(message);

        contactUsPage.submitMessage();

        boolean messageSentSuccessfully = contactUsPage.isMessageSentSuccessfully();
        Assert.assertTrue(messageSentSuccessfully);
    }

    @Test
    @TestPriority(Priority.P2)
    public void logIn() {
        StoreHomePage homePage = new StoreHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        FooterStore footerStore = homePage.getFooterStore();


    }

}
