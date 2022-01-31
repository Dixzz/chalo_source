package defpackage;

import android.os.Bundle;
import androidx.savedstate.Recreator;
import androidx.savedstate.SavedStateRegistry$1;
import defpackage.km;
import defpackage.zg;
import java.util.Map;
import java.util.Objects;

/* renamed from: lm  reason: default package */
/* compiled from: SavedStateRegistryController */
public final class lm {

    /* renamed from: a  reason: collision with root package name */
    public final mm f2237a;
    public final km b = new km();

    public lm(mm mmVar) {
        this.f2237a = mmVar;
    }

    public void a(Bundle bundle) {
        zg lifecycle = this.f2237a.getLifecycle();
        if (((gh) lifecycle).c == zg.b.INITIALIZED) {
            lifecycle.a(new Recreator(this.f2237a));
            km kmVar = this.b;
            if (!kmVar.c) {
                if (bundle != null) {
                    kmVar.b = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
                }
                lifecycle.a(new SavedStateRegistry$1(kmVar));
                kmVar.c = true;
                return;
            }
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
    }

    public void b(Bundle bundle) {
        km kmVar = this.b;
        Objects.requireNonNull(kmVar);
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = kmVar.b;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        g2<K, V>.d d = kmVar.f2077a.d();
        while (d.hasNext()) {
            Map.Entry entry = (Map.Entry) d.next();
            bundle2.putBundle((String) entry.getKey(), ((km.b) entry.getValue()).a());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }
}
