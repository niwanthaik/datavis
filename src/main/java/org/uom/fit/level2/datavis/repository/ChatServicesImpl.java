/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uom.fit.level2.datavis.repository;


import com.google.gson.Gson;
import com.mongodb.*;
import com.mongodb.util.JSON;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.uom.fit.level2.datavis.model.ChatData;

import java.util.List;

@Service
@Validated
public class ChatServicesImpl implements ChatServices {

    @Override
    public JSONArray getAll() {
        try {
            Mongo mongo = new Mongo("localhost", 27017);
            DB db = mongo.getDB("datarepo");
            DBCollection collection = db.getCollection("user");
            DBCursor cursor = collection.find();
            JSON json = new JSON();
            String dataUser = json.serialize(cursor);
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(dataUser);
            JSONArray jsonarray = (JSONArray) obj;
            return jsonarray;
        } catch (Exception e) {
            System.out.println("Exception Error getAll");
            return null;
        }
    }

    @Override
    public boolean saveChatData(ChatData chatData) {
        try {
            Mongo mongo = new Mongo("localhost", 27017);
            DB db = mongo.getDB("datarepo");
            DBCollection collection = db.getCollection("message");
            Gson gson = new Gson();
            DBObject dbObject = (DBObject) JSON.parse(gson.toJson(chatData));
            WriteResult result = collection.insert(WriteConcern.SAFE, dbObject);
            return true;
        } catch (Exception e) {
            System.out.println("Exception Error createProect");
            return false;
        }
    }

//    @Override
//    public JSONArray getAllChatDataSend(String userName) {
//        try {
//            Mongo mongo = new Mongo("localhost", 27017);
//            DB db = mongo.getDB("chat");
//            DBCollection collection = db.getCollection("message");
//            BasicDBObject whereQuery = new BasicDBObject();
//            BasicDBObject field = new BasicDBObject();
//            BasicDBObject sortQuery = new BasicDBObject();
//
//            whereQuery.put("senderName", userName);
//            field.put("senderName", 1);
//            field.put("message", 1);
//            field.put("receiverName", 1);
//            field.put("imageData", 1);
//
//            sortQuery.put("DateTime", 1);
//
//            DBCursor cursor = collection.find(whereQuery, field).sort(sortQuery);
//
//            String dataUser = JSON.serialize(cursor);
//            JSONParser parser = new JSONParser();
//            Object obj = parser.parse(dataUser);
//            JSONArray jsonarray = (JSONArray) obj;
//
//            return jsonarray;
//
//        } catch (Exception e) {
//            System.out.println("Exception Error getAllChatData");
//            return null;
//        }
//    }
//
//    @Override
//    public JSONArray getAllChatDataReceive(String userName) {
//        try {
//            Mongo mongo = new Mongo("localhost", 27017);
//            DB db = mongo.getDB("chat");
//            DBCollection collection = db.getCollection("message");
//            BasicDBObject whereQuery = new BasicDBObject();
//            BasicDBObject field = new BasicDBObject();
//            BasicDBObject sortQuery = new BasicDBObject();
//
//            whereQuery.put("receiverName", userName);
//            field.put("senderName", 1);
//            field.put("message", 1);
//            field.put("receiverName", 1);
//            field.put("imageData", 1);
//
//            sortQuery.put("DateTime", 1);
//
//            DBCursor cursor = collection.find(whereQuery, field).sort(sortQuery);
//
//            String dataUser = JSON.serialize(cursor);
//            JSONParser parser = new JSONParser();
//            Object obj = parser.parse(dataUser);
//            JSONArray jsonarray = (JSONArray) obj;
//
//            return jsonarray;
//
//        } catch (Exception e) {
//            System.out.println("Exception Error getAllChatData");
//            return null;
//        }
//    }
    @Override
    public JSONArray getAllChatData(String message) {
        try {
            Mongo mongo = new Mongo("localhost", 27017);
            DB db = mongo.getDB("chat");
            DBCollection collection = db.getCollection("message");
            BasicDBObject whereQuery = new BasicDBObject();
            BasicDBObject field = new BasicDBObject();
            BasicDBObject sortQuery = new BasicDBObject();

            whereQuery.put("message", message);
            field.put("senderName", 1);
            field.put("message", 1);
            field.put("receiverName", 1);
            field.put("imageData", 1);
            field.put("discription", 1);

            sortQuery.put("DateTime", 1);

            DBCursor cursor = collection.find(whereQuery, field).sort(sortQuery);
            JSON json = new JSON();
            String dataUser = json.serialize(cursor);
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(dataUser);
            JSONArray jsonarray = (JSONArray) obj;
            return jsonarray;
        } catch (Exception e) {
            System.out.println("Exception Error getAll");
            return null;
        }
    }

    @Override
    public JSONArray getAllChatDataAllMessage() {
        try {
            Mongo mongo = new Mongo("localhost", 27017);
            DB db = mongo.getDB("chat");
            DBCollection collection = db.getCollection("message");

            List<String> lst = collection.distinct("message");

            String json = new Gson().toJson(lst);
            JSONArray jsonarray = (JSONArray) new JSONParser().parse(json);
            return jsonarray;

        } catch (Exception e) {
            System.out.println("Exception Error getAllChatDataAllMEssage");
            return null;
        }
    }
}
