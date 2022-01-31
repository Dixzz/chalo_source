package defpackage;

import android.os.Bundle;
import java.util.HashMap;

/* renamed from: a41  reason: default package */
/* compiled from: SoundFragmentSuperPassArgs */
public class a41 implements wi {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f109a = new HashMap();

    public static a41 fromBundle(Bundle bundle) {
        a41 a41 = new a41();
        bundle.setClassLoader(a41.class.getClassLoader());
        if (bundle.containsKey("arg_source")) {
            String string = bundle.getString("arg_source");
            if (string != null) {
                a41.f109a.put("arg_source", string);
            } else {
                throw new IllegalArgumentException("Argument \"arg_source\" is marked as non-null but was passed a null value.");
            }
        } else {
            a41.f109a.put("arg_source", "\"\"");
        }
        if (bundle.containsKey("arg_can_show_sound_info")) {
            a41.f109a.put("arg_can_show_sound_info", Boolean.valueOf(bundle.getBoolean("arg_can_show_sound_info")));
        } else {
            a41.f109a.put("arg_can_show_sound_info", Boolean.TRUE);
        }
        return a41;
    }

    public boolean a() {
        return ((Boolean) this.f109a.get("arg_can_show_sound_info")).booleanValue();
    }

    public String b() {
        return (String) this.f109a.get("arg_source");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a41.class != obj.getClass()) {
            return false;
        }
        a41 a41 = (a41) obj;
        if (this.f109a.containsKey("arg_source") != a41.f109a.containsKey("arg_source")) {
            return false;
        }
        if (b() == null ? a41.b() == null : b().equals(a41.b())) {
            return this.f109a.containsKey("arg_can_show_sound_info") == a41.f109a.containsKey("arg_can_show_sound_info") && a() == a41.a();
        }
        return false;
    }

    public int hashCode() {
        return (((b() != null ? b().hashCode() : 0) + 31) * 31) + (a() ? 1 : 0);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("SoundFragmentSuperPassArgs{argSource=");
        i0.append(b());
        i0.append(", argCanShowSoundInfo=");
        i0.append(a());
        i0.append("}");
        return i0.toString();
    }
}
