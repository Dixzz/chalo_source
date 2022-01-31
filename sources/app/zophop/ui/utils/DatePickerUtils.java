package app.zophop.ui.utils;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.R;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.Month;
import com.google.android.material.datepicker.SingleDateSelector;
import j$.util.DesugarTimeZone;
import java.util.ArrayList;
import java.util.Calendar;

/* compiled from: DatePickerUtils.kt */
public final class DatePickerUtils {

    /* compiled from: DatePickerUtils.kt */
    public static final class CustomDateValidator implements CalendarConstraints.DateValidator {
        public static final a CREATOR = new a(null);
        public final long f;
        public final long g;

        /* compiled from: DatePickerUtils.kt */
        public static final class a implements Parcelable.Creator<CustomDateValidator> {
            public a(j86 j86) {
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public CustomDateValidator createFromParcel(Parcel parcel) {
                n86.e(parcel, "parcel");
                return new CustomDateValidator(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public CustomDateValidator[] newArray(int i) {
                return new CustomDateValidator[i];
            }
        }

        public CustomDateValidator(long j, long j2) {
            this.f = j;
            this.g = j2;
        }

        @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
        public boolean B0(long j) {
            long j2 = this.f;
            if (j2 == -1 && this.g == -1) {
                return true;
            }
            if (j > this.g || j2 > j) {
                return false;
            }
            return true;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            if (parcel != null) {
                parcel.writeLong(this.f);
            }
            if (parcel != null) {
                parcel.writeLong(this.g);
            }
        }

        public CustomDateValidator(Parcel parcel) {
            n86.e(parcel, "parcel");
            long readLong = parcel.readLong();
            long readLong2 = parcel.readLong();
            this.f = readLong;
            this.g = readLong2;
        }
    }

    public static final long a(long j, int i) {
        Calendar instance = Calendar.getInstance(DesugarTimeZone.getTimeZone("UTC"));
        instance.setTimeInMillis(j);
        instance.add(5, i);
        return instance.getTimeInMillis();
    }

    public static final em4<Long> b(String str, long j, long j2, long j3) {
        Month month;
        n86.e(str, "lTitle");
        SingleDateSelector singleDateSelector = new SingleDateSelector();
        Long valueOf = Long.valueOf(j);
        CalendarConstraints.b bVar = new CalendarConstraints.b();
        Calendar.getInstance(DesugarTimeZone.getTimeZone("UTC")).setTimeInMillis(j2);
        bVar.f624a = j2;
        bVar.b = j3;
        bVar.d = new CustomDateValidator(j2, j3);
        CalendarConstraints a2 = bVar.a();
        int i = R.string.mtrl_picker_date_header_title;
        if (valueOf != null) {
            singleDateSelector.a(valueOf);
        }
        if (a2.i == null) {
            long j4 = a2.f.k;
            long j5 = a2.g.k;
            if (!((ArrayList) singleDateSelector.K0()).isEmpty()) {
                long longValue = ((Long) ((ArrayList) singleDateSelector.K0()).iterator().next()).longValue();
                if (longValue >= j4 && longValue <= j5) {
                    month = Month.f(longValue);
                    a2.i = month;
                }
            }
            int i2 = em4.w;
            long j6 = Month.g().k;
            if (j4 <= j6 && j6 <= j5) {
                j4 = j6;
            }
            month = Month.f(j4);
            a2.i = month;
        }
        em4<Long> em4 = new em4<>();
        Bundle bundle = new Bundle();
        bundle.putInt("OVERRIDE_THEME_RES_ID", app.zophop.R.style.ThemeOverlay_App_DatePicker);
        bundle.putParcelable("DATE_SELECTOR_KEY", singleDateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", a2);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", i);
        bundle.putCharSequence("TITLE_TEXT_KEY", str);
        bundle.putInt("INPUT_MODE_KEY", 0);
        em4.setArguments(bundle);
        n86.d(em4, "lDatePickerBuilder.build()");
        return em4;
    }
}
