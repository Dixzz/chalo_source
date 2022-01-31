package defpackage;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* renamed from: ad2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class ad2 implements DynamiteModule.b {
    @Override // com.google.android.gms.dynamite.DynamiteModule.b
    public final ed2 a(Context context, String str, dd2 dd2) throws DynamiteModule.a {
        ed2 ed2 = new ed2();
        ed2.f962a = dd2.b(context, str);
        int a2 = dd2.a(context, str, true);
        ed2.b = a2;
        int i = ed2.f962a;
        if (i == 0) {
            if (a2 == 0) {
                ed2.c = 0;
                return ed2;
            }
            i = 0;
        }
        if (a2 >= i) {
            ed2.c = 1;
        } else {
            ed2.c = -1;
        }
        return ed2;
    }
}
