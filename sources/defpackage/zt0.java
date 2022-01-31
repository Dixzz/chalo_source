package defpackage;

import android.os.Bundle;
import java.util.HashMap;

/* renamed from: zt0  reason: default package */
/* compiled from: CitySelectionFragmentArgs */
public class zt0 implements wi {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f4208a = new HashMap();

    public static zt0 fromBundle(Bundle bundle) {
        zt0 zt0 = new zt0();
        bundle.setClassLoader(zt0.class.getClassLoader());
        if (bundle.containsKey("isFromSplash")) {
            zt0.f4208a.put("isFromSplash", Boolean.valueOf(bundle.getBoolean("isFromSplash")));
        } else {
            zt0.f4208a.put("isFromSplash", Boolean.FALSE);
        }
        return zt0;
    }

    public boolean a() {
        return ((Boolean) this.f4208a.get("isFromSplash")).booleanValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zt0.class != obj.getClass()) {
            return false;
        }
        zt0 zt0 = (zt0) obj;
        return this.f4208a.containsKey("isFromSplash") == zt0.f4208a.containsKey("isFromSplash") && a() == zt0.a();
    }

    public int hashCode() {
        return 31 + (a() ? 1 : 0);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("CitySelectionFragmentArgs{isFromSplash=");
        i0.append(a());
        i0.append("}");
        return i0.toString();
    }
}
