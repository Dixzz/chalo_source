package defpackage;

import android.os.Bundle;
import java.util.HashMap;

/* renamed from: e41  reason: default package */
/* compiled from: SoundInfoFragmentSuperPassArgs */
public class e41 implements wi {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f923a = new HashMap();

    public static e41 fromBundle(Bundle bundle) {
        e41 e41 = new e41();
        bundle.setClassLoader(e41.class.getClassLoader());
        if (bundle.containsKey("arg_source")) {
            String string = bundle.getString("arg_source");
            if (string != null) {
                e41.f923a.put("arg_source", string);
            } else {
                throw new IllegalArgumentException("Argument \"arg_source\" is marked as non-null but was passed a null value.");
            }
        } else {
            e41.f923a.put("arg_source", "\"\"");
        }
        return e41;
    }

    public String a() {
        return (String) this.f923a.get("arg_source");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e41.class != obj.getClass()) {
            return false;
        }
        e41 e41 = (e41) obj;
        if (this.f923a.containsKey("arg_source") != e41.f923a.containsKey("arg_source")) {
            return false;
        }
        return a() == null ? e41.a() == null : a().equals(e41.a());
    }

    public int hashCode() {
        return 31 + (a() != null ? a().hashCode() : 0);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("SoundInfoFragmentSuperPassArgs{argSource=");
        i0.append(a());
        i0.append("}");
        return i0.toString();
    }
}
