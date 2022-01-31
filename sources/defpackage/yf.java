package defpackage;

import androidx.fragment.app.Fragment;
import defpackage.zg;

/* renamed from: yf  reason: default package */
/* compiled from: FragmentViewLifecycleOwner */
public class yf implements mm, hi {
    public final gi f;
    public gh g = null;
    public lm h = null;

    public yf(Fragment fragment, gi giVar) {
        this.f = giVar;
    }

    public void a(zg.a aVar) {
        gh ghVar = this.g;
        ghVar.d("handleLifecycleEvent");
        ghVar.g(aVar.getTargetState());
    }

    public void b() {
        if (this.g == null) {
            this.g = new gh(this);
            this.h = new lm(this);
        }
    }

    @Override // defpackage.fh
    public zg getLifecycle() {
        b();
        return this.g;
    }

    @Override // defpackage.mm
    public km getSavedStateRegistry() {
        b();
        return this.h.b;
    }

    @Override // defpackage.hi
    public gi getViewModelStore() {
        b();
        return this.f;
    }
}
