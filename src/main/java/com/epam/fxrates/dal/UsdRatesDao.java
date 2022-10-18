package com.epam.fxrates.dal;

import com.epam.fxrates.dal.domain.Fxrates;
import com.epam.fxrates.properties.ApplicationProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 * Created by Andras_Csipes on 4/19/2017.
 */

@Component
public class UsdRatesDao {

    private final Logger LOGGER = LoggerFactory.getLogger(UsdRatesDao.class);

    @Autowired
    private ApplicationProperties applicationProperties;

    public Fxrates getJsonReviews(String currency, File file) {
        Fxrates fxrates = readJSON(file);
        fxrates.setFxrates(fxrates.getFxrates().stream().filter(fxRate -> fxRate.getBaseCurrencyCode().equals(currency)).collect(Collectors.toList()));
        return fxrates;
    }

    private Fxrates readJSON(File file) {
        ObjectMapper mapper = new ObjectMapper();
        Fxrates fxrates = new Fxrates();
        try {
            fxrates = mapper.readValue(file, Fxrates.class);
        } catch(IOException e){
            LOGGER.error(applicationProperties.getRed() + "IndependentAuditorRead Error message: "+ e + applicationProperties.getReset());
        }
        return fxrates;
    }
}
