package defpackage;

import app.zophop.ZophopApplication;
import defpackage.kb;

@y66(c = "app.zophop.datastore.LocalDataStore$updateLocalDataStore$1", f = "LocalDataStore.kt", l = {21}, m = "invokeSuspend")
/* renamed from: uz  reason: default package */
/* compiled from: LocalDataStore.kt */
public final class uz extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public int f;
    public final /* synthetic */ tz g;
    public final /* synthetic */ kb.a<T> h;
    public final /* synthetic */ T i;

    @y66(c = "app.zophop.datastore.LocalDataStore$updateLocalDataStore$1$1", f = "LocalDataStore.kt", l = {}, m = "invokeSuspend")
    /* renamed from: uz$a */
    /* compiled from: LocalDataStore.kt */
    public static final class a extends b76 implements w76<hb, k66<? super s56>, Object> {
        public /* synthetic */ Object f;
        public final /* synthetic */ kb.a<T> g;
        public final /* synthetic */ T h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(kb.a<T> aVar, T t, k66<? super a> k66) {
            super(2, k66);
            this.g = aVar;
            this.h = t;
        }

        @Override // defpackage.u66
        public final k66<s56> create(Object obj, k66<?> k66) {
            a aVar = new a(this.g, this.h, k66);
            aVar.f = obj;
            return aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public Object invoke(hb hbVar, k66<? super s56> k66) {
            a aVar = new a(this.g, this.h, k66);
            aVar.f = hbVar;
            s56 s56 = s56.f3190a;
            p66 p66 = p66.COROUTINE_SUSPENDED;
            hd3.Y2(s56);
            ((hb) aVar.f).c(aVar.g, aVar.h);
            return s56;
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            p66 p66 = p66.COROUTINE_SUSPENDED;
            hd3.Y2(obj);
            ((hb) this.f).c(this.g, this.h);
            return s56.f3190a;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public uz(tz tzVar, kb.a<T> aVar, T t, k66<? super uz> k66) {
        super(2, k66);
        this.g = tzVar;
        this.h = aVar;
        this.i = t;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new uz(this.g, this.h, this.i, k66);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public Object invoke(mb6 mb6, k66<? super s56> k66) {
        return new uz(this.g, this.h, this.i, k66).invokeSuspend(s56.f3190a);
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        p66 p66 = p66.COROUTINE_SUSPENDED;
        int i2 = this.f;
        if (i2 == 0) {
            hd3.Y2(obj);
            tz tzVar = this.g;
            d96 d96 = tzVar.c;
            a aVar = new a(this.h, this.i, null);
            this.f = 1;
            if (((oa) d96.a((ZophopApplication) tzVar.b.getValue(), tz.d[0])).a(new lb(aVar, null), this) == p66) {
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
