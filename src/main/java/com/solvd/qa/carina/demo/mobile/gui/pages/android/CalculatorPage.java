package com.solvd.qa.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.qa.carina.demo.mobile.gui.pages.common.CalculatorBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CalculatorBasePage.class)
public class CalculatorPage extends CalculatorBasePage implements IMobileUtils {

    @FindBy(id = "com.google.android.calculator:id/digit_2")
    private ExtendedWebElement twoBtn;
    @FindBy(id = "com.google.android.calculator:id/digit_3")
    private ExtendedWebElement threeBtn;

    @FindBy(id = "com.google.android.calculator:id/digit_4")
    private ExtendedWebElement fourBtn;

    @FindBy(id = "com.google.android.calculator:id/digit_5")
    private ExtendedWebElement fiveBtn;
    @FindBy(id = "com.google.android.calculator:id/op_add")
    private ExtendedWebElement plusBtn;

    @FindBy(id = "com.google.android.calculator:id/op_mul")
    private ExtendedWebElement multipBtn;

    @FindBy(id = "com.google.android.calculator:id/eq")
    private ExtendedWebElement equalsBtn;

    @FindBy(id = "com.google.android.calculator:id/result_final")
    private ExtendedWebElement resultFinal;

    @FindBy(id = "com.google.android.calculator:id/result_preview")
    private ExtendedWebElement resultPreview;

    @FindBy(id = "com.google.android.calculator:id/clr")
    private ExtendedWebElement clearBtn;

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAppLoaded() {
        return driver.findElements(By.className("android.widget.ImageButton")).size() > 24;
    }

    public int calculateThreePlusThree() {
        threeBtn.click();
        plusBtn.click();
        threeBtn.click();
        equalsBtn.click();
        String resultText = resultFinal.getText();
        clearBtn.click();
        return Integer.parseInt(resultText);
    }

    public int calculateTwentyFiveTimesFourPreview() {
        twoBtn.click();
        fiveBtn.click();
        multipBtn.click();
        fourBtn.click();
        String resultText = resultPreview.getText();
        clearBtn.click();
        return Integer.parseInt(resultText);
    }


}
