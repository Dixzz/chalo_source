package defpackage;

import android.os.Bundle;
import app.zophop.R;
import java.util.HashMap;

/* renamed from: g41  reason: default package */
/* compiled from: SoundInfoFragmentSuperPassDirections */
public class g41 implements fj {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1212a = new HashMap();

    public g41() {
    }

    @Override // defpackage.fj
    public int a() {
        return R.id.action_soundInfoFragmentSuperPass_to_soundFragmentSuperPass;
    }

    public boolean b() {
        return ((Boolean) this.f1212a.get("arg_can_show_sound_info")).booleanValue();
    }

    public String c() {
        return (String) this.f1212a.get("arg_source");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g41.class != obj.getClass()) {
            return false;
        }
        g41 g41 = (g41) obj;
        if (this.f1212a.containsKey("arg_source") != g41.f1212a.containsKey("arg_source")) {
            return false;
        }
        if (c() == null ? g41.c() == null : c().equals(g41.c())) {
            return this.f1212a.containsKey("arg_can_show_sound_info") == g41.f1212a.containsKey("arg_can_show_sound_info") && b() == g41.b();
        }
        return false;
    }

    @Override // defpackage.fj
    public Bundle getArguments() {
        Bundle bundle = new Bundle();
        if (this.f1212a.containsKey("arg_source")) {
            bundle.putString("arg_source", (String) this.f1212a.get("arg_source"));
        } else {
            bundle.putString("arg_source", "\"\"");
        }
        if (this.f1212a.containsKey("arg_can_show_sound_info")) {
            bundle.putBoolean("arg_can_show_sound_info", ((Boolean) this.f1212a.get("arg_can_show_sound_info")).booleanValue());
        } else {
            bundle.putBoolean("arg_can_show_sound_info", true);
        }
        return bundle;
    }

    public int hashCode() {
        return (((b() ? 1 : 0) + (((c() != null ? c().hashCode() : 0) + 31) * 31)) * 31) + R.id.action_soundInfoFragmentSuperPass_to_soundFragmentSuperPass;
    }

    public String toString() {
        StringBuilder j0 = hj1.j0("ActionSoundInfoFragmentSuperPassToSoundFragmentSuperPass(actionId=", R.id.action_soundInfoFragmentSuperPass_to_soundFragmentSuperPass, "){argSource=");
        j0.append(c());
        j0.append(", argCanShowSoundInfo=");
        j0.append(b());
        j0.append("}");
        return j0.toString();
    }

    public g41(f41 f41) {
    }
}
