package com.epam.fxrates.service;

import com.epam.fxrates.dal.domain.Fxrate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for FxratesChecker.
 *
 * Created by Andras_Csipes on 4/11/2017.
 */
public class FxratesCheckerTest {

    private static final String USD = "USD";
    private static final String EUR = "EUR";
    private static final String HUF = "HUF";
    private static final String CHF = "CHF";

    @InjectMocks
    private FxratesChecker underTest;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void fxratesNotNullShouldReturnTRUEWhenCalledExistingFxrateList() {
        // GIVEN
        Fxrate fxrateOne = new Fxrate();
        Fxrate fxrateTwo = new Fxrate();
        Fxrate fxrateThree = new Fxrate();

        fxrateOne.setBaseCurrencyCode(USD);
        fxrateOne.setTargetCurrencyCode(EUR);
        fxrateOne.setRate("1.1");

        fxrateTwo.setBaseCurrencyCode(USD);
        fxrateTwo.setTargetCurrencyCode(HUF);
        fxrateTwo.setRate("2.1");

        fxrateThree.setBaseCurrencyCode(USD);
        fxrateThree.setTargetCurrencyCode(CHF);
        fxrateThree.setRate("1.5");

        List<Fxrate> fxrateList = new ArrayList<>();
        fxrateList.add(fxrateOne);
        fxrateList.add(fxrateTwo);
        fxrateList.add(fxrateThree);
        boolean actual = true;

        //WHEN
        boolean result = underTest.fxratesNotNull(fxrateList);

        //THEN
        assertEquals(result, true);
    }

    @Test
    public void fxratesNotNullShouldReturnFALSEWhenCalledExistingFxrateList() {
        // GIVEN
        List<Fxrate> fxrateList = new ArrayList<>();
        boolean actual = false;

        //WHEN
        boolean result = underTest.fxratesNotNull(fxrateList);

        //THEN
        assertEquals(result, true);
    }
}
