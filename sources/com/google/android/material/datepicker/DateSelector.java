package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Collection;

public interface DateSelector<S> extends Parcelable {
    String A(Context context);

    Collection<u7<Long, Long>> E();

    boolean F0();

    Collection<Long> K0();

    S Q0();

    void d1(long j);

    View m0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, lm4<S> lm4);

    int z0(Context context);
}
