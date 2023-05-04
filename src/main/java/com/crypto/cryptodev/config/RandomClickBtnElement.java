package com.crypto.cryptodev.config;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public abstract class RandomClickBtnElement implements WebElement {

    @Override
    public void click() {
        // Returns height, width, x and y coordinates referenced element
        WebDriver driver = null;
        String path = "";
        Rectangle res = driver.findElement(By.id(path)).getRect();

        // Rectangle class provides getX,getY, getWidth, getHeight methods

        double randomX = (Math.random()*((res.getWidth())+1)) - res.getWidth() / 2;
        double randomY = (Math.random()*((res.getHeight())+1)) - res.getHeight() / 2;

        WebElement tracker = driver.findElement(By.id(path));
        new Actions(driver)
                .moveToElement(tracker, (int)Math.round(randomX),(int)Math.round(randomY))
                .perform();

    }
}
