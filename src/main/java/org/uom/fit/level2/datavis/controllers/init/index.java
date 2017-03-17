package org.uom.fit.level2.datavis.controllers.init;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by niwantha on 3/12/17.
 */
@RestController

public class index {
    @RequestMapping(value="/",method = RequestMethod.GET)
    public String homepage(){
        return "index";
    }

}
