package defpackage;

import defpackage.bb5;

/* renamed from: db5  reason: default package */
/* compiled from: Draft_17 */
public class db5 extends cb5 {
    @Override // defpackage.bb5, defpackage.cb5
    public bb5.b b(rb5 rb5) throws jb5 {
        if (cb5.p(rb5) == 13) {
            return bb5.b.MATCHED;
        }
        return bb5.b.NOT_MATCHED;
    }

    @Override // defpackage.bb5, defpackage.cb5
    public bb5 e() {
        return new db5();
    }

    @Override // defpackage.bb5, defpackage.cb5
    public tb5 i(tb5 tb5) {
        super.i(tb5);
        tb5.b.put("Sec-WebSocket-Version", "13");
        return tb5;
    }
}
