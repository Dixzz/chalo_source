package defpackage;

import app.zophop.ui.fragments.HomeScreenMainFragment;

@y66(c = "app.zophop.ui.fragments.HomeScreenMainFragment$recentSearchListAdapter$2$1$invoke$$inlined$runOnUiThreadWhenStarted$1", f = "HomeScreenMainFragment.kt", l = {46}, m = "invokeSuspend")
/* renamed from: ru0  reason: default package */
/* compiled from: BaseFragment.kt */
public final class ru0 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public int f;
    public final /* synthetic */ rl0 g;
    public final /* synthetic */ HomeScreenMainFragment h;

    @y66(c = "app.zophop.ui.fragments.HomeScreenMainFragment$recentSearchListAdapter$2$1$invoke$$inlined$runOnUiThreadWhenStarted$1$1", f = "HomeScreenMainFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: ru0$a */
    /* compiled from: BaseFragment.kt */
    public static final class a extends b76 implements w76<mb6, k66<? super s56>, Object> {
        public final /* synthetic */ HomeScreenMainFragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(k66 k66, HomeScreenMainFragment homeScreenMainFragment) {
            super(2, k66);
            this.f = homeScreenMainFragment;
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
            p66 p66 = p66.COROUTINE_SUSPENDED;
            hd3.Y2(s56);
            HomeScreenMainFragment.g(aVar.f).D.i0(0);
            return s56;
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            p66 p66 = p66.COROUTINE_SUSPENDED;
            hd3.Y2(obj);
            HomeScreenMainFragment.g(this.f).D.i0(0);
            return s56.f3190a;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ru0(rl0 rl0, k66 k66, HomeScreenMainFragment homeScreenMainFragment) {
        super(2, k66);
        this.g = rl0;
        this.h = homeScreenMainFragment;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new ru0(this.g, k66, this.h);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public Object invoke(mb6 mb6, k66<? super s56> k66) {
        return new ru0(this.g, k66, this.h).invokeSuspend(s56.f3190a);
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
