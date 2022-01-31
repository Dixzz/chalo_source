package defpackage;

import app.zophop.ui.fragments.CitySelectionFragment;

@y66(c = "app.zophop.ui.fragments.CitySelectionFragment$setUpCitiesAndFooter$1$1$invoke$$inlined$runOnUiThreadWhenStarted$1", f = "CitySelectionFragment.kt", l = {46}, m = "invokeSuspend")
/* renamed from: xt0  reason: default package */
/* compiled from: BaseFragment.kt */
public final class xt0 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public int f;
    public final /* synthetic */ rl0 g;
    public final /* synthetic */ CitySelectionFragment h;

    @y66(c = "app.zophop.ui.fragments.CitySelectionFragment$setUpCitiesAndFooter$1$1$invoke$$inlined$runOnUiThreadWhenStarted$1$1", f = "CitySelectionFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: xt0$a */
    /* compiled from: BaseFragment.kt */
    public static final class a extends b76 implements w76<mb6, k66<? super s56>, Object> {
        public final /* synthetic */ CitySelectionFragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(k66 k66, CitySelectionFragment citySelectionFragment) {
            super(2, k66);
            this.f = citySelectionFragment;
        }

        @Override // defpackage.u66
        public final k66<s56> create(Object obj, k66<?> k66) {
            return new a(k66, this.f);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public Object invoke(mb6 mb6, k66<? super s56> k66) {
            a aVar = new a(k66, this.f);
            s56 s56 = s56.f3190a;
            aVar.invokeSuspend(s56);
            return s56;
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            p66 p66 = p66.COROUTINE_SUSPENDED;
            hd3.Y2(obj);
            CitySelectionFragment citySelectionFragment = this.f;
            int i = CitySelectionFragment.k;
            T t = citySelectionFragment.f;
            n86.c(t);
            ((uw) t).b.i0(0);
            return s56.f3190a;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public xt0(rl0 rl0, k66 k66, CitySelectionFragment citySelectionFragment) {
        super(2, k66);
        this.g = rl0;
        this.h = citySelectionFragment;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new xt0(this.g, k66, this.h);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public Object invoke(mb6 mb6, k66<? super s56> k66) {
        return new xt0(this.g, k66, this.h).invokeSuspend(s56.f3190a);
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        p66 p66 = p66.COROUTINE_SUSPENDED;
        int i = this.f;
        if (i == 0) {
            hd3.Y2(obj);
            rl0 rl0 = this.g;
            a aVar = new a(null, this.h);
            this.f = 1;
            if (h.G0(rl0, aVar, this) == p66) {
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
