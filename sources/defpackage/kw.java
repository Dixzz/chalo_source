package defpackage;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.MaterialToolbar;

/* renamed from: kw  reason: default package */
/* compiled from: ActivityUniversalPassBinding */
public final class kw implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f2126a;
    public final mz b;
    public final ky c;
    public final MaterialToolbar d;
    public final RecyclerView e;

    public kw(ConstraintLayout constraintLayout, mz mzVar, ky kyVar, MaterialToolbar materialToolbar, RecyclerView recyclerView) {
        this.f2126a = constraintLayout;
        this.b = mzVar;
        this.c = kyVar;
        this.d = materialToolbar;
        this.e = recyclerView;
    }

    @Override // defpackage.qo
    public View a() {
        return this.f2126a;
    }
}
