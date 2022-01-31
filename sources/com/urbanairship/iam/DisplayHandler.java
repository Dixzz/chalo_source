package com.urbanairship.iam;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import com.urbanairship.Autopilot;
import com.urbanairship.UAirship;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class DisplayHandler implements Parcelable {
    public static final Parcelable.Creator<DisplayHandler> CREATOR = new a();
    public final String f;

    public static class a implements Parcelable.Creator<DisplayHandler> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public DisplayHandler createFromParcel(Parcel parcel) {
            String readString = parcel.readString();
            if (readString == null) {
                readString = "";
            }
            return new DisplayHandler(readString);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public DisplayHandler[] newArray(int i) {
            return new DisplayHandler[i];
        }
    }

    public DisplayHandler(String str) {
        this.f = str;
    }

    public void a(xr5 xr5, long j) {
        dn5 b = b();
        if (b == null) {
            yj5.c("Takeoff not called. Unable to finish display for schedule: %s", this.f);
            return;
        }
        jr5 jr5 = b.i;
        String str = this.f;
        Objects.requireNonNull(jr5);
        yj5.h("Message finished for schedule %s.", str);
        wq5 remove = jr5.f1974a.remove(str);
        if (remove != null) {
            InAppMessage inAppMessage = remove.b;
            if (inAppMessage.l) {
                jr5.d.i(wr5.j(str, inAppMessage.m, xr5, j, remove.f));
            }
            hd3.K2(remove.b.j, jr5.c);
            synchronized (jr5.f) {
                Iterator it = new ArrayList(jr5.f).iterator();
                while (it.hasNext()) {
                    ((ir5) it.next()).b(str, remove.b, xr5);
                }
            }
            jr5.a(str);
            yj5.a("Display finished for schedule %s", remove.f3828a);
            new Handler(Looper.getMainLooper()).post(new vq5(remove));
            jr5.b.execute(new pr5(jr5, remove));
        }
        xq5 xq5 = xr5.g;
        if (xq5 != null && "cancel".equals(xq5.h)) {
            b.i(this.f);
        }
    }

    public final dn5 b() {
        if (UAirship.v || UAirship.u) {
            return (dn5) UAirship.l().k(dn5.class);
        }
        return null;
    }

    public boolean c(Context context) {
        Autopilot.d((Application) context.getApplicationContext(), false);
        dn5 b = b();
        if (b == null) {
            yj5.c("Takeoff not called. Unable to request display lock.", new Object[0]);
            return false;
        }
        jr5 jr5 = b.i;
        wq5 wq5 = jr5.f1974a.get(this.f);
        if (wq5 == null || !wq5.e) {
            return false;
        }
        return true;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f);
    }
}
