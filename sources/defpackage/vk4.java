package defpackage;

import android.view.View;
import com.google.android.material.behavior.SwipeDismissBehavior;
import defpackage.g9;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: vk4  reason: default package */
/* compiled from: SwipeDismissBehavior */
public class vk4 implements g9 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SwipeDismissBehavior f3659a;

    public vk4(SwipeDismissBehavior swipeDismissBehavior) {
        this.f3659a = swipeDismissBehavior;
    }

    @Override // defpackage.g9
    public boolean a(View view, g9.a aVar) {
        boolean z = false;
        if (!this.f3659a.B(view)) {
            return false;
        }
        AtomicInteger atomicInteger = r8.f3055a;
        boolean z2 = view.getLayoutDirection() == 1;
        int i = this.f3659a.d;
        if ((i == 0 && z2) || (i == 1 && !z2)) {
            z = true;
        }
        int width = view.getWidth();
        if (z) {
            width = -width;
        }
        r8.n(view, width);
        view.setAlpha(0.0f);
        SwipeDismissBehavior.b bVar = this.f3659a.b;
        if (bVar != null) {
            ((bp4) bVar).a(view);
        }
        return true;
    }
}
