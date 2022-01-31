package defpackage;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import androidx.core.R;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: w8  reason: default package */
/* compiled from: ViewCompat */
public class w8 implements View.OnApplyWindowInsetsListener {

    /* renamed from: a  reason: collision with root package name */
    public c9 f3742a = null;
    public final /* synthetic */ View b;
    public final /* synthetic */ m8 c;

    public w8(View view, m8 m8Var) {
        this.b = view;
        this.c = m8Var;
    }

    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        c9 k = c9.k(windowInsets, view);
        int i = Build.VERSION.SDK_INT;
        if (i < 30) {
            View view2 = this.b;
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view2.getTag(R.id.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view2, windowInsets);
            }
            if (k.equals(this.f3742a)) {
                return this.c.a(view, k).i();
            }
        }
        this.f3742a = k;
        c9 a2 = this.c.a(view, k);
        if (i >= 30) {
            return a2.i();
        }
        AtomicInteger atomicInteger = r8.f3055a;
        view.requestApplyInsets();
        return a2.i();
    }
}
