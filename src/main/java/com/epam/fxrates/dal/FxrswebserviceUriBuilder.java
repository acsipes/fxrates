package com.epam.fxrates.dal;

import com.epam.fxrates.dal.domain.Fxrates;
import com.epam.fxrates.properties.ApplicationProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

/**
 * This class build the URL for Fxrswebservice Response.
 *
 * Created by Andras_Csipes on 4/11/2017.
 */

@Component
public class FxrswebserviceUriBuilder {

    private final Logger LOGGER = LoggerFactory.getLogger(FxrswebserviceUriBuilder.class);

    @Autowired
    private ApplicationProperties applicationProperties;


    public Fxrates getFxrateJsonResponse(String currency) throws HttpClientErrorException {
            ResponseEntity<Fxrates> response = getFxrswebserviceResponseEntity(currency.trim());
            return response.getBody();
    }

    private ResponseEntity<Fxrates> getFxrswebserviceResponseEntity(String currency) throws HttpClientErrorException {
        String uri = applicationProperties.getCoreUrl() + currency;
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", applicationProperties.getContentType());
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, entity, Fxrates.class);
    }
}
