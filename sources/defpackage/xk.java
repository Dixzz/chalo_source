package defpackage;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.xj;

/* renamed from: xk  reason: default package */
/* compiled from: RecyclerView */
public class xk implements xj.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RecyclerView f3935a;

    public xk(RecyclerView recyclerView) {
        this.f3935a = recyclerView;
    }

    public View a(int i) {
        return this.f3935a.getChildAt(i);
    }

    public int b() {
        return this.f3935a.getChildCount();
    }

    public void c(int i) {
        View childAt = this.f3935a.getChildAt(i);
        if (childAt != null) {
            this.f3935a.o(childAt);
            childAt.clearAnimation();
        }
        this.f3935a.removeViewAt(i);
    }
}
