package defpackage;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* renamed from: yc2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class yc2 implements DynamiteModule.b {
    @Override // com.google.android.gms.dynamite.DynamiteModule.b
    public final ed2 a(Context context, String str, dd2 dd2) throws DynamiteModule.a {
        ed2 ed2 = new ed2();
        int b = dd2.b(context, str);
        ed2.f962a = b;
        if (b != 0) {
            ed2.c = -1;
        } else {
            int a2 = dd2.a(context, str, true);
            ed2.b = a2;
            if (a2 != 0) {
                ed2.c = 1;
            }
        }
        return ed2;
    }
}
