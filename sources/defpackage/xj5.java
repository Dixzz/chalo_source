package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: xj5  reason: default package */
/* compiled from: Fonts */
public class xj5 {
    public static final String[] d = {"serif", "sans-serif", "sans-serif-light", "sans-serif-condensed", "sans-serif-thin", "sans-serif-medium"};
    public static final String[] e = {"sans-serif-medium", "sans-serif-black", "cursive", "casual"};
    public static final String[] f = {"sans-serif-smallcaps", "serif-monospace", "monospace"};
    @SuppressLint({"StaticFieldLeak"})
    public static xj5 g;

    /* renamed from: a  reason: collision with root package name */
    public final Set<String> f3934a;
    public final Map<String, Typeface> b = new HashMap();
    public final Context c;

    public xj5(Context context) {
        HashSet hashSet = new HashSet();
        this.f3934a = hashSet;
        this.c = context.getApplicationContext();
        Collections.addAll(hashSet, d);
        Collections.addAll(hashSet, e);
        if (Build.VERSION.SDK_INT >= 23) {
            Collections.addAll(hashSet, f);
        }
    }
}
