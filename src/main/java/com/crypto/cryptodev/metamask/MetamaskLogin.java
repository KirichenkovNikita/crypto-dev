package com.crypto.cryptodev.metamask;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

@Component
public class MetamaskLogin {
    private final Clipboard clipboard;

    @Value("${metamask.sentence}")
    private String metamaskSentence;

    @Value("${metamask.password}")
    private String metamaskPassword;

    @Autowired
    public MetamaskLogin(Clipboard clipboard) {
        this.clipboard = clipboard;
    }

    public void login(WebDriver driver) throws InterruptedException {
        while (true) {
            if (driver.getCurrentUrl().contains("chrome-extension")) break;
        }

        driver.findElement(getBaseXpath("onboarding-import-wallet")).click();
        driver.findElement(getBaseXpath("metametrics-i-agree")).click();

        setClipBoard(metamaskSentence);
        driver.findElement(By.xpath("//*[contains(@id,'word-0')]"))
                .sendKeys(Keys.CONTROL + "v");
        setClipBoard(" ");

        driver.findElement(getBaseXpath("import-srp-confirm")).click();

        driver.findElement(getBaseXpath("create-password-new")).sendKeys(metamaskPassword);
        driver.findElement(getBaseXpath("create-password-confirm")).sendKeys(metamaskPassword);
        driver.findElement(getBaseXpath("create-password-terms")).click();
        driver.findElement(getBaseXpath("create-password-import")).click();

        driver.findElement(getBaseXpath("onboarding-complete-done")).click();
        driver.findElement(getBaseXpath("pin-extension-next")).click();
        driver.findElement(getBaseXpath("pin-extension-done")).click();
        driver.findElement(getBaseXpath("popover-close")).click();
    }

    private void setClipBoard(String value) throws InterruptedException {
        Thread.sleep(20);
        clipboard.setContents(new StringSelection(value), null);
    }

    private By getBaseXpath(String dataId) {
        return By.xpath(String.format("//*[@data-testid='%s']", dataId));
    }
}
