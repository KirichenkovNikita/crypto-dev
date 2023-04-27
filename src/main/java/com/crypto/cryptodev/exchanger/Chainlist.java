package com.crypto.cryptodev.exchanger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Chainlist {
    private static final String URL = "https://chainlist.org/";

    public void start(WebDriver driver) throws InterruptedException {
        driver.get(URL);

        driver.findElement(By.xpath("//span[contains(text(),'Include Testnets')]/../../button")).click();
        while (true) {
            if (driver.getWindowHandles().size() == 3) break;
        }
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));
        driver.findElement(By.xpath("//*[@class='button btn--rounded btn-primary']")).click();
        driver.findElement(By.xpath("//*[@data-testid='page-container-footer-next']")).click();

        acceptWeb(tabs, driver, "Optimism");
        acceptWeb(tabs, driver, "Arbitrum One");
        acceptWeb(tabs, driver, "Avalanche C-Chain");
        driver.switchTo().window(tabs.get(1));
    }

    private void acceptWeb(ArrayList<String> tabs, WebDriver driver, String web) throws InterruptedException {
        driver.switchTo().window(tabs.get(1));
        driver.findElement(By.xpath(String.format("//span[contains(text(),'%s')]/../../button",web ))).click();

        while (true) {
            if (driver.getWindowHandles().size() == 3) break;
        }

        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));
        driver.findElement(By.xpath("//*[@class='button btn--rounded btn-primary']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='button btn--rounded btn-primary']")).click();
    }
}
