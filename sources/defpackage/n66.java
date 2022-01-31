package defpackage;

import defpackage.l66;
import defpackage.m66;

/* renamed from: n66  reason: default package */
/* compiled from: CoroutineContext.kt */
public final class n66 extends o86 implements w76<m66, m66.a, m66> {
    public static final n66 f = new n66();

    public n66() {
        super(2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public m66 invoke(m66 m66, m66.a aVar) {
        j66 j66;
        m66 m662 = m66;
        m66.a aVar2 = aVar;
        n86.e(m662, "acc");
        n86.e(aVar2, "element");
        m66 minusKey = m662.minusKey(aVar2.getKey());
        o66 o66 = o66.f;
        if (minusKey == o66) {
            return aVar2;
        }
        int i = l66.c;
        l66.a aVar3 = l66.a.f;
        l66 l66 = (l66) minusKey.get(aVar3);
        if (l66 == null) {
            j66 = new j66(minusKey, aVar2);
        } else {
            m66 minusKey2 = minusKey.minusKey(aVar3);
            if (minusKey2 == o66) {
                return new j66(aVar2, l66);
            }
            j66 = new j66(new j66(minusKey2, aVar2), l66);
        }
        return j66;
    }
}
