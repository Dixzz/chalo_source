package defpackage;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* renamed from: zc2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class zc2 implements DynamiteModule.b {
    @Override // com.google.android.gms.dynamite.DynamiteModule.b
    public final ed2 a(Context context, String str, dd2 dd2) throws DynamiteModule.a {
        int i;
        ed2 ed2 = new ed2();
        int b = dd2.b(context, str);
        ed2.f962a = b;
        int i2 = 0;
        if (b != 0) {
            i = dd2.a(context, str, false);
            ed2.b = i;
        } else {
            i = dd2.a(context, str, true);
            ed2.b = i;
        }
        int i3 = ed2.f962a;
        if (i3 != 0) {
            i2 = i3;
        } else if (i == 0) {
            ed2.c = 0;
            return ed2;
        }
        if (i2 >= i) {
            ed2.c = -1;
        } else {
            ed2.c = 1;
        }
        return ed2;
    }
}
