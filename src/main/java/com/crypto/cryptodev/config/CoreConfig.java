package com.crypto.cryptodev.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

@Configuration
public class CoreConfig {
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Clipboard clipboard() {
        return Toolkit.getDefaultToolkit().getSystemClipboard();
    }
}
