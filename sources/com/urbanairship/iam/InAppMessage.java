package com.urbanairship.iam;

import android.os.Parcel;
import android.os.Parcelable;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.google.firebase.messaging.Constants;
import com.urbanairship.json.JsonValue;
import defpackage.zt5;
import java.util.HashMap;
import java.util.Map;

public class InAppMessage implements Parcelable, mn5 {
    public static final Parcelable.Creator<InAppMessage> CREATOR = new a();
    public final String f;
    public final zt5 g;
    public final String h;
    public final cu5 i;
    public final Map<String, JsonValue> j;
    public final String k;
    public final boolean l;
    public final String m;
    public final Map<String, JsonValue> n;

    public static class a implements Parcelable.Creator<InAppMessage> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public InAppMessage createFromParcel(Parcel parcel) {
            try {
                return InAppMessage.a(JsonValue.p(parcel.readString()), null);
            } catch (xt5 e) {
                yj5.c("InAppMessage - Invalid parcel: %s", e);
                return null;
            }
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public InAppMessage[] newArray(int i) {
            return new InAppMessage[i];
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f729a;
        public zt5 b;
        public String c;
        public cu5 d;
        public Map<String, JsonValue> e = new HashMap();
        public String f = "app-defined";
        public String g = ProductDiscountsObject.KEY_PRODUCT_TYPE_DEFAULT;
        public boolean h = true;
        public Map<String, JsonValue> i;

        public b(a aVar) {
        }

        public InAppMessage a() {
            String str = this.c;
            hd3.D(str == null || str.length() <= 1024, "Name exceeds max name length: 1024");
            hd3.E(this.f729a, "Missing type.");
            hd3.E(this.d, "Missing content.");
            return new InAppMessage(this, null);
        }
    }

    public InAppMessage(b bVar, a aVar) {
        this.f = bVar.f729a;
        this.i = bVar.d;
        this.h = bVar.c;
        zt5 zt5 = bVar.b;
        this.g = zt5 == null ? zt5.g : zt5;
        this.j = bVar.e;
        this.m = bVar.f;
        this.k = bVar.g;
        this.l = bVar.h;
        this.n = bVar.i;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x022c  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0379  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x0393  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x03ee  */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x0408  */
    /* JADX WARNING: Removed duplicated region for block: B:386:0x0799  */
    /* JADX WARNING: Removed duplicated region for block: B:394:0x07b3  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01b7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.urbanairship.iam.InAppMessage a(com.urbanairship.json.JsonValue r34, java.lang.String r35) throws defpackage.xt5 {
        /*
        // Method dump skipped, instructions count: 2712
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.iam.InAppMessage.a(com.urbanairship.json.JsonValue, java.lang.String):com.urbanairship.iam.InAppMessage");
    }

    public static b d() {
        return new b(null);
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        zt5.b s = zt5.s();
        s.i("name", this.h);
        s.i("extra", this.g);
        s.i(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION, this.i);
        s.i("display_type", this.f);
        s.i("actions", this.j);
        s.i("source", this.m);
        s.i("display_behavior", this.k);
        s.i("reporting_enabled", Boolean.valueOf(this.l));
        s.i("rendered_locale", this.n);
        return JsonValue.x(s.a());
    }

    public <T extends zq5> T c() {
        cu5 cu5 = this.i;
        if (cu5 == null) {
            return null;
        }
        try {
            return (T) ((zq5) cu5);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || InAppMessage.class != obj.getClass()) {
            return false;
        }
        InAppMessage inAppMessage = (InAppMessage) obj;
        if (!this.k.equals(inAppMessage.k) || this.l != inAppMessage.l || !this.f.equals(inAppMessage.f) || !this.g.equals(inAppMessage.g)) {
            return false;
        }
        String str = this.h;
        if (str == null ? inAppMessage.h != null : !str.equals(inAppMessage.h)) {
            return false;
        }
        if (!this.i.equals(inAppMessage.i) || !this.j.equals(inAppMessage.j)) {
            return false;
        }
        Map<String, JsonValue> map = this.n;
        if (map == null ? inAppMessage.n == null : map.equals(inAppMessage.n)) {
            return this.m.equals(inAppMessage.m);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (this.g.hashCode() + (this.f.hashCode() * 31)) * 31;
        String str = this.h;
        int i2 = 0;
        int hashCode2 = str != null ? str.hashCode() : 0;
        int hashCode3 = (this.j.hashCode() + ((this.i.hashCode() + ((hashCode + hashCode2) * 31)) * 31)) * 31;
        Map<String, JsonValue> map = this.n;
        if (map != null) {
            i2 = map.hashCode();
        }
        return this.m.hashCode() + ((hj1.r0(this.k, (hashCode3 + i2) * 31, 31) + (this.l ? 1 : 0)) * 31);
    }

    public String toString() {
        return b().toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(b().toString());
    }
}
