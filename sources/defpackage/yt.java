package defpackage;

import app.zophop.R;
import com.freshchat.consumer.sdk.Freshchat;
import com.freshchat.consumer.sdk.exception.MethodNotAllowedException;
import defpackage.xt;
import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import java.util.ArrayList;
import java.util.Objects;

@y66(c = "app.zophop.DependencyFactory$Companion$init$1", f = "DependencyFactory.kt", l = {}, m = "invokeSuspend")
/* renamed from: yt  reason: default package */
/* compiled from: DependencyFactory.kt */
public final class yt extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public yt(k66<? super yt> k66) {
        super(2, k66);
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new yt(k66);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public Object invoke(mb6 mb6, k66<? super s56> k66) {
        yt ytVar = new yt(k66);
        s56 s56 = s56.f3190a;
        ytVar.invokeSuspend(s56);
        return s56;
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        p66 p66 = p66.COROUTINE_SUSPENDED;
        hd3.Y2(obj);
        xt.t1 t1Var = xt.f3961a;
        xt.r.getValue();
        t1Var.a();
        Objects.requireNonNull(i26.g);
        ArrayList arrayList = new ArrayList();
        CalligraphyInterceptor calligraphyInterceptor = new CalligraphyInterceptor(new CalligraphyConfig.Builder().setDefaultFontPath("fonts/NotoSans-Regular.ttf").setFontAttrId(R.attr.fontPath).build());
        n86.f(calligraphyInterceptor, "interceptor");
        arrayList.add(calligraphyInterceptor);
        i26.e = new i26(y56.y(arrayList), true, true, false, null);
        t1Var.L().o();
        try {
            Freshchat.getInstance(t1Var.m()).identifyUser(t1Var.n().a(), null);
        } catch (MethodNotAllowedException e) {
            e.printStackTrace();
        }
        xt.t1 t1Var2 = xt.f3961a;
        xt.t.getValue();
        xt.o0.getValue();
        d10 value = xt.k.getValue();
        n86.d(value, "<get-chaloConfig>(...)");
        value.g();
        return s56.f3190a;
    }
}
