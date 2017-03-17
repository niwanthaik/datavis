package org.uom.fit.level2.datavis.controllers.charts;

import com.mongodb.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by niwantha on 3/15/17.
 */
@RestController
@RequestMapping("/")
public class PassengersPerPaymentType {
    @RequestMapping(value = "/chart/passengersPerPaymentType", method = RequestMethod.GET)
    public void totalPassengersPerPaymenttype() {
        MongoClient mongo = new MongoClient();
        DB db = mongo.getDB("datarepo");

        DBCollection collection = db.getCollection("rawdata");

        DBObject group = new BasicDBObject("$group", new BasicDBObject("_id", "$PAYMENT_TYPE")
                .append("passengers per payment type", new BasicDBObject("$sum", 1)));

        //DBObject sort = new BasicDBObject("$sort", new BasicDBObject("amount", 1));


        AggregationOutput output = collection.aggregate(group);

        for (DBObject result : output.results()) {
            System.out.println(result);

        }

    }
}