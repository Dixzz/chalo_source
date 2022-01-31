package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateUtils;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new a();
    public final Calendar f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final long k;
    public String l;

    public static class a implements Parcelable.Creator<Month> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public Month createFromParcel(Parcel parcel) {
            return Month.c(parcel.readInt(), parcel.readInt());
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public Month[] newArray(int i) {
            return new Month[i];
        }
    }

    public Month(Calendar calendar) {
        calendar.set(5, 1);
        Calendar d = pm4.d(calendar);
        this.f = d;
        this.g = d.get(2);
        this.h = d.get(1);
        this.i = d.getMaximum(7);
        this.j = d.getActualMaximum(5);
        this.k = d.getTimeInMillis();
    }

    public static Month c(int i2, int i3) {
        Calendar g2 = pm4.g();
        g2.set(1, i2);
        g2.set(2, i3);
        return new Month(g2);
    }

    public static Month f(long j2) {
        Calendar g2 = pm4.g();
        g2.setTimeInMillis(j2);
        return new Month(g2);
    }

    public static Month g() {
        return new Month(pm4.f());
    }

    /* renamed from: a */
    public int compareTo(Month month) {
        return this.f.compareTo(month.f);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        if (this.g == month.g && this.h == month.h) {
            return true;
        }
        return false;
    }

    public int h() {
        int firstDayOfWeek = this.f.get(7) - this.f.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.i : firstDayOfWeek;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.g), Integer.valueOf(this.h)});
    }

    public long i(int i2) {
        Calendar d = pm4.d(this.f);
        d.set(5, i2);
        return d.getTimeInMillis();
    }

    public String j(Context context) {
        if (this.l == null) {
            long timeInMillis = this.f.getTimeInMillis();
            this.l = DateUtils.formatDateTime(context, timeInMillis - ((long) TimeZone.getDefault().getOffset(timeInMillis)), 36);
        }
        return this.l;
    }

    public Month l(int i2) {
        Calendar d = pm4.d(this.f);
        d.add(2, i2);
        return new Month(d);
    }

    public int m(Month month) {
        if (this.f instanceof GregorianCalendar) {
            return (month.g - this.g) + ((month.h - this.h) * 12);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.h);
        parcel.writeInt(this.g);
    }
}
