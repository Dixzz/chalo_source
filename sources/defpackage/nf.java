package defpackage;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import defpackage.tf;

/* renamed from: nf  reason: default package */
/* compiled from: FragmentTransition */
public class nf implements Runnable {
    public final /* synthetic */ tf.a f;
    public final /* synthetic */ Fragment g;
    public final /* synthetic */ t6 h;

    public nf(tf.a aVar, Fragment fragment, t6 t6Var) {
        this.f = aVar;
        this.g = fragment;
        this.h = t6Var;
    }

    public void run() {
        ((FragmentManager.d) this.f).a(this.g, this.h);
    }
}
