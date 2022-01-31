package defpackage;

@y66(c = "androidx.lifecycle.FlowLiveDataConversions$asLiveData$1", f = "FlowLiveData.kt", l = {149}, m = "invokeSuspend")
/* renamed from: vg  reason: default package */
/* compiled from: FlowLiveData.kt */
public final class vg extends b76 implements w76<kh<T>, k66<? super s56>, Object> {
    public /* synthetic */ Object f;
    public int g;
    public final /* synthetic */ qe6 h;

    /* renamed from: vg$a */
    /* compiled from: Collect.kt */
    public static final class a implements re6<T> {
        public final /* synthetic */ kh f;

        public a(kh khVar) {
            this.f = khVar;
        }

        @Override // defpackage.re6
        public Object a(Object obj, k66 k66) {
            Object a2 = this.f.a(obj, k66);
            if (a2 == p66.COROUTINE_SUSPENDED) {
                return a2;
            }
            return s56.f3190a;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public vg(qe6 qe6, k66 k66) {
        super(2, k66);
        this.h = qe6;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        n86.e(k66, "completion");
        vg vgVar = new vg(this.h, k66);
        vgVar.f = obj;
        return vgVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public final Object invoke(Object obj, k66<? super s56> k66) {
        k66<? super s56> k662 = k66;
        n86.e(k662, "completion");
        vg vgVar = new vg(this.h, k662);
        vgVar.f = obj;
        return vgVar.invokeSuspend(s56.f3190a);
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        p66 p66 = p66.COROUTINE_SUSPENDED;
        int i = this.g;
        if (i == 0) {
            hd3.Y2(obj);
            qe6 qe6 = this.h;
            a aVar = new a((kh) this.f);
            this.g = 1;
            if (qe6.b(aVar, this) == p66) {
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
