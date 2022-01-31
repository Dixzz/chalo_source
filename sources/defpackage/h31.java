package defpackage;

import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.ui.fragments.superPassValidation.ActiveSuperPassQrZoomedFragment;

@y66(c = "app.zophop.ui.fragments.superPassValidation.ActiveSuperPassQrZoomedFragment$launchValidityChecks$1", f = "ActiveSuperPassQrZoomedFragment.kt", l = {148}, m = "invokeSuspend")
/* renamed from: h31  reason: default package */
/* compiled from: ActiveSuperPassQrZoomedFragment.kt */
public final class h31 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public int f;
    public /* synthetic */ Object g;
    public final /* synthetic */ SuperPass h;
    public final /* synthetic */ ActiveSuperPassQrZoomedFragment i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h31(SuperPass superPass, ActiveSuperPassQrZoomedFragment activeSuperPassQrZoomedFragment, k66<? super h31> k66) {
        super(2, k66);
        this.h = superPass;
        this.i = activeSuperPassQrZoomedFragment;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        h31 h31 = new h31(this.h, this.i, k66);
        h31.g = obj;
        return h31;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public Object invoke(mb6 mb6, k66<? super s56> k66) {
        h31 h31 = new h31(this.h, this.i, k66);
        h31.g = mb6;
        return h31.invokeSuspend(s56.f3190a);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002f A[RETURN] */
    @Override // defpackage.u66
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
        // Method dump skipped, instructions count: 227
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h31.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
