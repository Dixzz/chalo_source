package defpackage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* renamed from: sk4  reason: default package */
/* compiled from: ViewOffsetBehavior */
public class sk4<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a  reason: collision with root package name */
    public tk4 f3223a;
    public int b = 0;

    public sk4() {
    }

    public int B() {
        tk4 tk4 = this.f3223a;
        if (tk4 != null) {
            return tk4.d;
        }
        return 0;
    }

    public void C(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.l(v, i);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v, int i) {
        C(coordinatorLayout, v, i);
        if (this.f3223a == null) {
            this.f3223a = new tk4(v);
        }
        tk4 tk4 = this.f3223a;
        tk4.b = tk4.f3370a.getTop();
        tk4.c = tk4.f3370a.getLeft();
        this.f3223a.a();
        int i2 = this.b;
        if (i2 == 0) {
            return true;
        }
        this.f3223a.b(i2);
        this.b = 0;
        return true;
    }

    public sk4(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
