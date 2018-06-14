package com.kenai.br.hades.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.Documented;

@ConfigurationProperties("hadesProperties")
@Configuration
public class HadesProperties {

    private String originAllowed = "http://localhost:8000";
    private final Security security = new Security();

    public static class Security {

        private boolean enalbleHttps;
        public boolean isEnalbleHttps() {
            return enalbleHttps;
        }

        public void setEnalbleHttps(boolean enalbleHttps) {
            this.enalbleHttps = enalbleHttps;
        }
    }

    public String getOriginAllowed() {
        return originAllowed;
    }

    public void setOriginAllowed(String originAllowed) {
        this.originAllowed = originAllowed;
    }

    public Security getSecurity() {
        return security;
    }
}
