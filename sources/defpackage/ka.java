package defpackage;

import defpackage.na;
import java.util.List;

@y66(c = "androidx.datastore.core.DataMigrationInitializer$Companion$getInitializer$1", f = "DataMigrationInitializer.kt", l = {33}, m = "invokeSuspend")
/* renamed from: ka  reason: default package */
/* compiled from: DataMigrationInitializer.kt */
public final class ka extends b76 implements w76<qa<T>, k66<? super s56>, Object> {
    public int f;
    public /* synthetic */ Object g;
    public final /* synthetic */ List<ja<T>> h;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.List<? extends ja<T>> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ka(List<? extends ja<T>> list, k66<? super ka> k66) {
        super(2, k66);
        this.h = list;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        ka kaVar = new ka(this.h, k66);
        kaVar.g = obj;
        return kaVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public Object invoke(Object obj, k66<? super s56> k66) {
        ka kaVar = new ka(this.h, k66);
        kaVar.g = (qa) obj;
        return kaVar.invokeSuspend(s56.f3190a);
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        p66 p66 = p66.COROUTINE_SUSPENDED;
        int i = this.f;
        if (i == 0) {
            hd3.Y2(obj);
            na.a aVar = na.f2527a;
            List<ja<T>> list = this.h;
            this.f = 1;
            if (na.a.a(aVar, list, (qa) this.g, this) == p66) {
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
