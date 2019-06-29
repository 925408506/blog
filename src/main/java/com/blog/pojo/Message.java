package com.blog.pojo;

import java.sql.Timestamp;

public class Message {
    private int messageId;
    private String fromName;
    private String toName;
    private String messageText;
    private Timestamp messageData;

    public Message() {
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", fromName='" + fromName + '\'' +
                ", toName='" + toName + '\'' +
                ", messageText='" + messageText + '\'' +
                ", messageData=" + messageData +
                '}';
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Timestamp getMessageData() {
        return messageData;
    }

    public void setMessageData(Timestamp messageData) {
        this.messageData = messageData;
    }

}
