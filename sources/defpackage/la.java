package defpackage;

import androidx.appcompat.widget.RtlSpacingHelper;
import defpackage.na;

@y66(c = "androidx.datastore.core.DataMigrationInitializer$Companion", f = "DataMigrationInitializer.kt", l = {42, 57}, m = "runMigrations")
/* renamed from: la  reason: default package */
/* compiled from: DataMigrationInitializer.kt */
public final class la<T> extends w66 {
    public Object f;
    public Object g;
    public /* synthetic */ Object h;
    public final /* synthetic */ na.a i;
    public int j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public la(na.a aVar, k66<? super la> k66) {
        super(k66);
        this.i = aVar;
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        this.h = obj;
        this.j |= RtlSpacingHelper.UNDEFINED;
        return na.a.a(this.i, null, null, this);
    }
}
