package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

@KeepName
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    @RecentlyNonNull
    public static final Parcelable.Creator<DataHolder> CREATOR = new u72();
    public final int f;
    public final String[] g;
    public Bundle h;
    public final CursorWindow[] i;
    public final int j;
    public final Bundle k;
    public int[] l;
    public boolean m = false;
    public boolean n = true;

    static {
        Objects.requireNonNull(new String[0], "null reference");
        new ArrayList();
        new HashMap();
    }

    public DataHolder(int i2, String[] strArr, CursorWindow[] cursorWindowArr, int i3, Bundle bundle) {
        this.f = i2;
        this.g = strArr;
        this.i = cursorWindowArr;
        this.j = i3;
        this.k = bundle;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (!this.m) {
                this.m = true;
                int i2 = 0;
                while (true) {
                    CursorWindow[] cursorWindowArr = this.i;
                    if (i2 >= cursorWindowArr.length) {
                        break;
                    }
                    cursorWindowArr[i2].close();
                    i2++;
                }
            }
        }
    }

    @Override // java.lang.Object
    public final void finalize() throws Throwable {
        boolean z;
        try {
            if (this.n && this.i.length > 0) {
                synchronized (this) {
                    z = this.m;
                }
                if (!z) {
                    close();
                    String.valueOf(toString()).length();
                }
            }
        } finally {
            super.finalize();
        }
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.C0(parcel, 1, this.g, false);
        gj1.E0(parcel, 2, this.i, i2, false);
        int i3 = this.j;
        parcel.writeInt(262147);
        parcel.writeInt(i3);
        gj1.t0(parcel, 4, this.k, false);
        int i4 = this.f;
        parcel.writeInt(263144);
        parcel.writeInt(i4);
        gj1.H1(parcel, o1);
        if ((i2 & 1) != 0) {
            close();
        }
    }
}
