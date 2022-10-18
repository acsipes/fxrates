package com.epam.fxrates.web.domain;

import org.springframework.stereotype.Component;

/**
 * Domain object for FxrateView.
 *
 * * Created by Andras_Csipes on 4/11/2017.
 */

@Component
public class FxrateView {

    private String pair;

    private String rate;

    public String getPair() {
        return pair;
    }

    public void setPair(String pair) {
        this.pair = pair;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
