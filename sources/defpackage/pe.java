package defpackage;

import android.view.View;
import android.view.ViewGroup;
import defpackage.le;
import defpackage.t6;

/* renamed from: pe  reason: default package */
/* compiled from: DefaultSpecialEffectsController */
public class pe implements t6.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f2794a;
    public final /* synthetic */ ViewGroup b;
    public final /* synthetic */ le.b c;

    public pe(le leVar, View view, ViewGroup viewGroup, le.b bVar) {
        this.f2794a = view;
        this.b = viewGroup;
        this.c = bVar;
    }

    @Override // defpackage.t6.a
    public void a() {
        this.f2794a.clearAnimation();
        this.b.endViewTransition(this.f2794a);
        this.c.a();
    }
}
