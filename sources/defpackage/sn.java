package defpackage;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* renamed from: sn  reason: default package */
/* compiled from: TransitionValues */
public class sn {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Object> f3229a = new HashMap();
    public View b;
    public final ArrayList<kn> c = new ArrayList<>();

    @Deprecated
    public sn() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof sn)) {
            return false;
        }
        sn snVar = (sn) obj;
        return this.b == snVar.b && this.f3229a.equals(snVar.f3229a);
    }

    public int hashCode() {
        return this.f3229a.hashCode() + (this.b.hashCode() * 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("TransitionValues@");
        i0.append(Integer.toHexString(hashCode()));
        i0.append(":\n");
        StringBuilder k0 = hj1.k0(i0.toString(), "    view = ");
        k0.append(this.b);
        k0.append("\n");
        String S = hj1.S(k0.toString(), "    values:");
        for (String str : this.f3229a.keySet()) {
            S = S + "    " + str + ": " + this.f3229a.get(str) + "\n";
        }
        return S;
    }

    public sn(View view) {
        this.b = view;
    }
}
