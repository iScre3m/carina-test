package com.solvd.qa.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.qa.carina.demo.gui.components.FooterStore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class StoreHomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[@id='header_logo']//img[@src='http://automationpractice.com/img/logo.jpg']")
    private ExtendedWebElement storeLogo;

    @FindBy(id = "editorial_image_legend")
    private ExtendedWebElement editorialImageLegend;

    @FindBy(id = "footer")
    private FooterStore footerStore;

    public StoreHomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL_AND_ELEMENT);
        setUiLoadedMarker(editorialImageLegend);
        setUiLoadedMarker(storeLogo);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public FooterStore getFooterStore() {
        return footerStore;
    }
}
