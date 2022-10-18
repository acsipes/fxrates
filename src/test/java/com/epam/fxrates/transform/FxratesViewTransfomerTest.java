package com.epam.fxrates.transform;

import com.epam.fxrates.dal.domain.Fxrate;
import com.epam.fxrates.web.domain.FxrateView;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Teset for FxratesViewTransfomer.
 *
 * Created by Andras_Csipes on 4/11/2017.
 */
public class FxratesViewTransfomerTest {

    private static final String USD = "USD";
    private static final String EUR = "EUR";

    @InjectMocks
    private FxratesViewTransfomer underTest;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void transformShouldReturnFxrateViewPairWhenCalledFxrate() {
        // GIVEN
        Fxrate fxrateTest = new Fxrate();
        fxrateTest.setBaseCurrencyCode(USD);
        fxrateTest.setTargetCurrencyCode(EUR);

        //WHEN
        FxrateView result = underTest.transform(fxrateTest);

        //THEN
        assertEquals(result.getPair(), fxrateTest.getBaseCurrencyCode()+fxrateTest.getTargetCurrencyCode());
    }

    @Test
    public void transformShouldReturnFxrateViewRateWhenCalledFxrate() {
        // GIVEN
        Fxrate fxrateTest = new Fxrate();
        fxrateTest.setRate("1.1");

        //WHEN
        FxrateView result = underTest.transform(fxrateTest);

        //THEN
        assertEquals(result.getPair(), fxrateTest.getBaseCurrencyCode()+fxrateTest.getTargetCurrencyCode());
        assertEquals(result.getRate(), fxrateTest.getRate());
    }

}
