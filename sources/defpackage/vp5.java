package defpackage;

import java.util.List;

/* renamed from: vp5  reason: default package */
/* compiled from: NamedUser */
public class vp5 extends iq5 {
    public final /* synthetic */ up5 b;

    public vp5(up5 up5) {
        this.b = up5;
    }

    @Override // defpackage.iq5
    public void d(List<jq5> list) {
        if (!this.b.i.d(64, 32)) {
            yj5.i("NamedUser - Ignoring tag edits while contacts and/or tags and attributes are disabled.", new Object[0]);
        } else if (!list.isEmpty()) {
            this.b.l.a(list);
            this.b.i();
        }
    }
}
