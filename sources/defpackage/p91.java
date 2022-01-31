package defpackage;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import app.zophop.models.mTicketing.cardRecharge.OnlineCardRecharge;
import java.util.List;
import java.util.UUID;

/* renamed from: p91  reason: default package */
/* compiled from: OnlineCardRechargeHistoryActivityViewModel.kt */
public final class p91 extends lg {
    public final wh d;
    public final String e;
    public boolean f = true;
    public final LiveData<List<OnlineCardRecharge>> g = wg.a(xt.f3961a.K().getAllOnlineCardRechargesForCity(), null, 0, 3);
    public boolean h;
    public String i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p91(Application application, wh whVar) {
        super(application);
        n86.e(application, "application");
        n86.e(whVar, "savedStateHandle");
        this.d = whVar;
        Object obj = whVar.f3779a.get("keySource");
        n86.c(obj);
        n86.d(obj, "savedStateHandle.get<String>(KEY_SOURCE)!!");
        this.e = (String) obj;
        Boolean bool = (Boolean) whVar.f3779a.get("keyIsCardRechargeHistoryFetched");
        this.h = bool == null ? false : bool.booleanValue();
        this.i = new String();
    }

    public final void d(Context context) {
        n86.e(context, "lContext");
        String uuid = UUID.randomUUID().toString();
        n86.d(uuid, "randomUUID().toString()");
        this.i = uuid;
        v60.c(uuid, context);
    }
}
