package com.google.firebase.perf.util;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.concurrent.TimeUnit;

public class Timer implements Parcelable {
    public static final Parcelable.Creator<Timer> CREATOR = new Parcelable.Creator<Timer>() {
        /* class com.google.firebase.perf.util.Timer.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public Timer createFromParcel(Parcel parcel) {
            return new Timer(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Timer[] newArray(int i) {
            return new Timer[i];
        }
    };
    private long mHighResTime;
    private long mTime;

    public int describeContents() {
        return 0;
    }

    public long getCurrentTimestampMicros() {
        return getDurationMicros() + this.mTime;
    }

    public long getDurationMicros() {
        return TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - this.mHighResTime);
    }

    public long getHighResTime() {
        return TimeUnit.NANOSECONDS.toMicros(this.mHighResTime);
    }

    public long getMicros() {
        return this.mTime;
    }

    public void reset() {
        this.mTime = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
        this.mHighResTime = System.nanoTime();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mTime);
        parcel.writeLong(this.mHighResTime);
    }

    public Timer() {
        this.mTime = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
        this.mHighResTime = System.nanoTime();
    }

    public long getDurationMicros(Timer timer) {
        return TimeUnit.NANOSECONDS.toMicros(timer.mHighResTime - this.mHighResTime);
    }

    public Timer(long j) {
        this.mTime = j;
        this.mHighResTime = TimeUnit.MICROSECONDS.toNanos(j);
    }

    public Timer(long j, long j2) {
        this.mTime = j;
        this.mHighResTime = j2;
    }

    private Timer(Parcel parcel) {
        this.mTime = parcel.readLong();
        this.mHighResTime = parcel.readLong();
    }
}
