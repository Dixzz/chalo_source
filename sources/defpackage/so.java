package defpackage;

import android.graphics.Rect;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* renamed from: so  reason: default package */
/* compiled from: ViewPager */
public class so implements m8 {

    /* renamed from: a  reason: collision with root package name */
    public final Rect f3232a = new Rect();
    public final /* synthetic */ ViewPager b;

    public so(ViewPager viewPager) {
        this.b = viewPager;
    }

    @Override // defpackage.m8
    public c9 a(View view, c9 c9Var) {
        c9 p = r8.p(view, c9Var);
        if (p.g()) {
            return p;
        }
        Rect rect = this.f3232a;
        rect.left = p.c();
        rect.top = p.e();
        rect.right = p.d();
        rect.bottom = p.b();
        int childCount = this.b.getChildCount();
        for (int i = 0; i < childCount; i++) {
            c9 e = r8.e(this.b.getChildAt(i), p);
            rect.left = Math.min(e.c(), rect.left);
            rect.top = Math.min(e.e(), rect.top);
            rect.right = Math.min(e.d(), rect.right);
            rect.bottom = Math.min(e.b(), rect.bottom);
        }
        return p.h(rect.left, rect.top, rect.right, rect.bottom);
    }
}
