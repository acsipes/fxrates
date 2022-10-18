package com.epam.fxrates.service;

import com.epam.fxrates.dal.domain.Fxrate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Check Fxrates is not a null.
 *
 * Created by Andras_Csipes on 4/11/2017.
 */
@Service
public class FxratesChecker {

    public boolean fxratesNotNull(List<Fxrate> fxrates) {
        return Optional.ofNullable(fxrates).isPresent();
    }
}
