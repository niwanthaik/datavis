package org.uom.fit.level2.datavis.controllers.ExcelToCsvController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;



import static org.uom.fit.level2.datavis.model.csvtomongo.ExcelToCsv.xlsx;

/**
 * Created by niwantha on 3/8/17.
 */
@Controller
@RequestMapping("/")
public class ExcelToCsv {

    @RequestMapping(value="/exceltocsv" )
    public String excelTocsv() {
      //  File inputFile = new File("/home/niwantha/Downloads/sample.xlsx");
      //  File outputFile = new File("/home/niwantha/Downloads/sample.csv");
     //   xlsx(inputFile, outputFile);
        return"succes2";
    }


}
