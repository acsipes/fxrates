package com.epam.fxrates.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Andras_Csipes on 4/20/2017.
 */

@Controller
public class IndexController {

    @RequestMapping(value = "/")
    public String index() {
        return "index.html";
    }
}
