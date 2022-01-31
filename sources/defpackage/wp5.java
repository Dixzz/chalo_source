package defpackage;

import java.util.List;

/* renamed from: wp5  reason: default package */
/* compiled from: NamedUser */
public class wp5 extends op5 {
    public final /* synthetic */ up5 c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public wp5(up5 up5, hy5 hy5) {
        super(hy5);
        this.c = up5;
    }

    @Override // defpackage.op5
    public void c(List<qp5> list) {
        if (!this.c.i.d(64, 32)) {
            yj5.i("NamedUser - Ignoring attributes edits while contacts and/or tags and attributes are disabled.", new Object[0]);
        } else if (!list.isEmpty()) {
            this.c.m.a(list);
            this.c.i();
        }
    }
}
