/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uom.fit.level2.datavis.repository;


import org.json.simple.JSONArray;
import org.uom.fit.level2.datavis.model.ChatData;


public interface ChatServices {

    public JSONArray getAll();

    public boolean saveChatData(ChatData chatData);

//    JSONArray getAllChatDataSend(String userName);
//
//    JSONArray getAllChatDataReceive(String userName);
    JSONArray getAllChatData(String message);

    JSONArray getAllChatDataAllMessage();
}
