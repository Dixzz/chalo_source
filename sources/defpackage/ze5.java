package defpackage;

import android.util.LruCache;
import defpackage.af5;

/* renamed from: ze5  reason: default package */
/* compiled from: LruCache */
public class ze5 extends LruCache<String, af5.a> {
    public ze5(af5 af5, int i) {
        super(i);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // android.util.LruCache
    public int sizeOf(String str, af5.a aVar) {
        return aVar.b;
    }
}
