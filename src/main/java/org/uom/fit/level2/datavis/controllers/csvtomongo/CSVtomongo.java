package org.uom.fit.level2.datavis.controllers.csvtomongo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by niwantha on 3/11/17.
 */
@Controller
@RequestMapping("/")
public class CSVtomongo {

    @RequestMapping(value="/csvtomongo" )

    public String ImportDB(String importPath, String filePath){
        Runtime r = Runtime.getRuntime();
        Process p = null;
        String command = "mongoimport --db datarepo --collection rawdata --type csv --file /home/asiri/Downloads/testxlproject_real.csv --headerline" ;
        try {
            p = r.exec(command);
            System.out.println("Reading csv into Database");

        } catch (Exception e){
            System.out.println("Error executing " + command + e.toString());
        }
        return"succes3";

    }
}

