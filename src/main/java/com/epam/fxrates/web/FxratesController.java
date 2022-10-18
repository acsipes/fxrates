package com.epam.fxrates.web;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.epam.fxrates.facade.FxratesViewFacade;
import com.epam.fxrates.properties.ApplicationProperties;
import com.epam.fxrates.web.domain.FxratesView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.NoSuchElementException;

/**
 * Fxrates Controller.
 *
 * Created by Andras_Csipes on 4/11/2017.
 */

@RestController
@Api(value = "FxratesControllerAPI", produces = APPLICATION_JSON_VALUE)
public class FxratesController {

    @Autowired
    private FxratesViewFacade fxratesViewFacade;

    @Autowired
    private ApplicationProperties applicationProperties;

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping(value ="/fxrates", method = RequestMethod.GET)
    public String emptyArgument() {
        System.out.println("Entering Sleep");
        try {
            Thread.sleep(15000);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        System.out.println("Exiting Sleep");
        throw new NoSuchElementException("No currency given!");
    }

        @ApiOperation("Gets the TargetCurrencyRates")
        @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = FxratesView.class)})
    @RequestMapping(value ="/fxrates/{currency}", method = RequestMethod.GET)
    public FxratesView getTargetCurrencyRates(@PathVariable(value = "currency") String currency) {
        String upperCasedCurrency = currency.toUpperCase();
        return fxratesViewFacade.getTargetCurrencies(upperCasedCurrency, applicationProperties.getNoCurrencies());
    }

    @RequestMapping(value ="/fxrates/{currency}/{currencies}", method = RequestMethod.GET)
    public FxratesView getTargetCurrenciesRates(@PathVariable(value = "currency") String currency, @PathVariable(value = "currencies") String currencies) {
        String upperCasedCurrency = currency.toUpperCase().trim();
        String uppercasedCurrencies = currencies.toUpperCase().trim();
        return fxratesViewFacade.getTargetCurrencies(upperCasedCurrency, uppercasedCurrencies);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(HttpClientErrorException.class)
    public String return400(HttpClientErrorException e) {
        return "Given bad currency!";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String return400(NoSuchElementException e) {
        return e.getMessage();
    }
}
