package defpackage;

import java.util.List;

@y66(c = "androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2", f = "DataMigrationInitializer.kt", l = {44, 46}, m = "invokeSuspend")
/* renamed from: ma  reason: default package */
/* compiled from: DataMigrationInitializer.kt */
public final class ma extends b76 implements w76<T, k66<? super T>, Object> {
    public Object f;
    public Object g;
    public Object h;
    public int i;
    public /* synthetic */ Object j;
    public final /* synthetic */ List<ja<T>> k;
    public final /* synthetic */ List<s76<k66<? super s56>, Object>> l;

    @y66(c = "androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2$1$1", f = "DataMigrationInitializer.kt", l = {45}, m = "invokeSuspend")
    /* renamed from: ma$a */
    /* compiled from: DataMigrationInitializer.kt */
    public static final class a extends b76 implements s76<k66<? super s56>, Object> {
        public int f;
        public final /* synthetic */ ja<T> g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ja<T> jaVar, k66<? super a> k66) {
            super(1, k66);
            this.g = jaVar;
        }

        @Override // defpackage.u66
        public final k66<s56> create(k66<?> k66) {
            return new a(this.g, k66);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.s76
        public Object invoke(k66<? super s56> k66) {
            return new a(this.g, k66).invokeSuspend(s56.f3190a);
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            p66 p66 = p66.COROUTINE_SUSPENDED;
            int i = this.f;
            if (i == 0) {
                hd3.Y2(obj);
                ja<T> jaVar = this.g;
                this.f = 1;
                if (jaVar.a(this) == p66) {
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

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.List<? extends ja<T>> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ma(List<? extends ja<T>> list, List<s76<k66<? super s56>, Object>> list2, k66<? super ma> k66) {
        super(2, k66);
        this.k = list;
        this.l = list2;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        ma maVar = new ma(this.k, this.l, k66);
        maVar.j = obj;
        return maVar;
    }

    @Override // defpackage.w76
    public Object invoke(Object obj, Object obj2) {
        ma maVar = new ma(this.k, this.l, (k66) obj2);
        maVar.j = obj;
        return maVar.invokeSuspend(s56.f3190a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0088  */
    @Override // defpackage.u66
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
        // Method dump skipped, instructions count: 142
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ma.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
