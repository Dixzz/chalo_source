package defpackage;

import android.os.Bundle;
import app.zophop.R;
import java.util.HashMap;

/* renamed from: t21  reason: default package */
/* compiled from: ActivateSuperPassFragmentDirections */
public class t21 implements fj {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f3298a = new HashMap();

    public t21() {
    }

    @Override // defpackage.fj
    public int a() {
        return R.id.action_activateSuperPassFragment_to_soundFragmentSuperPass;
    }

    public boolean b() {
        return ((Boolean) this.f3298a.get("arg_can_show_sound_info")).booleanValue();
    }

    public String c() {
        return (String) this.f3298a.get("arg_source");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || t21.class != obj.getClass()) {
            return false;
        }
        t21 t21 = (t21) obj;
        if (this.f3298a.containsKey("arg_source") != t21.f3298a.containsKey("arg_source")) {
            return false;
        }
        if (c() == null ? t21.c() == null : c().equals(t21.c())) {
            return this.f3298a.containsKey("arg_can_show_sound_info") == t21.f3298a.containsKey("arg_can_show_sound_info") && b() == t21.b();
        }
        return false;
    }

    @Override // defpackage.fj
    public Bundle getArguments() {
        Bundle bundle = new Bundle();
        if (this.f3298a.containsKey("arg_source")) {
            bundle.putString("arg_source", (String) this.f3298a.get("arg_source"));
        } else {
            bundle.putString("arg_source", "\"\"");
        }
        if (this.f3298a.containsKey("arg_can_show_sound_info")) {
            bundle.putBoolean("arg_can_show_sound_info", ((Boolean) this.f3298a.get("arg_can_show_sound_info")).booleanValue());
        } else {
            bundle.putBoolean("arg_can_show_sound_info", true);
        }
        return bundle;
    }

    public int hashCode() {
        return (((b() ? 1 : 0) + (((c() != null ? c().hashCode() : 0) + 31) * 31)) * 31) + R.id.action_activateSuperPassFragment_to_soundFragmentSuperPass;
    }

    public String toString() {
        StringBuilder j0 = hj1.j0("ActionActivateSuperPassFragmentToSoundFragmentSuperPass(actionId=", R.id.action_activateSuperPassFragment_to_soundFragmentSuperPass, "){argSource=");
        j0.append(c());
        j0.append(", argCanShowSoundInfo=");
        j0.append(b());
        j0.append("}");
        return j0.toString();
    }

    public t21(q21 q21) {
    }
}
