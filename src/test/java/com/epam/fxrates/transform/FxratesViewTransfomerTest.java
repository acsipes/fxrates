package com.epam.fxrates.transform;

import com.epam.fxrates.dal.domain.Fxrate;
import com.epam.fxrates.web.domain.FxrateView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

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

    @Before
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
        Assert.assertEquals(result.getPair(), fxrateTest.getBaseCurrencyCode()+fxrateTest.getTargetCurrencyCode());
    }

    @Test
    public void transformShouldReturnFxrateViewRateWhenCalledFxrate() {
        // GIVEN
        Fxrate fxrateTest = new Fxrate();
        fxrateTest.setRate("1.1");

        //WHEN
        FxrateView result = underTest.transform(fxrateTest);

        //THEN
        Assert.assertEquals(result.getPair(), fxrateTest.getBaseCurrencyCode()+fxrateTest.getTargetCurrencyCode());
        Assert.assertEquals(result.getRate(), fxrateTest.getRate());
    }

}
