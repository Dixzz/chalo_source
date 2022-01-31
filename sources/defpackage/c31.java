package defpackage;

import android.os.Bundle;
import java.util.HashMap;

/* renamed from: c31  reason: default package */
/* compiled from: ActiveSuperPassFragmentArgs */
public class c31 implements wi {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f512a = new HashMap();

    public static c31 fromBundle(Bundle bundle) {
        c31 c31 = new c31();
        bundle.setClassLoader(c31.class.getClassLoader());
        if (bundle.containsKey("arg_source")) {
            String string = bundle.getString("arg_source");
            if (string != null) {
                c31.f512a.put("arg_source", string);
            } else {
                throw new IllegalArgumentException("Argument \"arg_source\" is marked as non-null but was passed a null value.");
            }
        } else {
            c31.f512a.put("arg_source", "\"\"");
        }
        return c31;
    }

    public String a() {
        return (String) this.f512a.get("arg_source");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c31.class != obj.getClass()) {
            return false;
        }
        c31 c31 = (c31) obj;
        if (this.f512a.containsKey("arg_source") != c31.f512a.containsKey("arg_source")) {
            return false;
        }
        return a() == null ? c31.a() == null : a().equals(c31.a());
    }

    public int hashCode() {
        return 31 + (a() != null ? a().hashCode() : 0);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("ActiveSuperPassFragmentArgs{argSource=");
        i0.append(a());
        i0.append("}");
        return i0.toString();
    }
}
