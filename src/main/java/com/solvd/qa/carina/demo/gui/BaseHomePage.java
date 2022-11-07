package com.solvd.qa.carina.demo.gui;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

abstract public class BaseHomePage extends AbstractPage {
    public BaseHomePage(WebDriver driver) {
        super(driver);
    }
}
