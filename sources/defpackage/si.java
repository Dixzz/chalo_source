package defpackage;

import android.os.Bundle;

/* renamed from: si  reason: default package */
/* compiled from: ActionOnlyNavDirections */
public final class si implements fj {

    /* renamed from: a  reason: collision with root package name */
    public final int f3214a;

    public si(int i) {
        this.f3214a = i;
    }

    @Override // defpackage.fj
    public int a() {
        return this.f3214a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && si.class == obj.getClass() && this.f3214a == ((si) obj).f3214a;
    }

    @Override // defpackage.fj
    public Bundle getArguments() {
        return new Bundle();
    }

    public int hashCode() {
        return 31 + this.f3214a;
    }

    public String toString() {
        return hj1.X(hj1.i0("ActionOnlyNavDirections(actionId="), this.f3214a, ")");
    }
}
