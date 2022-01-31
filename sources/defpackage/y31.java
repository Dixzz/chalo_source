package defpackage;

import android.graphics.Bitmap;
import android.widget.ProgressBar;

@y66(c = "app.zophop.ui.fragments.superPassValidation.SoundFragmentSuperPass$setupUserProfileView$1$1$onResourceReady$$inlined$runOnUiThreadWhenStarted$1", f = "SoundFragmentSuperPass.kt", l = {46}, m = "invokeSuspend")
/* renamed from: y31  reason: default package */
/* compiled from: BaseFragment.kt */
public final class y31 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public int f;
    public final /* synthetic */ rl0 g;
    public final /* synthetic */ ez h;
    public final /* synthetic */ Bitmap i;

    @y66(c = "app.zophop.ui.fragments.superPassValidation.SoundFragmentSuperPass$setupUserProfileView$1$1$onResourceReady$$inlined$runOnUiThreadWhenStarted$1$1", f = "SoundFragmentSuperPass.kt", l = {}, m = "invokeSuspend")
    /* renamed from: y31$a */
    /* compiled from: BaseFragment.kt */
    public static final class a extends b76 implements w76<mb6, k66<? super s56>, Object> {
        public final /* synthetic */ ez f;
        public final /* synthetic */ Bitmap g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(k66 k66, ez ezVar, Bitmap bitmap) {
            super(2, k66);
            this.f = ezVar;
            this.g = bitmap;
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
            ProgressBar progressBar = this.f.b;
            n86.d(progressBar, "passProfilePicProgressbar");
            progressBar.setVisibility(8);
            this.f.d.setImageBitmap(this.g);
            return s56.f3190a;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y31(rl0 rl0, k66 k66, ez ezVar, Bitmap bitmap) {
        super(2, k66);
        this.g = rl0;
        this.h = ezVar;
        this.i = bitmap;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new y31(this.g, k66, this.h, this.i);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public Object invoke(mb6 mb6, k66<? super s56> k66) {
        return new y31(this.g, k66, this.h, this.i).invokeSuspend(s56.f3190a);
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
