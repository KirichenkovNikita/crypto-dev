package com.crypto.cryptodev.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.time.Duration;

@Configuration
public class SeleniumConfig {
    @Value("${selenium.driver.path}")
    private String driverPath;

    @Value("${selenium.metamask.extension.path}")
    private String metamaskPath;

    @Bean
    public WebDriver webDriver() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        System.setProperty("java.awt.headless", "false");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addExtensions (new File(metamaskPath));
        WebDriver driver = new RandomClickBtnDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        return driver;
    }
}
