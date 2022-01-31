package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.Arrays;

public class DateValidatorPointForward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointForward> CREATOR = new a();
    public final long f;

    public static class a implements Parcelable.Creator<DateValidatorPointForward> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public DateValidatorPointForward createFromParcel(Parcel parcel) {
            return new DateValidatorPointForward(parcel.readLong(), null);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public DateValidatorPointForward[] newArray(int i) {
            return new DateValidatorPointForward[i];
        }
    }

    public DateValidatorPointForward(long j) {
        this.f = j;
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean B0(long j) {
        return j >= this.f;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof DateValidatorPointForward) && this.f == ((DateValidatorPointForward) obj).f) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f);
    }

    public DateValidatorPointForward(long j, a aVar) {
        this.f = j;
    }
}
