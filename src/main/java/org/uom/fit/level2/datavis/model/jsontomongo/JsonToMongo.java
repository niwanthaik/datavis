package org.uom.fit.level2.datavis.model.jsontomongo;

import com.mongodb.*;
import com.mongodb.util.JSON;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

/**
 * Created by niwantha on 12/19/16.
 */
public class JsonToMongo {

    public void jsonToMongo (String json){
        try {

            MongoClient mongoClient = new MongoClient("localhost", 27017);
            DB db = mongoClient.getDB("datarepo");

            DBCollection collection = db.getCollection("rawdata");
//            collection
           /* String json = "{'database' : 'mkyongDB','table' : 'hosting'," +
                    "'detail' : {'records' : 99, 'index' : 'vps_index1', 'active' : 'true'}}}";
        */
            DBObject dbObject = (DBObject) JSON.parse(json);

            collection.insert(dbObject);

           /* DBCursor cursorDocJSON = collection.find();
            while (cursorDocJSON.hasNext()) {
                System.out.println(cursorDocJSON.next());
            }*/


            //collection.remove(new BasicDBObject());

        } catch (MongoException e) {
            e.printStackTrace();
        }


    }
}
