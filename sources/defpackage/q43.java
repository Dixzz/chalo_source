package defpackage;

import android.content.Context;
import android.os.Looper;
import com.google.firebase.FirebaseExceptionMapper;
import defpackage.z22;
import java.util.concurrent.Callable;

/* renamed from: q43  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class q43 implements Callable<z03<l53>> {
    public final l53 f;
    public final Context g;

    public q43(l53 l53, Context context) {
        this.f = l53;
        this.g = context;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final z03<l53> call() throws Exception {
        Object obj = q22.c;
        int c = q22.d.c(this.g, u22.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        s43.f3183a = c == 0 || c == 2;
        Context context = this.g;
        String str = this.f.g;
        gj1.j(str);
        l53 l53 = new l53(str);
        l53.f = true;
        x22<l53> x22 = m53.c;
        FirebaseExceptionMapper firebaseExceptionMapper = new FirebaseExceptionMapper();
        gj1.l(firebaseExceptionMapper, "StatusExceptionMapper must not be null.");
        return new z03(new b13(context, x22, l53, new z22.a(firebaseExceptionMapper, null, Looper.getMainLooper())));
    }
}
