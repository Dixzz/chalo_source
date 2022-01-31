package defpackage;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import defpackage.a32;
import defpackage.x22;
import java.util.Collections;
import java.util.List;

/* renamed from: h12  reason: default package */
public final class h12 extends x22.a<m02, GoogleSignInOptions> {
    /* Return type fixed from 'x22$f' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, android.os.Looper, x72, java.lang.Object, a32$b, a32$c] */
    @Override // defpackage.x22.a
    public final /* synthetic */ m02 buildClient(Context context, Looper looper, x72 x72, GoogleSignInOptions googleSignInOptions, a32.b bVar, a32.c cVar) {
        return new m02(context, looper, x72, googleSignInOptions, bVar, cVar);
    }

    @Override // defpackage.x22.e
    public final /* synthetic */ List getImpliedScopes(Object obj) {
        GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
        if (googleSignInOptions == null) {
            return Collections.emptyList();
        }
        return googleSignInOptions.l1();
    }
}
