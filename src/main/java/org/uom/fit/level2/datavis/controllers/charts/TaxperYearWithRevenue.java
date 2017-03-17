package org.uom.fit.level2.datavis.controllers.charts;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by niwantha on 3/16/17.
 */
@RestController
@RequestMapping("/")
public class TaxperYearWithRevenue {

    @RequestMapping(value = "/chart/taxPerYearWithRevenue", method = RequestMethod.GET)
    public void maleFemaleCountDay() {
        MongoClient mongo = new MongoClient();
        DB db = mongo.getDB("datarepo");

        DBCollection collection = db.getCollection("rawdata");


    }
}