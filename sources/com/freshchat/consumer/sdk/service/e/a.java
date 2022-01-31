package com.freshchat.consumer.sdk.service.e;

import com.freshchat.consumer.sdk.beans.User;
import com.freshchat.consumer.sdk.j.ab;

public class a implements j {
    private boolean fE;
    private boolean fF;
    @ab.b
    private User user;

    public boolean cN() {
        return this.fE;
    }

    public boolean cY() {
        return this.fF;
    }

    public User getUser() {
        return this.user;
    }

    public void n(boolean z) {
        this.fE = z;
    }

    public void o(boolean z) {
        this.fF = z;
    }

    public void setUser(User user2) {
        this.user = user2;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("CreateOrUpdateUserRequest [user=");
        i0.append(this.user);
        i0.append(", forceUserCreate = ");
        i0.append(this.fE);
        i0.append("]");
        return i0.toString();
    }
}
