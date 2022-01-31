package defpackage;

import android.view.ViewTreeObserver;

/* renamed from: an4  reason: default package */
/* compiled from: FloatingActionButtonImpl */
public class an4 implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ ym4 f;

    public an4(ym4 ym4) {
        this.f = ym4;
    }

    public boolean onPreDraw() {
        ym4 ym4 = this.f;
        float rotation = ym4.s.getRotation();
        if (ym4.m == rotation) {
            return true;
        }
        ym4.m = rotation;
        ym4.s();
        return true;
    }
}
