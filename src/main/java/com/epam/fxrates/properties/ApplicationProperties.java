package com.epam.fxrates.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * This is for classified properties.
 *
 * Created by Andras_Csipes on 4/11/2017.
 */

@Component
public class ApplicationProperties {

    @Value("${content.txype}")
    private String contentType;

    @Value("${core.url}")
    private String coreUrl;

    @Value("${red}")
    private String red;

    @Value("${reset}")
    private String reset;

    @Value("${currencies.separator}")
    private String currenciesSeparator;

    @Value("${no.currencies}")
    private String noCurrencies;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getCoreUrl() {
        return coreUrl;
    }

    public void setCoreUrl(String coreUrl) {
        this.coreUrl = coreUrl;
    }

    public String getRed() {
        return red;
    }

    public void setRed(String red) {
        this.red = red;
    }

    public String getReset() {
        return reset;
    }

    public void setReset(String reset) {
        this.reset = reset;
    }

    public String getCurrenciesSeparator() {
        return currenciesSeparator;
    }

    public void setCurrenciesSeparator(String currenciesSeparator) {
        this.currenciesSeparator = currenciesSeparator;
    }

    public String getNoCurrencies() {
        return noCurrencies;
    }

    public void setNoCurrencies(String noCurrencies) {
        this.noCurrencies = noCurrencies;
    }
}
