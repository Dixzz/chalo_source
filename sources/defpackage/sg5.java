package defpackage;

import android.content.Context;
import com.truecaller.android.sdk.ITrueCallback;
import com.truecaller.android.sdk.TruecallerSdkScope;

/* renamed from: sg5  reason: default package */
/* compiled from: ClientManager */
public class sg5 {
    public static sg5 b;

    /* renamed from: a  reason: collision with root package name */
    public xg5 f3212a;

    @Deprecated
    public sg5(Context context, ITrueCallback iTrueCallback, String str) {
        this.f3212a = tg5.c(context) ? new yg5(context, str, iTrueCallback) : new ah5(context, str, iTrueCallback, false);
    }

    public sg5(TruecallerSdkScope truecallerSdkScope) {
        xg5 xg5;
        boolean c = tg5.c(truecallerSdkScope.context);
        wg5 wg5 = new wg5(truecallerSdkScope.sdkFlag, truecallerSdkScope.consentTitleOption, truecallerSdkScope.customDataBundle);
        if (c) {
            xg5 = new yg5(truecallerSdkScope.context, truecallerSdkScope.partnerKey, truecallerSdkScope.callback, wg5);
        } else {
            xg5 = wg5.a(32) ? new ah5(truecallerSdkScope.context, truecallerSdkScope.partnerKey, truecallerSdkScope.callback, false) : null;
        }
        this.f3212a = xg5;
    }
}
