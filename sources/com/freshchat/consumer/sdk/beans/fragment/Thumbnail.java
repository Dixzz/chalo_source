package com.freshchat.consumer.sdk.beans.fragment;

public class Thumbnail {
    private String content;
    private String contentType;
    private long height;
    private long width;

    public String getContent() {
        return this.content;
    }

    public String getContentType() {
        return this.contentType;
    }

    public long getHeight() {
        return this.height;
    }

    public long getWidth() {
        return this.width;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public void setHeight(long j) {
        this.height = j;
    }

    public void setWidth(long j) {
        this.width = j;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("Thumbnail{content='");
        hj1.U0(i0, this.content, '\'', ", contentType='");
        hj1.U0(i0, this.contentType, '\'', ", height=");
        i0.append(this.height);
        i0.append(", width=");
        i0.append(this.width);
        i0.append('}');
        return i0.toString();
    }
}
