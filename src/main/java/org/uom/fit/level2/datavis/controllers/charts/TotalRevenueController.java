package org.uom.fit.level2.datavis.controllers.charts;

import com.mongodb.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.uom.fit.level2.datavis.model.TotalRevenue;
import org.uom.fit.level2.datavis.service.DataService;

import java.util.List;
import org.uom.fit.level2.datavis.model.jsontomongo.JsonToMongo;

import static org.springframework.integration.support.management.graph.LinkNode.Type.output;

/**
 * Created by niwantha on 3/12/17.
 */
@RestController
@RequestMapping("/")
public class TotalRevenueController {

  /*  private final DataService service;

    @Autowired
    TotalRevenueController(DataService service){
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    List<TotalRevenue> findAll(){
        return findAll();
    }*/

  //  DBCollection coll = db.getCollection("rawdata");

@RequestMapping(value = "/chart/totalrevenue/day", method = RequestMethod.GET)
    public void totalRevenueController(){
    MongoClient mongo = new MongoClient();
    DB db = mongo.getDB("datarepo");

    DBCollection collection = db.getCollection("rawdata");

 /*
 MONGO SHELL : db.aggregationExample.aggregate(
 {$match : {type : "local"}} ,
 {$project : { department : 1 , amount : 1 }} ,
 {$group :
        {
            _id : "$department" ,
            average : {$avg : "$amount"}
            }
             } ,
 {$sort : {"amount" : 1}}
 );
 */
    DBObject group = new BasicDBObject("$group", new BasicDBObject("_id", "$BOOKING_CREATED_DATE")
    .append("totalAmount", new BasicDBObject("$sum","$TOTAL_PRICE")));


    AggregationOutput output = collection.aggregate(group);

    for (DBObject result : output.results()) {
        System.out.println(result);
    }







}




}
