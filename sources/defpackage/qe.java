package defpackage;

import defpackage.bg;

/* renamed from: qe  reason: default package */
/* compiled from: DefaultSpecialEffectsController */
public class qe implements Runnable {
    public final /* synthetic */ bg.d f;
    public final /* synthetic */ bg.d g;
    public final /* synthetic */ boolean h;
    public final /* synthetic */ n2 i;

    public qe(le leVar, bg.d dVar, bg.d dVar2, boolean z, n2 n2Var) {
        this.f = dVar;
        this.g = dVar2;
        this.h = z;
        this.i = n2Var;
    }

    public void run() {
        tf.c(this.f.c, this.g.c, this.h, this.i, false);
    }
}
