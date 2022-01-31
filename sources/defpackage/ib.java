package defpackage;

/* renamed from: ib  reason: default package */
/* compiled from: PreferenceDataStoreFactory.kt */
public final class ib implements oa<kb> {

    /* renamed from: a  reason: collision with root package name */
    public final oa<kb> f1500a;

    @y66(c = "androidx.datastore.preferences.core.PreferenceDataStore$updateData$2", f = "PreferenceDataStoreFactory.kt", l = {85}, m = "invokeSuspend")
    /* renamed from: ib$a */
    /* compiled from: PreferenceDataStoreFactory.kt */
    public static final class a extends b76 implements w76<kb, k66<? super kb>, Object> {
        public int f;
        public /* synthetic */ Object g;
        public final /* synthetic */ w76<kb, k66<? super kb>, Object> h;

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: w76<? super kb, ? super k66<? super kb>, ? extends java.lang.Object> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(w76<? super kb, ? super k66<? super kb>, ? extends Object> w76, k66<? super a> k66) {
            super(2, k66);
            this.h = w76;
        }

        @Override // defpackage.u66
        public final k66<s56> create(Object obj, k66<?> k66) {
            a aVar = new a(this.h, k66);
            aVar.g = obj;
            return aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public Object invoke(kb kbVar, k66<? super kb> k66) {
            a aVar = new a(this.h, k66);
            aVar.g = kbVar;
            return aVar.invokeSuspend(s56.f3190a);
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            p66 p66 = p66.COROUTINE_SUSPENDED;
            int i = this.f;
            if (i == 0) {
                hd3.Y2(obj);
                w76<kb, k66<? super kb>, Object> w76 = this.h;
                this.f = 1;
                obj = w76.invoke((kb) this.g, this);
                if (obj == p66) {
                    return p66;
                }
            } else if (i == 1) {
                hd3.Y2(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kb kbVar = (kb) obj;
            ((hb) kbVar).b.set(true);
            return kbVar;
        }
    }

    public ib(oa<kb> oaVar) {
        n86.e(oaVar, "delegate");
        this.f1500a = oaVar;
    }

    @Override // defpackage.oa
    public Object a(w76<? super kb, ? super k66<? super kb>, ? extends Object> w76, k66<? super kb> k66) {
        return this.f1500a.a(new a(w76, null), k66);
    }
}
