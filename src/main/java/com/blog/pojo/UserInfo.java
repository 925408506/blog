package com.blog.pojo;

import javax.websocket.Session;
import java.util.List;

public class UserInfo {
    private String id;
    private  String name;
    private  String pwd;
    private String loginTime;
    private List<Message> megs;
    private Session session;

    public UserInfo(String id, String name, String pwd, String loginTime, List <Message> megs, Session session) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.loginTime = loginTime;
        this.megs = megs;
        this.session = session;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", loginTime='" + loginTime + '\'' +
                ", megs=" + megs +
                ", session=" + session +
                '}';
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }


    public UserInfo() {
    }
    public UserInfo(String id, String name) {
        this.id = id;
        this.name = name;
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public List <Message> getMegs() {
        return megs;
    }

    public void setMegs(List <Message> megs) {
        this.megs = megs;
    }
}
