package defpackage;

import com.firebase.geofire.GeoLocation;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* renamed from: zz  reason: default package */
/* compiled from: AirshipAnalyticsEvent.kt */
public final class zz {

    /* renamed from: a  reason: collision with root package name */
    public final String f4231a;
    public final Map<String, Object> b;

    public zz(String str, Map<String, Object> map) {
        n86.e(str, "eventName");
        n86.e(map, "eventPropertiesMap");
        this.f4231a = str;
        this.b = map;
    }

    public final void a(String str, Object obj) {
        n86.e(str, "lPropertyName");
        if ((obj instanceof String) || (obj instanceof Integer) || (obj instanceof Date) || (obj instanceof Double) || (obj instanceof GeoLocation)) {
            this.b.put(str, obj);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ zz(String str, Map map, int i) {
        this(str, (i & 2) != 0 ? new HashMap() : null);
    }
}
