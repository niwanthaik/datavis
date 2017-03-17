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
public class TotalRevenueMonth {

    @RequestMapping(value = "/chart/totalrevenue/month", method = RequestMethod.GET)
    public void totalRevenueControllerMonth() {
        MongoClient mongo = new MongoClient();
        DB db = mongo.getDB("datarepo");

        DBCollection collection = db.getCollection("rawdata");

        DBObject group = new BasicDBObject("$group", new BasicDBObject("_id",new BasicDBObject("$month", "$BOOKING_CREATED_DATE"))
                .append("totalAmount", new BasicDBObject("$sum","$TOTAL_PRICE")));


        AggregationOutput output = collection.aggregate(group);

        for (DBObject result : output.results()) {
            System.out.println(result);
        }

    }

}