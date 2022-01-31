package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.widget.ResourceManagerInternal;
import java.util.WeakHashMap;

@SuppressLint({"RestrictedAPI"})
/* renamed from: u0  reason: default package */
/* compiled from: AppCompatResources */
public final class u0 {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f3424a = new ThreadLocal<>();
    public static final WeakHashMap<Context, SparseArray<a>> b = new WeakHashMap<>(0);
    public static final Object c = new Object();

    /* renamed from: u0$a */
    /* compiled from: AppCompatResources */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final ColorStateList f3425a;
        public final Configuration b;

        public a(ColorStateList colorStateList, Configuration configuration) {
            this.f3425a = colorStateList;
            this.b = configuration;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ab  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.res.ColorStateList a(android.content.Context r12, int r13) {
        /*
        // Method dump skipped, instructions count: 346
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.u0.a(android.content.Context, int):android.content.res.ColorStateList");
    }

    public static Drawable b(Context context, int i) {
        return ResourceManagerInternal.get().getDrawable(context, i);
    }
}
