package com.solvd.qa.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CalculatorBasePage extends AbstractPage {
    public CalculatorBasePage(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isAppLoaded();

    public abstract int calculateThreePlusThree();

    public abstract int calculateTwentyFiveTimesFourPreview();
}
