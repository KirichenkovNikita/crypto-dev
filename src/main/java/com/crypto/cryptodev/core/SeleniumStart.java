package com.crypto.cryptodev.core;

import com.crypto.cryptodev.exchanger.Chainlist;
import com.crypto.cryptodev.exchanger.StargateFinance;
import com.crypto.cryptodev.metamask.MetamaskLogin;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Slf4j
@Component
public class SeleniumStart implements CommandLineRunner {
    private final WebDriver driver;
    private final MetamaskLogin metamaskLogin;
    private final Chainlist chainlist;

    private final StargateFinance stargateFinance;

    @Autowired
    public SeleniumStart(WebDriver driver, MetamaskLogin metamaskLogin, Chainlist chainlist, StargateFinance stargateFinance) {
        this.driver = driver;
        this.metamaskLogin = metamaskLogin;
        this.chainlist = chainlist;
        this.stargateFinance = stargateFinance;
    }

    @Override
    public void run(String... args) throws Exception {
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        metamaskLogin.login(driver);
        chainlist.start(driver);
        stargateFinance.start(driver);
    }
}
