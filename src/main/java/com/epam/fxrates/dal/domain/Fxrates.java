package com.epam.fxrates.dal.domain;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Domain object for Fxrates.
 *
 * Created by Andras_Csipes on 4/11/2017.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "current_version",
        "effective_date",
        "fxrates"
})
public class Fxrates {

    @JsonProperty("current_version")
    private Integer currentVersion;
    @JsonProperty("effective_date")
    private String effectiveDate;
    @JsonProperty("fxrates")
    private List<Fxrate> fxrates = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("current_version")
    public Integer getCurrentVersion() {
        return currentVersion;
    }

    @JsonProperty("current_version")
    public void setCurrentVersion(Integer currentVersion) {
        this.currentVersion = currentVersion;
    }

    @JsonProperty("effective_date")
    public String getEffectiveDate() {
        return effectiveDate;
    }

    @JsonProperty("effective_date")
    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    @JsonProperty("fxrates")
    public List<Fxrate> getFxrates() {
        return fxrates;
    }

    @JsonProperty("fxrates")
    public void setFxrates(List<Fxrate> fxrates) {
        this.fxrates = fxrates;
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
