package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import defpackage.a32;
import defpackage.x22;

/* renamed from: ji4  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class ji4 extends x22.a<ai4, zh4> {
    /* Return type fixed from 'x22$f' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, android.os.Looper, x72, java.lang.Object, a32$b, a32$c] */
    @Override // defpackage.x22.a
    public final ai4 buildClient(Context context, Looper looper, x72 x72, zh4 zh4, a32.b bVar, a32.c cVar) {
        zh4 zh42 = x72.g;
        Integer num = x72.h;
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", x72.f3896a);
        if (num != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
        }
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
        bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
        bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
        bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        return new ai4(context, looper, x72, bundle, bVar, cVar);
    }
}
