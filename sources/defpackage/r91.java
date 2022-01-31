package defpackage;

import android.app.Application;
import androidx.lifecycle.LiveData;
import app.zophop.models.mTicketing.digitalTripReceipt.SuperPassTripReceipt;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.models.mTicketing.superPass.SuperPassSubType;
import java.util.List;

/* renamed from: r91  reason: default package */
/* compiled from: DigitalTripReceiptHistoryFragmentViewModel.kt */
public final class r91 extends lg {
    public final String d;
    public final String e;
    public final SuperPassSubType f;
    public final LiveData<SuperPass> g;
    public final LiveData<List<SuperPassTripReceipt>> h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r91(Application application, wh whVar) {
        super(application);
        LiveData<SuperPass> liveData;
        n86.e(application, "application");
        n86.e(whVar, "savedStateHandle");
        Object obj = whVar.f3779a.get("keySource");
        n86.c(obj);
        n86.d(obj, "savedStateHandle.get(KEY_SOURCE)!!");
        this.d = (String) obj;
        Object obj2 = whVar.f3779a.get("keySuperPassId");
        n86.c(obj2);
        n86.d(obj2, "savedStateHandle.get(KEY_SUPER_PASS_ID)!!");
        String str = (String) obj2;
        this.e = str;
        Object obj3 = whVar.f3779a.get("keySuperPassSubType");
        n86.c(obj3);
        n86.d(obj3, "savedStateHandle.get(KEY_SUPER_PASS_SUB_TYPE)!!");
        SuperPassSubType superPassSubType = (SuperPassSubType) obj3;
        this.f = superPassSubType;
        int ordinal = superPassSubType.ordinal();
        if (ordinal == 0) {
            liveData = wg.a(xt.f3961a.e0().getMagicSuperPass(str), null, 0, 3);
        } else if (ordinal == 1) {
            liveData = wg.a(xt.f3961a.e0().getRideBasedSuperPass(str), null, 0, 3);
        } else {
            throw new l56();
        }
        this.g = liveData;
        this.h = xt.f3961a.q().getAllSuperPassTripReceiptsList(str);
    }
}
