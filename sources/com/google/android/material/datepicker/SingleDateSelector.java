package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.android.material.R;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = new b();
    public Long f;

    public class a extends tl4 {
        public final /* synthetic */ lm4 l;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, lm4 lm4) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.l = lm4;
        }

        @Override // defpackage.tl4
        public void a(Long l2) {
            if (l2 == null) {
                SingleDateSelector.this.f = null;
            } else {
                SingleDateSelector.this.f = Long.valueOf(l2.longValue());
            }
            this.l.b(SingleDateSelector.this.f);
        }
    }

    public static class b implements Parcelable.Creator<SingleDateSelector> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public SingleDateSelector createFromParcel(Parcel parcel) {
            SingleDateSelector singleDateSelector = new SingleDateSelector();
            singleDateSelector.f = (Long) parcel.readValue(Long.class.getClassLoader());
            return singleDateSelector;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public SingleDateSelector[] newArray(int i) {
            return new SingleDateSelector[i];
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String A(Context context) {
        Resources resources = context.getResources();
        Long l = this.f;
        if (l == null) {
            return resources.getString(R.string.mtrl_picker_date_header_unselected);
        }
        String v1 = hd3.v1(l.longValue());
        return resources.getString(R.string.mtrl_picker_date_header_selected, v1);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection<u7<Long, Long>> E() {
        return new ArrayList();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean F0() {
        return this.f != null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection<Long> K0() {
        ArrayList arrayList = new ArrayList();
        Long l = this.f;
        if (l != null) {
            arrayList.add(l);
        }
        return arrayList;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.material.datepicker.DateSelector
    public Long Q0() {
        return this.f;
    }

    public void a(Object obj) {
        Long l;
        Long l2 = (Long) obj;
        if (l2 == null) {
            l = null;
        } else {
            l = Long.valueOf(pm4.a(l2.longValue()));
        }
        this.f = l;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void d1(long j) {
        this.f = Long.valueOf(j);
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View m0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, lm4<Long> lm4) {
        View inflate = layoutInflater.inflate(R.layout.mtrl_picker_text_input_date, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_date);
        EditText editText = textInputLayout.getEditText();
        String str = Build.MANUFACTURER;
        Locale locale = Locale.ENGLISH;
        if (str.toLowerCase(locale).equals("lge") || str.toLowerCase(locale).equals("samsung")) {
            editText.setInputType(17);
        }
        AtomicReference<om4> atomicReference = pm4.f2830a;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(((SimpleDateFormat) DateFormat.getDateInstance(3, Locale.getDefault())).toLocalizedPattern().replaceAll("\\s+", ""), Locale.getDefault());
        simpleDateFormat.setTimeZone(pm4.e());
        simpleDateFormat.setLenient(false);
        Resources resources = inflate.getResources();
        String replaceAll = simpleDateFormat.toLocalizedPattern().replaceAll("d", resources.getString(R.string.mtrl_picker_text_input_day_abbr)).replaceAll("M", resources.getString(R.string.mtrl_picker_text_input_month_abbr)).replaceAll("y", resources.getString(R.string.mtrl_picker_text_input_year_abbr));
        textInputLayout.setPlaceholderText(replaceAll);
        Long l = this.f;
        if (l != null) {
            editText.setText(simpleDateFormat.format(l));
        }
        editText.addTextChangedListener(new a(replaceAll, simpleDateFormat, textInputLayout, calendarConstraints, lm4));
        editText.requestFocus();
        editText.post(new nn4(editText));
        return inflate;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.f);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int z0(Context context) {
        return hd3.G2(context, R.attr.materialCalendarTheme, em4.class.getCanonicalName());
    }
}
