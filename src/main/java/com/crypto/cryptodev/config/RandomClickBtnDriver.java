package com.crypto.cryptodev.config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RandomClickBtnDriver extends ChromeDriver {
    public RandomClickBtnDriver(ChromeOptions options) {
        super(options);
    }

    @Override
    public WebElement findElement(By locator) {
        return super.findElement(locator);
    }
}
