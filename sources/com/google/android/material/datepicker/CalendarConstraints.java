package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;

public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new a();
    public final Month f;
    public final Month g;
    public final DateValidator h;
    public Month i;
    public final int j;
    public final int k;

    public interface DateValidator extends Parcelable {
        boolean B0(long j);
    }

    public static class a implements Parcelable.Creator<CalendarConstraints> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public CalendarConstraints createFromParcel(Parcel parcel) {
            return new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), null);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public CalendarConstraints[] newArray(int i) {
            return new CalendarConstraints[i];
        }
    }

    public CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3, a aVar) {
        this.f = month;
        this.g = month2;
        this.i = month3;
        this.h = dateValidator;
        if (month3 != null && month.f.compareTo(month3.f) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        } else if (month3 == null || month3.f.compareTo(month2.f) <= 0) {
            this.k = month.m(month2) + 1;
            this.j = (month2.h - month.h) + 1;
        } else {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        if (!this.f.equals(calendarConstraints.f) || !this.g.equals(calendarConstraints.g) || !Objects.equals(this.i, calendarConstraints.i) || !this.h.equals(calendarConstraints.h)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f, this.g, this.i, this.h});
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f, 0);
        parcel.writeParcelable(this.g, 0);
        parcel.writeParcelable(this.i, 0);
        parcel.writeParcelable(this.h, 0);
    }

    public static final class b {
        public static final long e = pm4.a(Month.c(1900, 0).k);
        public static final long f = pm4.a(Month.c(2100, 11).k);

        /* renamed from: a  reason: collision with root package name */
        public long f624a = e;
        public long b = f;
        public Long c;
        public DateValidator d = new DateValidatorPointForward(Long.MIN_VALUE);

        public b() {
        }

        public CalendarConstraints a() {
            Month month;
            Bundle bundle = new Bundle();
            bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.d);
            Month f2 = Month.f(this.f624a);
            Month f3 = Month.f(this.b);
            DateValidator dateValidator = (DateValidator) bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY");
            Long l = this.c;
            if (l == null) {
                month = null;
            } else {
                month = Month.f(l.longValue());
            }
            return new CalendarConstraints(f2, f3, dateValidator, month, null);
        }

        public b(CalendarConstraints calendarConstraints) {
            this.f624a = calendarConstraints.f.k;
            this.b = calendarConstraints.g.k;
            this.c = Long.valueOf(calendarConstraints.i.k);
            this.d = calendarConstraints.h;
        }
    }
}
