package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* renamed from: yj4  reason: default package */
/* compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
public final class yj4 implements qi4<Void, yi4<List<yi4<?>>>> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Collection f4058a;

    public yj4(Collection collection) {
        this.f4058a = collection;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [yi4] */
    @Override // defpackage.qi4
    public final /* bridge */ /* synthetic */ yi4<List<yi4<?>>> then(yi4<Void> yi4) throws Exception {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f4058a);
        return hd3.W0(arrayList);
    }
}
