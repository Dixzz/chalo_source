package defpackage;

import android.view.View;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* renamed from: bp4  reason: default package */
/* compiled from: BaseTransientBottomBar */
public class bp4 implements SwipeDismissBehavior.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f464a;

    public bp4(BaseTransientBottomBar baseTransientBottomBar) {
        this.f464a = baseTransientBottomBar;
    }

    public void a(View view) {
        if (view.getParent() != null) {
            view.setVisibility(8);
        }
        this.f464a.b(0);
    }
}
