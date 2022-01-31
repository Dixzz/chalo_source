package defpackage;

import android.os.Bundle;
import java.util.HashMap;

/* renamed from: q31  reason: default package */
/* compiled from: ActiveSuperPassVisualValidationFragmentArgs */
public class q31 implements wi {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f2892a = new HashMap();

    public static q31 fromBundle(Bundle bundle) {
        q31 q31 = new q31();
        bundle.setClassLoader(q31.class.getClassLoader());
        if (bundle.containsKey("arg_source")) {
            String string = bundle.getString("arg_source");
            if (string != null) {
                q31.f2892a.put("arg_source", string);
            } else {
                throw new IllegalArgumentException("Argument \"arg_source\" is marked as non-null but was passed a null value.");
            }
        } else {
            q31.f2892a.put("arg_source", "\"\"");
        }
        return q31;
    }

    public String a() {
        return (String) this.f2892a.get("arg_source");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || q31.class != obj.getClass()) {
            return false;
        }
        q31 q31 = (q31) obj;
        if (this.f2892a.containsKey("arg_source") != q31.f2892a.containsKey("arg_source")) {
            return false;
        }
        return a() == null ? q31.a() == null : a().equals(q31.a());
    }

    public int hashCode() {
        return 31 + (a() != null ? a().hashCode() : 0);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("ActiveSuperPassVisualValidationFragmentArgs{argSource=");
        i0.append(a());
        i0.append("}");
        return i0.toString();
    }
}
