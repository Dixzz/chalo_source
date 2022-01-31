package com.google.firebase.auth;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public abstract class ActionCodeEmailInfo extends ActionCodeInfo {
    @Override // com.google.firebase.auth.ActionCodeInfo
    public String getEmail() {
        return super.getEmail();
    }

    public abstract String getPreviousEmail();
}
