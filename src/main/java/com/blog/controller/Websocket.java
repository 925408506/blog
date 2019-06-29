package com.blog.controller;

import com.blog.pojo.Message;
import com.blog.pojo.UserInfo;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@ServerEndpoint("/websocket/{username}")
public class Websocket{
    private static int onlineCount = 0;
    private static Map<String,UserInfo> clients = new ConcurrentHashMap<String, UserInfo>();

    private static int id = 0;

    @OnOpen
    public void onOpen(@PathParam("username") String username, Session session) throws IOException {
        System.out.println(username);
        UserInfo user=new UserInfo(""+id+1,username+id);
        List<Message> list=new ArrayList<Message>();
        user.setMegs(list);
        user.setSession(session);
        addOnlineCount();
        clients.put(user.getName(), user);
        System.out.println("已连接,共"+onlineCount);
    }

    @OnClose
    public void onClose(@PathParam("username") String username) throws IOException {
        clients.remove(username);
        subOnlineCount();
    }

    @OnMessage
    public void onMessage(String message) throws IOException {

       /* JSONObject jsonTo = JSONObject.fromObject(message);

        if (!jsonTo.get("To").equals("All")){
            Message mes=new Message();
            mes.setFromName(user.getName());
            mes.setMessageText(jsonTo.get("massege").toString());
            mes.setToName(jsonTo.get("To").toString());
            user.getMegs().add(mes);
            sendMessageTo(jsonTo.get("massege").toString(), jsonTo.get("To").toString());
        }else{
            sendMessageAll("给所有人");
        }*/
       sendMessageAll("給所有人");
    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    public void sendMessageTo(String message, String To) throws IOException {
        for (UserInfo item : clients.values()) {
            if (item.getName().equals(To)) {
                item.getSession().getAsyncRemote().sendText(message + "," + item.getName());
            }
        }
    }
    public void sendMessageAll(String message) throws IOException {
        for (UserInfo item : clients.values()) {
            item.getSession().getAsyncRemote().sendText(message);
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        Websocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        Websocket.onlineCount--;
    }

    public static synchronized Map<String,UserInfo> getClients() {
        return clients;
    }
}

