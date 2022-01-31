package defpackage;

import com.google.firebase.iid.InstanceIdResult;

/* renamed from: rc5  reason: default package */
/* compiled from: MixpanelFCMMessagingService */
public class rc5 implements ti4<InstanceIdResult> {
    @Override // defpackage.ti4
    public void onComplete(yi4<InstanceIdResult> yi4) {
        if (yi4.q()) {
            sc5.a(yi4.m().getToken());
        }
    }
}
