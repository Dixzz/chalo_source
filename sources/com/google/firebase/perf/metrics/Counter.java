package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.concurrent.atomic.AtomicLong;

public class Counter implements Parcelable {
    public static final Parcelable.Creator<Counter> CREATOR = new Parcelable.Creator<Counter>() {
        /* class com.google.firebase.perf.metrics.Counter.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public Counter createFromParcel(Parcel parcel) {
            return new Counter(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Counter[] newArray(int i) {
            return new Counter[i];
        }
    };
    private AtomicLong mCount;
    private final String mName;

    public int describeContents() {
        return 0;
    }

    public long getCount() {
        return this.mCount.get();
    }

    public String getName() {
        return this.mName;
    }

    public void increment(long j) {
        this.mCount.addAndGet(j);
    }

    public void setCount(long j) {
        this.mCount.set(j);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mName);
        parcel.writeLong(this.mCount.get());
    }

    public Counter(String str) {
        this.mName = str;
        this.mCount = new AtomicLong(0);
    }

    private Counter(Parcel parcel) {
        this.mName = parcel.readString();
        this.mCount = new AtomicLong(parcel.readLong());
    }
}
