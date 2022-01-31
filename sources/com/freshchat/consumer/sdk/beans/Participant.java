package com.freshchat.consumer.sdk.beans;

public class Participant {
    private String alias;
    private String firstName;
    private String lastName;
    private String profilePicUrl;

    public String getAlias() {
        return this.alias;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getProfilePicUrl() {
        return this.profilePicUrl;
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public void setFirstName(String str) {
        this.firstName = str;
    }

    public void setLastName(String str) {
        this.lastName = str;
    }

    public void setProfilePicUrl(String str) {
        this.profilePicUrl = str;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("Participant{alias='");
        hj1.U0(i0, this.alias, '\'', ", firstName='");
        hj1.U0(i0, this.firstName, '\'', ", lastName='");
        hj1.U0(i0, this.lastName, '\'', ", profilePicUrl='");
        i0.append(this.profilePicUrl);
        i0.append('\'');
        i0.append('}');
        return i0.toString();
    }
}
