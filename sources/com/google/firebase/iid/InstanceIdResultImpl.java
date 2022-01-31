package com.google.firebase.iid;

/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
public final class InstanceIdResultImpl implements InstanceIdResult {
    private final String id;
    private final String token;

    public InstanceIdResultImpl(String str, String str2) {
        this.id = str;
        this.token = str2;
    }

    @Override // com.google.firebase.iid.InstanceIdResult
    public String getId() {
        return this.id;
    }

    @Override // com.google.firebase.iid.InstanceIdResult
    public String getToken() {
        return this.token;
    }
}
