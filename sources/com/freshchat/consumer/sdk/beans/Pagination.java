package com.freshchat.consumer.sdk.beans;

import android.os.Parcel;
import android.os.Parcelable;

public class Pagination implements Parcelable {
    public static final Parcelable.Creator<Pagination> CREATOR = new Parcelable.Creator<Pagination>() {
        /* class com.freshchat.consumer.sdk.beans.Pagination.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public Pagination createFromParcel(Parcel parcel) {
            return new Pagination(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Pagination[] newArray(int i) {
            return new Pagination[i];
        }
    };
    private int count;
    private int currentPage;
    private int nextPage;

    public Pagination(Parcel parcel) {
        this.currentPage = parcel.readInt();
        this.count = parcel.readInt();
        this.nextPage = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public int getCount() {
        return this.count;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public int getNextPage() {
        return this.nextPage;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public void setNextPage(int i) {
        this.nextPage = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.currentPage);
        parcel.writeInt(this.count);
        parcel.writeInt(this.nextPage);
    }
}
