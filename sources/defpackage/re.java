package defpackage;

import android.graphics.Rect;
import android.view.View;

/* renamed from: re  reason: default package */
/* compiled from: DefaultSpecialEffectsController */
public class re implements Runnable {
    public final /* synthetic */ vf f;
    public final /* synthetic */ View g;
    public final /* synthetic */ Rect h;

    public re(le leVar, vf vfVar, View view, Rect rect) {
        this.f = vfVar;
        this.g = view;
        this.h = rect;
    }

    public void run() {
        this.f.j(this.g, this.h);
    }
}
