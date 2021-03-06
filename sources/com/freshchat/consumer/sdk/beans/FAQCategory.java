package com.freshchat.consumer.sdk.beans;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class FAQCategory implements Parcelable, ICategory {
    public static final Parcelable.Creator<FAQCategory> CREATOR = new Parcelable.Creator<FAQCategory>() {
        /* class com.freshchat.consumer.sdk.beans.FAQCategory.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public FAQCategory createFromParcel(Parcel parcel) {
            return new FAQCategory(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public FAQCategory[] newArray(int i) {
            return new FAQCategory[i];
        }
    };
    private String categoryId;
    private String description;
    @SerializedName("icon")
    private String iconUrl;
    private String title;

    public FAQCategory(Parcel parcel) {
        this.categoryId = parcel.readString();
        this.title = parcel.readString();
        this.description = parcel.readString();
        this.iconUrl = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.freshchat.consumer.sdk.beans.ICategory
    public String getCategoryAlias() {
        return this.categoryId;
    }

    @Override // com.freshchat.consumer.sdk.beans.ICategory
    public String getCategoryId() {
        return this.categoryId;
    }

    @Override // com.freshchat.consumer.sdk.beans.ICategory
    public String getDescription() {
        return this.description;
    }

    @Override // com.freshchat.consumer.sdk.beans.ICategory
    public String getIconUrl() {
        return this.iconUrl;
    }

    @Override // com.freshchat.consumer.sdk.beans.ICategory
    public String getTitle() {
        return this.title;
    }

    public void setCategoryId(String str) {
        this.categoryId = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.categoryId);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeString(this.iconUrl);
    }
}
