package defpackage;

import android.os.Bundle;
import java.util.HashMap;

/* renamed from: av0  reason: default package */
/* compiled from: LanguageSelectSplashScreenArgs */
public class av0 implements wi {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f334a = new HashMap();

    public static av0 fromBundle(Bundle bundle) {
        av0 av0 = new av0();
        bundle.setClassLoader(av0.class.getClassLoader());
        if (bundle.containsKey("isFromSplash")) {
            av0.f334a.put("isFromSplash", Boolean.valueOf(bundle.getBoolean("isFromSplash")));
        } else {
            av0.f334a.put("isFromSplash", Boolean.FALSE);
        }
        return av0;
    }

    public boolean a() {
        return ((Boolean) this.f334a.get("isFromSplash")).booleanValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || av0.class != obj.getClass()) {
            return false;
        }
        av0 av0 = (av0) obj;
        return this.f334a.containsKey("isFromSplash") == av0.f334a.containsKey("isFromSplash") && a() == av0.a();
    }

    public int hashCode() {
        return 31 + (a() ? 1 : 0);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("LanguageSelectSplashScreenArgs{isFromSplash=");
        i0.append(a());
        i0.append("}");
        return i0.toString();
    }
}
