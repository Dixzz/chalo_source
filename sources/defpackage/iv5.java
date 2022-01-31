package defpackage;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import defpackage.qu5;

/* renamed from: iv5  reason: default package */
/* compiled from: MessageListFragment */
public class iv5 implements qu5.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ fv5 f1576a;

    public iv5(fv5 fv5) {
        this.f1576a = fv5;
    }

    @Override // defpackage.qu5.c
    public void a(boolean z) {
        SwipeRefreshLayout swipeRefreshLayout = this.f1576a.f;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(false);
        }
    }
}
