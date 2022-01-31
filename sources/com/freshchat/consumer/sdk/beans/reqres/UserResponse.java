package com.freshchat.consumer.sdk.beans.reqres;

import com.freshchat.consumer.sdk.beans.User;

public class UserResponse {
    private final int statusCode;
    private final User user;

    public UserResponse(int i, User user2) {
        this.statusCode = i;
        this.user = user2;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public User getUser() {
        return this.user;
    }
}
