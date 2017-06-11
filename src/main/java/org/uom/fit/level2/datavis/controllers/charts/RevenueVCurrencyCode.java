package org.uom.fit.level2.datavis.controllers.charts;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mongodb.*;
import org.uom.fit.level2.datavis.model.dataModel;

/**
 * Created by niwantha on 3/21/17.
 */
public class RevenueVCurrencyCode {

    public static JsonArray revenueVCurrencyCode(dataModel dataModel) {
        MongoClient mongo = new MongoClient();
        DB db = mongo.getDB("datarepo");

        DBCollection collection = db.getCollection("rawdata");

        JsonArray jsonArray=null;
        try {

            jsonArray = new JsonArray();
            ISO8601DateFormat df = new ISO8601DateFormat();

            DBObject dateQuery = new BasicDBObject();
            dateQuery.put("$gt", df.parse(dataModel.getDateFrom()));
            dateQuery.put("$lt", df.parse(dataModel.getDateTo()));
            DBObject match = new BasicDBObject();
            match.put("BOOKING_CREATED_DATE", dateQuery);

            DBObject group = new BasicDBObject();
            group.put("_id", "$CURRENCY_CODE");
            group.put("Y", new BasicDBObject("$sum", "$TOTAL_PRICE"));

            AggregationOutput output = collection.aggregate(new BasicDBObject("$match", match), new BasicDBObject("$group", group));




            for(DBObject result:output.results()){
                System.out.println(result);
                JsonObject jsonobj = new JsonObject();
                jsonobj.addProperty("_id", result.get("_id").toString());
                jsonobj.addProperty("Y", result.get("Y").toString());
                jsonArray.add(jsonobj);
            }


        }catch (Exception e){
            System.out.print(e);
        }


        return jsonArray;

    }







}

