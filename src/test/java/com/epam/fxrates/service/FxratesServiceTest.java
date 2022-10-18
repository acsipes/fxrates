package com.epam.fxrates.service;

import com.epam.fxrates.dal.FxrswebserviceUriBuilder;
import com.epam.fxrates.dal.UsdRatesDao;
import com.epam.fxrates.dal.domain.Fxrate;
import com.epam.fxrates.dal.domain.Fxrates;
import com.epam.fxrates.properties.ApplicationProperties;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Test For FxratesService.
 *
 * Created by Andras_Csipes on 4/11/2017.
 */

public class FxratesServiceTest {

    private static final String USD = "USD";
    private static final String UsD = "UsD";
    private static final String EUR = "EUR";
    private static final String HUF = "HUF";
    private static final String CHF = "CHF";
    private static final String EUR_HUF_CHF = "EUR,HUF,CHF";
    private static final String EUr_huf_cHF = "EUr,huf,cHF";
    private static final String CURRENCY_SEPARATOR = ",";

    @InjectMocks
    private FxratesService underTest;

    @Mock
    private UsdRatesDao usdRatesDao;

    @Mock
    private ApplicationProperties applicationProperties;

    @Mock
    FxrswebserviceUriBuilder fxrswebserviceUriBuilder;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Ignore
    @Test
    public void getTargetCurrenciesShouldReturnFxratesWhenCalledRespponseEntity() {
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

        Fxrates testFxrates = new Fxrates();
        testFxrates.setFxrates(fxrateList);
        BDDMockito.given(usdRatesDao.getJsonReviews(Mockito.anyString(), Mockito.any())).willReturn(testFxrates);
        BDDMockito.given(fxrswebserviceUriBuilder.getFxrateJsonResponse(Mockito.anyString())).willReturn(testFxrates);
        BDDMockito.given(applicationProperties.getCurrenciesSeparator()).willReturn(CURRENCY_SEPARATOR);

        //WHEN
        Fxrates resultFxrates = underTest.getTargetCurrencies(USD, EUR_HUF_CHF);

        //THEN
        Assert.assertEquals(resultFxrates, testFxrates);
    }

    @Ignore
    @Test
    public void getTargetCurrenciesShouldReturnFxratesWhenCalledMixturedCurrencies() {
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

        Fxrates testFxrates = new Fxrates();
        testFxrates.setFxrates(fxrateList);

        BDDMockito.given(usdRatesDao.getJsonReviews(Mockito.anyString(), Mockito.any())).willReturn(testFxrates);
        //        BDDMockito.given(fxrswebserviceUriBuilder.getFxrateJsonResponse(Mockito.anyString())).willReturn(testFxrates);
        BDDMockito.given(applicationProperties.getCurrenciesSeparator()).willReturn(CURRENCY_SEPARATOR);

        //WHEN
        Fxrates resultFxrates = underTest.getTargetCurrencies(UsD, EUr_huf_cHF);

        //THEN
        Assert.assertEquals(resultFxrates, testFxrates);
    }
}