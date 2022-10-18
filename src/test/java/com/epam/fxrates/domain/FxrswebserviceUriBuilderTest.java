package com.epam.fxrates.domain;

import com.epam.fxrates.dal.FxrswebserviceUriBuilder;
import com.epam.fxrates.dal.domain.Fxrates;
import com.epam.fxrates.properties.ApplicationProperties;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.HttpClientErrorException;

/**
 * Test for FxrswebserviceUriBuilder.
 *
 * Created by Andras_Csipes on 4/11/2017.
 */

public class FxrswebserviceUriBuilderTest {

    private static final String CURRENCY_SEPARATOR = ",";
    private static final String BAD_CURRENCY = "USSD";
    private static final String CORE_URL = "http://fxrswebservice.int-maui.karmalab.net/xmlfxrs/v1/allfxratesbybasecurrency/";
    private static final String CONTENT_TYPE = "application/json";



    @InjectMocks
    private FxrswebserviceUriBuilder underTest;

    @Mock
    private ApplicationProperties applicationProperties;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }


//    @Test(expected = HttpClientErrorException.class)
//    public void getFxrateJsonResponseShouldThrowExceptionWhenCalledBadCurrency() {
//
//        // GIVEN
//        BDDMockito.given(applicationProperties.getCurrenciesSeparator()).willReturn(CURRENCY_SEPARATOR);
//        BDDMockito.given(applicationProperties.getCoreUrl()).willReturn(CORE_URL);
//        BDDMockito.given(applicationProperties.getContentType()).willReturn(CONTENT_TYPE);
//
//        //WHEN
//        Fxrates resultFxrates = underTest.getFxrateJsonResponse(BAD_CURRENCY);
//
//        //THEN exception thrown
//    }
}
