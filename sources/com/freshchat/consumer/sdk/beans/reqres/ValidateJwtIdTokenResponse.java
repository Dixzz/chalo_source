package com.freshchat.consumer.sdk.beans.reqres;

public class ValidateJwtIdTokenResponse {
    private boolean userAliasExists;
    private boolean validToken;

    public boolean isUserAliasExists() {
        return this.userAliasExists;
    }

    public boolean isValidToken() {
        return this.validToken;
    }

    public void setUserAliasExists(boolean z) {
        this.userAliasExists = z;
    }

    public void setValidToken(boolean z) {
        this.validToken = z;
    }
}
