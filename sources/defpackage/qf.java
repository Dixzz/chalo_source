package defpackage;

import android.view.View;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

/* renamed from: qf  reason: default package */
/* compiled from: FragmentTransition */
public class qf implements Runnable {
    public final /* synthetic */ Object f;
    public final /* synthetic */ vf g;
    public final /* synthetic */ View h;
    public final /* synthetic */ Fragment i;
    public final /* synthetic */ ArrayList j;
    public final /* synthetic */ ArrayList k;
    public final /* synthetic */ ArrayList l;
    public final /* synthetic */ Object m;

    public qf(Object obj, vf vfVar, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
        this.f = obj;
        this.g = vfVar;
        this.h = view;
        this.i = fragment;
        this.j = arrayList;
        this.k = arrayList2;
        this.l = arrayList3;
        this.m = obj2;
    }

    public void run() {
        Object obj = this.f;
        if (obj != null) {
            this.g.o(obj, this.h);
            this.k.addAll(tf.h(this.g, this.f, this.i, this.j, this.h));
        }
        if (this.l != null) {
            if (this.m != null) {
                ArrayList<View> arrayList = new ArrayList<>();
                arrayList.add(this.h);
                this.g.p(this.m, this.l, arrayList);
            }
            this.l.clear();
            this.l.add(this.h);
        }
    }
}
