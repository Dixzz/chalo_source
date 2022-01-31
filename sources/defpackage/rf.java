package defpackage;

import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.Fragment;

/* renamed from: rf  reason: default package */
/* compiled from: FragmentTransition */
public class rf implements Runnable {
    public final /* synthetic */ Fragment f;
    public final /* synthetic */ Fragment g;
    public final /* synthetic */ boolean h;
    public final /* synthetic */ n2 i;
    public final /* synthetic */ View j;
    public final /* synthetic */ vf k;
    public final /* synthetic */ Rect l;

    public rf(Fragment fragment, Fragment fragment2, boolean z, n2 n2Var, View view, vf vfVar, Rect rect) {
        this.f = fragment;
        this.g = fragment2;
        this.h = z;
        this.i = n2Var;
        this.j = view;
        this.k = vfVar;
        this.l = rect;
    }

    public void run() {
        tf.c(this.f, this.g, this.h, this.i, false);
        View view = this.j;
        if (view != null) {
            this.k.j(view, this.l);
        }
    }
}
