package defpackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.transition.R;

/* renamed from: do  reason: invalid class name and default package */
/* compiled from: Visibility */
public class Cdo extends nn {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f867a;
    public final /* synthetic */ View b;
    public final /* synthetic */ View c;
    public final /* synthetic */ eo d;

    public Cdo(eo eoVar, ViewGroup viewGroup, View view, View view2) {
        this.d = eoVar;
        this.f867a = viewGroup;
        this.b = view;
        this.c = view2;
    }

    @Override // defpackage.nn, defpackage.kn.d
    public void b(kn knVar) {
        this.f867a.getOverlay().remove(this.b);
    }

    @Override // defpackage.kn.d
    public void c(kn knVar) {
        this.c.setTag(R.id.save_overlay_view, null);
        this.f867a.getOverlay().remove(this.b);
        knVar.w(this);
    }

    @Override // defpackage.nn, defpackage.kn.d
    public void e(kn knVar) {
        if (this.b.getParent() == null) {
            this.f867a.getOverlay().add(this.b);
        } else {
            this.d.cancel();
        }
    }
}
