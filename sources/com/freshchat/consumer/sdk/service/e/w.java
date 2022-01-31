package com.freshchat.consumer.sdk.service.e;

import com.freshchat.consumer.sdk.FreshchatCallbackStatus;

public class w implements k {
    private int count = 0;
    private FreshchatCallbackStatus gI;
    private boolean success;

    public void a(FreshchatCallbackStatus freshchatCallbackStatus) {
        this.gI = freshchatCallbackStatus;
    }

    public FreshchatCallbackStatus dO() {
        return this.gI;
    }

    public int getCount() {
        return this.count;
    }

    @Override // com.freshchat.consumer.sdk.service.e.k
    public boolean isSuccess() {
        return this.success;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }
}
