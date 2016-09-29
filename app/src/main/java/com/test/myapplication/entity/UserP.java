package com.test.myapplication.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author zhangdaoying
 * @date 2016/9/19.
 * Parcelable序列化
 */
public class UserP implements Parcelable{
    public int UserID;
    public String UserName;
    public int UserAge;

    public UserP(int userID, String userName, int userAge) {
        UserID = userID;
        UserName = userName;
        UserAge = userAge;
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

    public static Creator<UserP> getCREATOR() {
        return CREATOR;
    }

    protected UserP(Parcel in) {
        UserID = in.readInt();
        UserName = in.readString();
        UserAge = in.readInt();
    }

    public static final Creator<UserP> CREATOR = new Creator<UserP>() {
        @Override
        public UserP createFromParcel(Parcel in) {
            return new UserP(in);
        }

        @Override
        public UserP[] newArray(int size) {
            return new UserP[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(UserID);
        dest.writeString(UserName);
        dest.writeInt(UserAge);
    }
}
