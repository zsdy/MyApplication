package com.test.myapplication.entity;

import java.io.Serializable;

/**
 * @author zhangdaoying
 * @date 2016/9/19.
 * 实现Serializable接口
 */
public class User implements Serializable {
    //手动自定 序列和反序列时相同
    private static final long serialVersionUID=519067123721295773L;
    public int UserID;
    public String UserName;
    public int UserAge;

    public User(int userID, String userName, int userAge) {
        UserID = userID;
        UserName = userName;
        UserAge = userAge;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public int getUserAge() {
        return UserAge;
    }

    public void setUserAge(int userAge) {
        UserAge = userAge;
    }
}
