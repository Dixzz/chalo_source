package defpackage;

import java.util.Objects;
import kotlinx.coroutines.CoroutineExceptionHandler;

@y66(c = "app.zophop.ui.viewmodels.cardRecharge.CardDetailsFragmentViewModel$onCardNoReEntered$1", f = "CardDetailsFragmentViewModel.kt", l = {72, 73}, m = "invokeSuspend")
/* renamed from: j91  reason: default package */
/* compiled from: CardDetailsFragmentViewModel.kt */
public final class j91 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public Object f;
    public int g;
    public final /* synthetic */ h91 h;
    public final /* synthetic */ String i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j91(h91 h91, String str, k66<? super j91> k66) {
        super(2, k66);
        this.h = h91;
        this.i = str;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new j91(this.h, this.i, k66);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public Object invoke(mb6 mb6, k66<? super s56> k66) {
        return new j91(this.h, this.i, k66).invokeSuspend(s56.f3190a);
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        h91 h91;
        s56 s56 = s56.f3190a;
        p66 p66 = p66.COROUTINE_SUSPENDED;
        int i2 = this.g;
        if (i2 == 0) {
            hd3.Y2(obj);
            h91 = this.h;
            String str = this.i;
            this.f = h91;
            this.g = 1;
            obj = h91.d(h91, str, true, this);
            if (obj == p66) {
                return p66;
            }
        } else if (i2 == 1) {
            h91 = (h91) this.f;
            hd3.Y2(obj);
        } else if (i2 == 2) {
            hd3.Y2(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String str2 = (String) obj;
        Objects.requireNonNull(h91);
        n86.e(str2, "<set-?>");
        h91.h = str2;
        h91 h912 = this.h;
        wh whVar = h912.d;
        String str3 = h912.h;
        this.f = null;
        this.g = 2;
        xb6 xb6 = xb6.f3911a;
        Object j3 = hd3.j3(hj1.t0(CoroutineExceptionHandler.a.f, xf6.c), new uh1(whVar, "keyReEnteredCardNo", str3, null), this);
        if (j3 != p66) {
            j3 = s56;
        }
        return j3 == p66 ? p66 : s56;
    }
}
