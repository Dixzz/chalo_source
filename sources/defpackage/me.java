package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import defpackage.bg;
import defpackage.le;

/* renamed from: me  reason: default package */
/* compiled from: DefaultSpecialEffectsController */
public class me extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f2361a;
    public final /* synthetic */ View b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ bg.d d;
    public final /* synthetic */ le.b e;

    public me(le leVar, ViewGroup viewGroup, View view, boolean z, bg.d dVar, le.b bVar) {
        this.f2361a = viewGroup;
        this.b = view;
        this.c = z;
        this.d = dVar;
        this.e = bVar;
    }

    public void onAnimationEnd(Animator animator) {
        this.f2361a.endViewTransition(this.b);
        if (this.c) {
            this.d.f424a.applyState(this.b);
        }
        this.e.a();
    }
}
