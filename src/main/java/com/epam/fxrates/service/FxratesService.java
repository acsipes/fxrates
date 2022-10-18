package com.epam.fxrates.service;

import com.epam.fxrates.dal.FxrswebserviceUriBuilder;
import com.epam.fxrates.dal.UsdRatesDao;
import com.epam.fxrates.dal.domain.Fxrate;
import com.epam.fxrates.dal.domain.Fxrates;
import com.epam.fxrates.properties.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for create Fxrates Json response.
 *
 * Created by Andras_Csipes on 4/11/2017.
 */

@Service
public class FxratesService {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    private FxrswebserviceUriBuilder fxrswebserviceUriBuilder;

    @Autowired
    private UsdRatesDao usdRatesDao;

    public Fxrates getTargetCurrencies(String currency, String currencies) {
//        Fxrates fxrates = fxrswebserviceUriBuilder.getFxrateJsonResponse(currency);
        Fxrates fxrates = usdRatesDao.getJsonReviews(currency, new File("FxRates.json"));
        boolean haveCurrencies = !currencies.equals(applicationProperties.getNoCurrencies());
        List<Fxrate> fxrateList = new ArrayList<>();
        if (haveCurrencies) {
            LinkedHashSet<String> splitCurrencies = splitCurrencies(currencies);
            for (String splitCurrency : splitCurrencies) {
                fxrateList.addAll(fxrates.getFxrates()
                        .stream()
//                    .filter(fxRate -> splitCurrencies.contains(fxRate.getTargetCurrencyCode()))       --- this sorts the result alphabetic
                        .filter(fxRate -> fxRate.getTargetCurrencyCode().equals(splitCurrency))
                        .collect(Collectors.toList()));
            }
            fxrates.setFxrates(fxrateList);
        }
        return fxrates;
    }

    private LinkedHashSet<String> splitCurrencies(String currencies) {
        return trimCurrencies(Arrays.asList(currencies.split(applicationProperties.getCurrenciesSeparator())));
    }

    private LinkedHashSet<String> trimCurrencies(List<String> currencies) {
        return new LinkedHashSet<String>((currencies.stream().map(String::trim).collect(Collectors.toList())));
    }


}
