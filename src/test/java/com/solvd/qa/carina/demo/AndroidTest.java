package com.solvd.qa.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.solvd.qa.carina.demo.mobile.gui.pages.android.CalculatorPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AndroidTest implements IAbstractTest, IMobileUtils {

    @Test
    public void calculateSum() {
        CalculatorPage calculatorPage = new CalculatorPage(getDriver());
        Assert.assertTrue(calculatorPage.isThreeLoaded(), "Button Three is not loaded in calculator");
        Assert.assertEquals(calculatorPage.calculateThreePlusThree(), 6, "Error in sum");
    }

    @Test
    public void calculateMultiplication() {
        CalculatorPage calculatorPage = new CalculatorPage(getDriver());
        Assert.assertEquals(calculatorPage.calculateTwentyFiveTimesFourPreview(), 100, "Error in multiplication");
    }

}
