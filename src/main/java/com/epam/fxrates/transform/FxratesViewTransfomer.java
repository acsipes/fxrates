package com.epam.fxrates.transform;

import com.epam.fxrates.dal.domain.Fxrate;
import com.epam.fxrates.web.domain.FxrateView;
import org.springframework.stereotype.Component;

/**
 * A class transform from Fxrates to FxratesView.
 *
 * Created by Andras_Csipes on 4/11/2017.
 */

@Component
public class FxratesViewTransfomer {

    public FxrateView transform(Fxrate fxrate) {
        FxrateView fxrateView = new FxrateView();
        fxrateView.setPair(fxrate.getBaseCurrencyCode() + fxrate.getTargetCurrencyCode());
        fxrateView.setRate(fxrate.getRate());
        return fxrateView;
    }
}
