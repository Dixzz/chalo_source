package com.freshchat.consumer.sdk.beans;

import android.os.Parcel;
import android.os.Parcelable;
import com.freshchat.consumer.sdk.R;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CalendarDay {
    private final String day;
    private final Map<PartOfDay, List<TimeSlot>> timeSlotsMap = new TreeMap(new Object() {
        /* class com.freshchat.consumer.sdk.beans.CalendarDay.AnonymousClass1 */

        public int compare(PartOfDay partOfDay, PartOfDay partOfDay2) {
            return partOfDay.startHour - partOfDay2.startHour;
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ Comparator<PartOfDay> reversed() {
            return Comparator.CC.$default$reversed(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Comparator] */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ java.util.Comparator<PartOfDay> thenComparing(java.util.Comparator<? super PartOfDay> comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }
    });

    public enum PartOfDay {
        MORNING(0, 12, R.string.freshchat_calendar_part_of_day_morning),
        AFTERNOON(12, 16, R.string.freshchat_calendar_part_of_day_afternoon),
        EVENING(16, 20, R.string.freshchat_calendar_part_of_day_evening),
        NIGHT(20, 24, R.string.freshchat_calendar_part_of_day_night);
        
        private final int endHour;
        private final int startHour;
        private final int stringResId;

        private PartOfDay(int i, int i2, int i3) {
            this.startHour = i;
            this.endHour = i2;
            this.stringResId = i3;
        }

        public static PartOfDay getPartOfDay(int i) {
            PartOfDay[] values = values();
            for (int i2 = 0; i2 < 4; i2++) {
                PartOfDay partOfDay = values[i2];
                if (partOfDay.startHour <= i && i < partOfDay.endHour) {
                    return partOfDay;
                }
            }
            return null;
        }

        public int getEndHour() {
            return this.endHour;
        }

        public int getStartHour() {
            return this.startHour;
        }

        public int getStringResId() {
            return this.stringResId;
        }
    }

    public static class TimeSlot implements Parcelable, Comparable<TimeSlot> {
        public static final Parcelable.Creator<TimeSlot> CREATOR = new Parcelable.Creator<TimeSlot>() {
            /* class com.freshchat.consumer.sdk.beans.CalendarDay.TimeSlot.AnonymousClass1 */

            @Override // android.os.Parcelable.Creator
            public TimeSlot createFromParcel(Parcel parcel) {
                return new TimeSlot(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public TimeSlot[] newArray(int i) {
                return new TimeSlot[i];
            }
        };
        private final long fromMillis;
        private final long toMillis;

        public TimeSlot(long j, long j2) {
            this.fromMillis = j;
            this.toMillis = j2;
        }

        public TimeSlot(Parcel parcel) {
            this.fromMillis = parcel.readLong();
            this.toMillis = parcel.readLong();
        }

        public int compareTo(TimeSlot timeSlot) {
            return (int) (this.fromMillis - timeSlot.fromMillis);
        }

        public int describeContents() {
            return 0;
        }

        public long getFromMillis() {
            return this.fromMillis;
        }

        public long getToMillis() {
            return this.toMillis;
        }

        public String toString() {
            return "TimeSlot{" + " fromMillis : '" + this.fromMillis + '\'' + ", toMillis : '" + this.toMillis + '\'' + '}';
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.fromMillis);
            parcel.writeLong(this.toMillis);
        }
    }

    public CalendarDay(String str) {
        this.day = str;
    }

    public String getDay() {
        return this.day;
    }

    public Map<PartOfDay, List<TimeSlot>> getTimeSlotsMap() {
        return this.timeSlotsMap;
    }
}
