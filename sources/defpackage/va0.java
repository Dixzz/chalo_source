package defpackage;

import androidx.activity.result.ActivityResult;
import app.zophop.ui.activities.UniversalPassActivity;
import java.util.Map;

/* renamed from: va0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class va0 implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UniversalPassActivity f3622a;

    public /* synthetic */ va0(UniversalPassActivity universalPassActivity) {
        this.f3622a = universalPassActivity;
    }

    @Override // defpackage.q
    public final void a(Object obj) {
        UniversalPassActivity universalPassActivity = this.f3622a;
        ActivityResult activityResult = (ActivityResult) obj;
        UniversalPassActivity.a aVar = UniversalPassActivity.m;
        n86.e(universalPassActivity, "this$0");
        n86.e(activityResult, "result");
        int i = activityResult.f;
        if (i == -1) {
            Map g2 = hd3.g2(new m56("isSuccessful", Boolean.TRUE));
            n86.e("user log attempt", "lEventName");
            n86.e("universal pass activity", "lSource");
            ed1 l = hj1.l("user log attempt", Long.MIN_VALUE, "source", "universal pass activity");
            for (Map.Entry entry : g2.entrySet()) {
                l.a((String) entry.getKey(), entry.getValue());
            }
            ui1.m0(l);
            universalPassActivity.o0();
        } else if (i == 0) {
            Map g22 = hd3.g2(new m56("isSuccessful", Boolean.FALSE));
            n86.e("user log attempt", "lEventName");
            n86.e("universal pass activity", "lSource");
            ed1 l2 = hj1.l("user log attempt", Long.MIN_VALUE, "source", "universal pass activity");
            for (Map.Entry entry2 : g22.entrySet()) {
                l2.a((String) entry2.getKey(), entry2.getValue());
            }
            ui1.m0(l2);
            universalPassActivity.getOnBackPressedDispatcher().b();
        }
    }
}
