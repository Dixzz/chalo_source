package defpackage;

import android.annotation.TargetApi;
import android.content.Context;
import android.telecom.TelecomManager;
import com.razorpay.AnalyticsConstants;
import java.util.Objects;

@TargetApi(28)
/* renamed from: gh5  reason: default package */
/* compiled from: CallRejector.kt */
public final class gh5 implements eh5 {

    /* renamed from: a  reason: collision with root package name */
    public final TelecomManager f1261a;

    public gh5(Context context) {
        n86.e(context, AnalyticsConstants.CONTEXT);
        Object systemService = context.getSystemService("telecom");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.telecom.TelecomManager");
        this.f1261a = (TelecomManager) systemService;
    }

    @Override // defpackage.eh5
    public boolean a() {
        try {
            return this.f1261a.endCall();
        } catch (Exception unused) {
            return false;
        }
    }
}
