package com.freshchat.consumer.sdk.beans.reqres;

import com.freshchat.consumer.sdk.beans.User;
import com.google.gson.annotations.SerializedName;

public class UserRequest {
    @SerializedName("jwtAuthToken")
    private String jwtIdToken;
    private User user;

    public String getJwtIdToken() {
        return this.jwtIdToken;
    }

    public User getUser() {
        return this.user;
    }

    public void setJwtIdToken(String str) {
        this.jwtIdToken = str;
    }

    public void setUser(User user2) {
        this.user = user2;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("UserRequest [user=");
        i0.append(this.user);
        i0.append("]");
        return i0.toString();
    }
}
