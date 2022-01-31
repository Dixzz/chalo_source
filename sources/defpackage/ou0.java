package defpackage;

import app.zophop.ui.fragments.HomeScreenMainFragment;
import java.util.List;
import java.util.Timer;

@y66(c = "app.zophop.ui.fragments.HomeScreenMainFragment$onEvent$lambda-41$$inlined$runOnUiThreadWhenStarted$1", f = "HomeScreenMainFragment.kt", l = {46}, m = "invokeSuspend")
/* renamed from: ou0  reason: default package */
/* compiled from: BaseFragment.kt */
public final class ou0 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public int f;
    public final /* synthetic */ rl0 g;
    public final /* synthetic */ List h;
    public final /* synthetic */ HomeScreenMainFragment i;

    @y66(c = "app.zophop.ui.fragments.HomeScreenMainFragment$onEvent$lambda-41$$inlined$runOnUiThreadWhenStarted$1$1", f = "HomeScreenMainFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: ou0$a */
    /* compiled from: BaseFragment.kt */
    public static final class a extends b76 implements w76<mb6, k66<? super s56>, Object> {
        public final /* synthetic */ List f;
        public final /* synthetic */ HomeScreenMainFragment g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(k66 k66, List list, HomeScreenMainFragment homeScreenMainFragment) {
            super(2, k66);
            this.f = list;
            this.g = homeScreenMainFragment;
        }

        @Override // defpackage.u66
        public final k66<s56> create(Object obj, k66<?> k66) {
            return new a(k66, this.f, this.g);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public Object invoke(mb6 mb6, k66<? super s56> k66) {
            a aVar = new a(k66, this.f, this.g);
            s56 s56 = s56.f3190a;
            aVar.invokeSuspend(s56);
            return s56;
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            p66 p66 = p66.COROUTINE_SUSPENDED;
            hd3.Y2(obj);
            n86.d(this.f, "lPromotionCardsList");
            if (!this.f.isEmpty()) {
                HomeScreenMainFragment.g(this.g).x.setVisibility(0);
                HomeScreenMainFragment.g(this.g).C.setVisibility(0);
                if (this.f.size() == 1) {
                    HomeScreenMainFragment.g(this.g).H.setVisibility(8);
                } else {
                    ((Timer) this.g.r.getValue()).schedule(new nu0(this.g, this.f), 5000, 5000);
                    HomeScreenMainFragment.g(this.g).H.setVisibility(0);
                }
                HomeScreenMainFragment.g(this.g).e.setVisibility(0);
            } else {
                HomeScreenMainFragment.g(this.g).C.setVisibility(8);
                if (HomeScreenMainFragment.g(this.g).w.getVisibility() != 0) {
                    HomeScreenMainFragment.g(this.g).e.setVisibility(8);
                    HomeScreenMainFragment.g(this.g).x.setVisibility(8);
                }
            }
            return s56.f3190a;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ou0(rl0 rl0, k66 k66, List list, HomeScreenMainFragment homeScreenMainFragment) {
        super(2, k66);
        this.g = rl0;
        this.h = list;
        this.i = homeScreenMainFragment;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new ou0(this.g, k66, this.h, this.i);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public Object invoke(mb6 mb6, k66<? super s56> k66) {
        return new ou0(this.g, k66, this.h, this.i).invokeSuspend(s56.f3190a);
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        p66 p66 = p66.COROUTINE_SUSPENDED;
        int i2 = this.f;
        if (i2 == 0) {
            hd3.Y2(obj);
            rl0 rl0 = this.g;
            a aVar = new a(null, this.h, this.i);
            this.f = 1;
            if (h.G0(rl0, aVar, this) == p66) {
                return p66;
            }
        } else if (i2 == 1) {
            hd3.Y2(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return s56.f3190a;
    }
}
