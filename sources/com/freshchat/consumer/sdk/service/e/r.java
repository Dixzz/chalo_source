package com.freshchat.consumer.sdk.service.e;

public class r implements k {
    private a gA;
    private boolean success;

    public enum a {
        UserNotCreated,
        NoInternet,
        Failed,
        Success
    }

    public r(boolean z, a aVar) {
        this.success = z;
        this.gA = aVar;
    }

    @Override // com.freshchat.consumer.sdk.service.e.k
    public boolean isSuccess() {
        return this.success;
    }
}
