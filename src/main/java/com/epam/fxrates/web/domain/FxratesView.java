package com.epam.fxrates.web.domain;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Domain object for FxratesView.
 *
 * Created by Andras_Csipes on 4/11/2017.
 */

@Component
public class FxratesView {

    private List<FxrateView> fxrates;

    public List<FxrateView> getFxrates() {
        return fxrates;
    }

    public void setFxrates(List<FxrateView> fxrates) {
        this.fxrates = fxrates;
    }
}
