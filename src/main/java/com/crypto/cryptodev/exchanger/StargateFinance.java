package com.crypto.cryptodev.exchanger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Component
public class StargateFinance {
    private static final String URL = "https://stargate.finance/transfer";

    public void start(WebDriver driver) throws InterruptedException {
        driver.get(URL);
        driver.findElement(By.xpath("//*[@id='From-input-network']")).click();
        driver.findElement(By.xpath("//button[count(div) = 2]/div[contains(text(),'Ethereum')]/..")).click();

        driver.findElement(By.xpath("//*[@id='From-input-token']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[count(div) = 3]/div/div[contains(text(),'ETH')]/../div[contains(text(),'Ethereum')]/../..")).click();

        driver.findElement(By.xpath("//*[@id='To-input-network']")).click();
        Thread.sleep(1000);
        driver.findElements(By.xpath("//button[count(div) = 2]/div[contains(text(),'Optimism')]/..")).get(1).click();

        driver.findElement(By.xpath("//*[@name='amount']")).sendKeys("0.0228");

        driver.findElement(By.xpath("//span[contains(text(),'Connect Wallet')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[contains(text(),'Metamask')]")).click();
    }
}
