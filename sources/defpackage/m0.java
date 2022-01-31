package defpackage;

import android.view.View;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: m0  reason: default package */
/* compiled from: AppCompatDelegateImpl */
public class m0 extends a9 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i0 f2300a;

    public m0(i0 i0Var) {
        this.f2300a = i0Var;
    }

    @Override // defpackage.a9, defpackage.z8
    public void onAnimationEnd(View view) {
        this.f2300a.t.setAlpha(1.0f);
        this.f2300a.w.d(null);
        this.f2300a.w = null;
    }

    @Override // defpackage.a9, defpackage.z8
    public void onAnimationStart(View view) {
        this.f2300a.t.setVisibility(0);
        this.f2300a.t.sendAccessibilityEvent(32);
        if (this.f2300a.t.getParent() instanceof View) {
            AtomicInteger atomicInteger = r8.f3055a;
            ((View) this.f2300a.t.getParent()).requestApplyInsets();
        }
    }
}
