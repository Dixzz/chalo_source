package com.freshchat.consumer.sdk.beans;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class FAQ implements Parcelable {
    public static final Parcelable.Creator<FAQ> CREATOR = new Parcelable.Creator<FAQ>() {
        /* class com.freshchat.consumer.sdk.beans.FAQ.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public FAQ createFromParcel(Parcel parcel) {
            return new FAQ(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public FAQ[] newArray(int i) {
            return new FAQ[i];
        }
    };
    private String categoryId;
    private String categoryName;
    private String content;
    @SerializedName("articleId")
    private String id;
    private String language;
    private String lastUpdatedAt;
    private String title;

    public FAQ(Parcel parcel) {
        this.id = parcel.readString();
        this.categoryId = parcel.readString();
        this.title = parcel.readString();
        this.content = parcel.readString();
        this.lastUpdatedAt = parcel.readString();
        this.categoryName = parcel.readString();
        this.language = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public String getContent() {
        return this.content;
    }

    public String getId() {
        return this.id;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getLastUpdatedAt() {
        return this.lastUpdatedAt;
    }

    public String getTitle() {
        return this.title;
    }

    public void setCategoryId(String str) {
        this.categoryId = str;
    }

    public void setCategoryName(String str) {
        this.categoryName = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setLastUpdatedAt(String str) {
        this.lastUpdatedAt = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.categoryId);
        parcel.writeString(this.title);
        parcel.writeString(this.content);
        parcel.writeString(this.lastUpdatedAt);
        parcel.writeString(this.categoryName);
        parcel.writeString(this.language);
    }
}
