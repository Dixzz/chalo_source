package com.urbanairship.automation;

import android.os.Parcel;
import android.os.Parcelable;
import app.zophop.models.mTicketing.ProductPromotionsObject;
import com.razorpay.AnalyticsConstants;
import com.urbanairship.json.JsonValue;
import defpackage.zt5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class ScheduleDelay implements Parcelable, cu5 {
    public static final Parcelable.Creator<ScheduleDelay> CREATOR = new a();
    public final long f;
    public final List<String> g;
    public final int h;
    public final String i;
    public final List<Trigger> j;

    public static class a implements Parcelable.Creator<ScheduleDelay> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public ScheduleDelay createFromParcel(Parcel parcel) {
            return new ScheduleDelay(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public ScheduleDelay[] newArray(int i) {
            return new ScheduleDelay[i];
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f722a;
        public List<String> b;
        public int c = 1;
        public String d = null;
        public final List<Trigger> e = new ArrayList();

        public ScheduleDelay a() {
            if (((long) this.e.size()) <= 10) {
                return new ScheduleDelay(this);
            }
            throw new IllegalArgumentException("No more than 10 cancellation triggers allowed.");
        }
    }

    public ScheduleDelay(b bVar) {
        List<String> list;
        this.f = bVar.f722a;
        if (bVar.b == null) {
            list = Collections.emptyList();
        } else {
            list = new ArrayList<>(bVar.b);
        }
        this.g = list;
        this.h = bVar.c;
        this.i = bVar.d;
        this.j = bVar.e;
    }

    public static ScheduleDelay a(JsonValue jsonValue) throws xt5 {
        zt5 n = jsonValue.n();
        b bVar = new b();
        bVar.f722a = n.u("seconds").g(0);
        String i2 = n.u("app_state").i();
        if (i2 == null) {
            i2 = "any";
        }
        String lowerCase = i2.toLowerCase(Locale.ROOT);
        lowerCase.hashCode();
        lowerCase.hashCode();
        int i3 = 1;
        char c = 65535;
        switch (lowerCase.hashCode()) {
            case -1332194002:
                if (lowerCase.equals(ProductPromotionsObject.KEY_BACKGROUND)) {
                    c = 0;
                    break;
                }
                break;
            case 96748:
                if (lowerCase.equals("any")) {
                    c = 1;
                    break;
                }
                break;
            case 1984457027:
                if (lowerCase.equals("foreground")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                i3 = 3;
                break;
            case 1:
                break;
            case 2:
                i3 = 2;
                break;
            default:
                throw new xt5(hj1.S("Invalid app state: ", lowerCase));
        }
        bVar.c = i3;
        if (n.f.containsKey(AnalyticsConstants.SCREEN)) {
            JsonValue u = n.u(AnalyticsConstants.SCREEN);
            if (u.f instanceof String) {
                bVar.b = Collections.singletonList(u.o());
            } else {
                yt5 m = u.m();
                bVar.b = new ArrayList();
                Iterator<JsonValue> it = m.iterator();
                while (it.hasNext()) {
                    JsonValue next = it.next();
                    if (next.i() != null) {
                        bVar.b.add(next.i());
                    }
                }
            }
        }
        if (n.f.containsKey("region_id")) {
            bVar.d = n.u("region_id").o();
        }
        Iterator<JsonValue> it2 = n.u("cancellation_triggers").m().iterator();
        while (it2.hasNext()) {
            bVar.e.add(Trigger.c(it2.next()));
        }
        try {
            return bVar.a();
        } catch (IllegalArgumentException e) {
            throw new xt5("Invalid schedule delay info", e);
        }
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        int i2 = this.h;
        String str = i2 != 1 ? i2 != 2 ? i2 != 3 ? null : ProductPromotionsObject.KEY_BACKGROUND : "foreground" : "any";
        zt5.b d = zt5.s().d("seconds", this.f);
        d.f("app_state", str);
        d.e(AnalyticsConstants.SCREEN, JsonValue.x(this.g));
        d.f("region_id", this.i);
        d.e("cancellation_triggers", JsonValue.x(this.j));
        return JsonValue.x(d.a());
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ScheduleDelay.class != obj.getClass()) {
            return false;
        }
        ScheduleDelay scheduleDelay = (ScheduleDelay) obj;
        if (this.f != scheduleDelay.f || this.h != scheduleDelay.h) {
            return false;
        }
        List<String> list = this.g;
        if (list == null ? scheduleDelay.g != null : !list.equals(scheduleDelay.g)) {
            return false;
        }
        String str = this.i;
        if (str == null ? scheduleDelay.i == null : str.equals(scheduleDelay.i)) {
            return this.j.equals(scheduleDelay.j);
        }
        return false;
    }

    public int hashCode() {
        long j2 = this.f;
        int i2 = ((int) (j2 ^ (j2 >>> 32))) * 31;
        List<String> list = this.g;
        int i3 = 0;
        int hashCode = (((i2 + (list != null ? list.hashCode() : 0)) * 31) + this.h) * 31;
        String str = this.i;
        if (str != null) {
            i3 = str.hashCode();
        }
        return this.j.hashCode() + ((hashCode + i3) * 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("ScheduleDelay{seconds=");
        i0.append(this.f);
        i0.append(", screens=");
        i0.append(this.g);
        i0.append(", appState=");
        i0.append(this.h);
        i0.append(", regionId='");
        hj1.U0(i0, this.i, '\'', ", cancellationTriggers=");
        i0.append(this.j);
        i0.append('}');
        return i0.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f);
        parcel.writeList(this.g);
        parcel.writeInt(this.h);
        parcel.writeString(this.i);
        parcel.writeTypedList(this.j);
    }

    public ScheduleDelay(Parcel parcel) {
        this.f = parcel.readLong();
        ArrayList arrayList = new ArrayList();
        this.g = arrayList;
        parcel.readList(arrayList, String.class.getClassLoader());
        int readInt = parcel.readInt();
        int i2 = 3;
        if (readInt == 1) {
            i2 = 1;
        } else if (readInt == 2) {
            i2 = 2;
        } else if (readInt != 3) {
            throw new IllegalStateException("Invalid app state from parcel.");
        }
        this.h = i2;
        this.i = parcel.readString();
        this.j = parcel.createTypedArrayList(Trigger.CREATOR);
    }
}
