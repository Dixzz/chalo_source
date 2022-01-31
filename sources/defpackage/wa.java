package defpackage;

import androidx.appcompat.widget.RtlSpacingHelper;

@y66(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {276, 281, 284}, m = "handleUpdate")
/* renamed from: wa  reason: default package */
/* compiled from: SingleProcessDataStore.kt */
public final class wa extends w66 {
    public Object f;
    public Object g;
    public Object h;
    public /* synthetic */ Object i;
    public final /* synthetic */ ua<T> j;
    public int k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public wa(ua<T> uaVar, k66<? super wa> k66) {
        super(k66);
        this.j = uaVar;
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        this.i = obj;
        this.k |= RtlSpacingHelper.UNDEFINED;
        return ua.b(this.j, null, this);
    }
}
