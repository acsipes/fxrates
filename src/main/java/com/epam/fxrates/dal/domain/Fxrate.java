package com.epam.fxrates.dal.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Domain object for Fxrate.
 *
 * Created by Andras_Csipes on 4/11/2017.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "base_currency_code",
        "target_currency_code",
        "rate"
})

@Data
public class Fxrate {

    @JsonProperty("base_currency_code")
    private String baseCurrencyCode;
    @JsonProperty("target_currency_code")
    private String targetCurrencyCode;
    @JsonProperty("rate")
    private String rate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("base_currency_code")
    public String getBaseCurrencyCode() {
        return baseCurrencyCode;
    }

    @JsonProperty("base_currency_code")
    public void setBaseCurrencyCode(String baseCurrencyCode) {
        this.baseCurrencyCode = baseCurrencyCode;
    }

    @JsonProperty("target_currency_code")
    public String getTargetCurrencyCode() {
        return targetCurrencyCode;
    }

    @JsonProperty("target_currency_code")
    public void setTargetCurrencyCode(String targetCurrencyCode) {
        this.targetCurrencyCode = targetCurrencyCode;
    }

    @JsonProperty("rate")
    public String getRate() {
        return rate;
    }

    @JsonProperty("rate")
    public void setRate(String rate) {
        this.rate = rate;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
