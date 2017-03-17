package org.uom.fit.level2.datavis.controllers.charts;

import com.mongodb.*;

import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by niwantha on 3/16/17.
 */
@RestController
@RequestMapping("/")
public class MaleFemaleCountDay {


    @RequestMapping(value = "/chart/maleFemale/day", method = RequestMethod.GET)
    public void maleFemaleCountDay() {
        MongoClient mongo = new MongoClient();
        DB db = mongo.getDB("datarepo");

        DBCollection collection = db.getCollection("rawdata");

      /*  db.collection.aggregate([
                {$project: {
            male: {$cond: [{$eq: ["$gender", "male"]}, 1, 0]},
            female: {$cond: [{$eq: ["$gender", "female"]}, 1, 0]},
        }},
        {$group: { _id: null, male: {$sum: "$male"},
            female: {$sum: "$female"},
            total: {$sum: 1},
        }},
        ])*/

        DBObject project = new BasicDBObject(
                "$project", new BasicDBObject(
                "male", new BasicDBObject(
                "$cond",new BasicDBObject( "if",new Object[]{
                new BasicDBObject(
                        "$eq",new BasicDBObject("$GENDER","M"))
                .append("then",1).append("else",0)}))
                .append( "female", new BasicDBObject(
                "$cond",new BasicDBObject("if", new Object[]{
                new BasicDBObject(
                        "$eq",new BasicDBObject("$GENDER","F")).append("then",1).append("else",0)
                })))));


        DBObject group = new BasicDBObject("$group", new BasicDBObject("_id", "$BOOKING_CREATED_DATE")

                .append("male", new BasicDBObject("$sum", "$M"))
                .append("female", new BasicDBObject("$sum", "$F")));

        //DBObject sort = new BasicDBObject("$sort", new BasicDBObject("amount", 1));


        AggregationOutput output = collection.aggregate(project,group);

        for (DBObject result : output.results()) {
            System.out.println(result);

        }
    }

}
