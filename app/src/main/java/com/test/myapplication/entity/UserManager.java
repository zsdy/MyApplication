package com.test.myapplication.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author yanxu
 * @date 2016/8/17.
 */
public class UserManager implements Parcelable{
    public static int UserId=1;

    protected UserManager(Parcel in) {
        UserId=in.readInt();
    }

    public static final Creator<UserManager> CREATOR = new Creator<UserManager>() {
        @Override
        public UserManager createFromParcel(Parcel in) {
            return new UserManager(in);
        }

        @Override
        public UserManager[] newArray(int size) {
            return new UserManager[size];
        }
    };

    public static int getUserId() {
        return UserId;
    }

    public static void setUserId(int UserId) {
        UserManager.UserId = UserId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(flags);
    }
}
