package defpackage;

import androidx.navigation.NavController;
import app.zophop.R;
import app.zophop.ui.fragments.MumbaiOnBoardingFragment;

@y66(c = "app.zophop.ui.fragments.MumbaiOnBoardingFragment$launchNextScreenTimer$1", f = "MumbaiOnBoardingFragment.kt", l = {35}, m = "invokeSuspend")
/* renamed from: hv0  reason: default package */
/* compiled from: MumbaiOnBoardingFragment.kt */
public final class hv0 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public int f;
    public final /* synthetic */ MumbaiOnBoardingFragment g;

    @y66(c = "app.zophop.ui.fragments.MumbaiOnBoardingFragment$launchNextScreenTimer$1$1", f = "MumbaiOnBoardingFragment.kt", l = {36}, m = "invokeSuspend")
    /* renamed from: hv0$a */
    /* compiled from: MumbaiOnBoardingFragment.kt */
    public static final class a extends b76 implements w76<mb6, k66<? super s56>, Object> {
        public int f;

        public a(k66<? super a> k66) {
            super(2, k66);
        }

        @Override // defpackage.u66
        public final k66<s56> create(Object obj, k66<?> k66) {
            return new a(k66);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public Object invoke(mb6 mb6, k66<? super s56> k66) {
            return new a(k66).invokeSuspend(s56.f3190a);
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            p66 p66 = p66.COROUTINE_SUSPENDED;
            int i = this.f;
            if (i == 0) {
                hd3.Y2(obj);
                this.f = 1;
                if (hd3.C0(3000, this) == p66) {
                    return p66;
                }
            } else if (i == 1) {
                hd3.Y2(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s56.f3190a;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public hv0(MumbaiOnBoardingFragment mumbaiOnBoardingFragment, k66<? super hv0> k66) {
        super(2, k66);
        this.g = mumbaiOnBoardingFragment;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new hv0(this.g, k66);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public Object invoke(mb6 mb6, k66<? super s56> k66) {
        return new hv0(this.g, k66).invokeSuspend(s56.f3190a);
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        p66 p66 = p66.COROUTINE_SUSPENDED;
        int i = this.f;
        if (i == 0) {
            hd3.Y2(obj);
            kb6 kb6 = xb6.b;
            a aVar = new a(null);
            this.f = 1;
            if (hd3.j3(kb6, aVar, this) == p66) {
                return p66;
            }
        } else if (i == 1) {
            hd3.Y2(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        vh1 vh1 = vh1.f3649a;
        NavController H = h.H(this.g);
        si siVar = new si(R.id.action_mumbaiOnBoardingFragment_to_tutorialViewPagerFragment);
        n86.d(siVar, "actionMumbaiOnBoardingFr…torialViewPagerFragment()");
        vh1.a(H, siVar);
        return s56.f3190a;
    }
}
