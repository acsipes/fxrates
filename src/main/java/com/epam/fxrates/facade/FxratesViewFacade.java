package com.epam.fxrates.facade;

import com.epam.fxrates.service.FxratesChecker;
import com.epam.fxrates.service.FxratesService;
import com.epam.fxrates.transform.FxratesViewTransfomer;
import com.epam.fxrates.web.domain.FxratesView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * Facade for Fxrates view.
 *
 * Created by Andras_Csipes on 4/11/2017.
 */

@Component
public class FxratesViewFacade {

    @Autowired
    private FxratesService fxratesService;

    @Autowired
    FxratesChecker fxratesChecker;

    @Autowired
    private FxratesViewTransfomer fxratesViewTransfomer;

    public FxratesView getTargetCurrencies(String currency, String currencies) {
        FxratesView fxratesView = new FxratesView();
        if (fxratesChecker.fxratesNotNull(fxratesService.getTargetCurrencies(currency, currencies).getFxrates())) {
            fxratesView.setFxrates(fxratesService.getTargetCurrencies(currency, currencies).getFxrates()
                    .stream()
                    .map(fxratesViewTransfomer::transform)
                    .collect(Collectors.toList()));
        }
        return fxratesView;
    }
}
