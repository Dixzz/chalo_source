package defpackage;

import android.os.Bundle;
import java.util.HashMap;

/* renamed from: i41  reason: default package */
/* compiled from: SoundInfoRationaleFragmentSuperPassArgs */
public class i41 implements wi {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1473a = new HashMap();

    public static i41 fromBundle(Bundle bundle) {
        i41 i41 = new i41();
        bundle.setClassLoader(i41.class.getClassLoader());
        if (bundle.containsKey("arg_source")) {
            String string = bundle.getString("arg_source");
            if (string != null) {
                i41.f1473a.put("arg_source", string);
            } else {
                throw new IllegalArgumentException("Argument \"arg_source\" is marked as non-null but was passed a null value.");
            }
        } else {
            i41.f1473a.put("arg_source", "\"\"");
        }
        return i41;
    }

    public String a() {
        return (String) this.f1473a.get("arg_source");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i41.class != obj.getClass()) {
            return false;
        }
        i41 i41 = (i41) obj;
        if (this.f1473a.containsKey("arg_source") != i41.f1473a.containsKey("arg_source")) {
            return false;
        }
        return a() == null ? i41.a() == null : a().equals(i41.a());
    }

    public int hashCode() {
        return 31 + (a() != null ? a().hashCode() : 0);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("SoundInfoRationaleFragmentSuperPassArgs{argSource=");
        i0.append(a());
        i0.append("}");
        return i0.toString();
    }
}
