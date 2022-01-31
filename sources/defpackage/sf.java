package defpackage;

import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.Fragment;
import defpackage.tf;
import java.util.ArrayList;

/* renamed from: sf  reason: default package */
/* compiled from: FragmentTransition */
public class sf implements Runnable {
    public final /* synthetic */ vf f;
    public final /* synthetic */ n2 g;
    public final /* synthetic */ Object h;
    public final /* synthetic */ tf.b i;
    public final /* synthetic */ ArrayList j;
    public final /* synthetic */ View k;
    public final /* synthetic */ Fragment l;
    public final /* synthetic */ Fragment m;
    public final /* synthetic */ boolean n;
    public final /* synthetic */ ArrayList o;
    public final /* synthetic */ Object p;
    public final /* synthetic */ Rect q;

    public sf(vf vfVar, n2 n2Var, Object obj, tf.b bVar, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
        this.f = vfVar;
        this.g = n2Var;
        this.h = obj;
        this.i = bVar;
        this.j = arrayList;
        this.k = view;
        this.l = fragment;
        this.m = fragment2;
        this.n = z;
        this.o = arrayList2;
        this.p = obj2;
        this.q = rect;
    }

    public void run() {
        n2<String, View> e = tf.e(this.f, this.g, this.h, this.i);
        if (e != null) {
            this.j.addAll(e.values());
            this.j.add(this.k);
        }
        tf.c(this.l, this.m, this.n, e, false);
        Object obj = this.h;
        if (obj != null) {
            this.f.x(obj, this.o, this.j);
            View k2 = tf.k(e, this.i, this.p, this.n);
            if (k2 != null) {
                this.f.j(k2, this.q);
            }
        }
    }
}
