/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uom.fit.level2.datavis.controllers.chatController;


import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.uom.fit.level2.datavis.model.ChatData;
import org.uom.fit.level2.datavis.repository.ChatServices;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


@RestController("/")
public class ChatController {

    @Autowired
    public ChatServices chatServices;

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public JSONArray listUsers() {
        return chatServices.getAll();
    }

//    @RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
//    public JSONObject listUsers(@PathVariable("username") String username, Model model) {
//        JSONObject message = new JSONObject();
//        message.put("send", chatServices.getAllChatDataSend(username));
//        message.put("receive", chatServices.getAllChatDataReceive(username));
//        return message;
//    }
    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public String LoginPage(@RequestBody ChatData chatData) {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(today);
        chatData.setDateTime(reportDate);
        boolean val = chatServices.saveChatData(chatData);
        if (val == true) {
            return "suss";
        } else {
            return "fail";
        }
    }

    @RequestMapping(value = "/allmessage", method = RequestMethod.GET)
    public JSONArray AllMessage() {
        JSONArray message = new JSONArray();

        JSONArray messagelength = chatServices.getAllChatDataAllMessage();
        for (int i = 0; i < messagelength.toArray().length; i++) {
            message.add( chatServices.getAllChatData(messagelength.get(i).toString()));
        }
        return message;
    }
}
