package com.solvd.qa.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.solvd.qa.carina.demo.mobile.gui.pages.common.CalculatorBasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AndroidTest implements IAbstractTest {

    @Test()
    @TestPriority(Priority.P1)
    public void appLoad() {
        CalculatorBasePage calculatorPage = initPage(getDriver(), CalculatorBasePage.class);
        Assert.assertTrue(calculatorPage.isAppLoaded(), "The calculator didn't load the 25 buttons");
    }

    @Test
    @TestPriority(Priority.P2)
    public void calculateSum() {
        CalculatorBasePage calculatorPage = initPage(getDriver(), CalculatorBasePage.class);
        Assert.assertTrue(calculatorPage.isAppLoaded(), "The calculator didn't load the 25 buttons");
        Assert.assertEquals(calculatorPage.calculateThreePlusThree(), 6, "Error in sum");
    }

    @Test
    @TestPriority(Priority.P3)
    public void calculateMultiplication() {
        CalculatorBasePage calculatorPage = initPage(getDriver(), CalculatorBasePage.class);
        Assert.assertTrue(calculatorPage.isAppLoaded(), "The calculator didn't load the 25 buttons");
        Assert.assertEquals(calculatorPage.calculateTwentyFiveTimesFourPreview(), 100, "Error in multiplication");
    }

}
