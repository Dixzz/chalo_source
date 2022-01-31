package defpackage;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import java.util.Map;

@TargetApi(14)
/* renamed from: il1  reason: default package */
/* compiled from: GlideContext */
public class il1 extends ContextWrapper {
    public static final ol1<?, ?> h = new fl1();

    /* renamed from: a  reason: collision with root package name */
    public final Handler f1531a = new Handler(Looper.getMainLooper());
    public final ll1 b;
    public final zs1 c;
    public final rs1 d;
    public final Map<Class<?>, ol1<?, ?>> e;
    public final hn1 f;
    public final int g;

    public il1(Context context, ll1 ll1, zs1 zs1, rs1 rs1, Map<Class<?>, ol1<?, ?>> map, hn1 hn1, int i) {
        super(context.getApplicationContext());
        this.b = ll1;
        this.c = zs1;
        this.d = rs1;
        this.e = map;
        this.f = hn1;
        this.g = i;
    }
}
