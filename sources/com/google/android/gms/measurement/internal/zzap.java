package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import j$.lang.Iterable;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.Spliterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzap extends AbstractSafeParcelable implements Iterable<String>, Iterable {
    public static final Parcelable.Creator<zzap> CREATOR = new p64();
    public final Bundle f;

    public zzap(Bundle bundle) {
        this.f = bundle;
    }

    @Override // j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    @Override // j$.lang.Iterable, java.lang.Iterable
    public final Iterator<String> iterator() {
        return new o64(this);
    }

    public final Object l1(String str) {
        return this.f.get(str);
    }

    public final Bundle m1() {
        return new Bundle(this.f);
    }

    public final Long n1(String str) {
        return Long.valueOf(this.f.getLong(str));
    }

    public final Double o1(String str) {
        return Double.valueOf(this.f.getDouble(str));
    }

    public final String p1(String str) {
        return this.f.getString(str);
    }

    /* Return type fixed from 'j$.util.Spliterator' to match base method */
    @Override // j$.lang.Iterable, java.lang.Iterable
    public /* synthetic */ Spliterator<String> spliterator() {
        return Iterable.CC.$default$spliterator(this);
    }

    public final String toString() {
        return this.f.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.t0(parcel, 2, m1(), false);
        gj1.H1(parcel, o1);
    }
}
