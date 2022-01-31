package defpackage;

import android.app.Application;
import androidx.lifecycle.LiveData;
import app.zophop.models.mTicketing.digitalTripReceipt.SuperPassTripReceipt;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.models.mTicketing.superPass.SuperPassSubType;

/* renamed from: w91  reason: default package */
/* compiled from: SuperPassTripReceiptFragmentViewModel.kt */
public final class w91 extends lg {
    public final wh d;
    public final String e;
    public final String f;
    public final SuperPassSubType g;
    public final long h;
    public boolean i;
    public boolean j;
    public final LiveData<SuperPass> k;
    public final LiveData<SuperPassTripReceipt> l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w91(Application application, wh whVar) {
        super(application);
        LiveData<SuperPass> liveData;
        n86.e(application, "application");
        n86.e(whVar, "savedStateHandle");
        this.d = whVar;
        Object obj = whVar.f3779a.get("keySource");
        n86.c(obj);
        n86.d(obj, "savedStateHandle.get(KEY_SOURCE)!!");
        this.e = (String) obj;
        Object obj2 = whVar.f3779a.get("keySuperPassId");
        n86.c(obj2);
        n86.d(obj2, "savedStateHandle.get(KEY_SUPER_PASS_ID)!!");
        String str = (String) obj2;
        this.f = str;
        Object obj3 = whVar.f3779a.get("keySuperPassSubType");
        n86.c(obj3);
        n86.d(obj3, "savedStateHandle.get(KEY_SUPER_PASS_SUB_TYPE)!!");
        SuperPassSubType superPassSubType = (SuperPassSubType) obj3;
        this.g = superPassSubType;
        Object obj4 = whVar.f3779a.get("keySuperPassActivationTimeStamp");
        n86.c(obj4);
        n86.d(obj4, "savedStateHandle.get(KEY…_ACTIVATION_TIME_STAMP)!!");
        long longValue = ((Number) obj4).longValue();
        this.h = longValue;
        Boolean bool = (Boolean) whVar.f3779a.get("keyIsTripReceiptAvailableEventFired");
        boolean z = false;
        this.i = bool == null ? false : bool.booleanValue();
        Boolean bool2 = (Boolean) whVar.f3779a.get("keyIsTripReceiptNotAvailableEventFired");
        this.j = bool2 != null ? bool2.booleanValue() : z;
        int ordinal = superPassSubType.ordinal();
        if (ordinal == 0) {
            liveData = wg.a(xt.f3961a.e0().getMagicSuperPass(str), null, 0, 3);
        } else if (ordinal == 1) {
            liveData = wg.a(xt.f3961a.e0().getRideBasedSuperPass(str), null, 0, 3);
        } else {
            throw new l56();
        }
        this.k = liveData;
        this.l = xt.f3961a.q().getSuperPassTripReceipt(str, longValue);
    }
}
