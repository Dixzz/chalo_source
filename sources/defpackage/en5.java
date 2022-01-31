package defpackage;

import defpackage.gm5;

/* renamed from: en5  reason: default package */
/* compiled from: InAppAutomation */
public class en5 implements gm5.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ln5 f1008a;
    public final /* synthetic */ gm5.b b;
    public final /* synthetic */ dn5 c;

    public en5(dn5 dn5, ln5 ln5, gm5.b bVar) {
        this.c = dn5;
        this.f1008a = ln5;
        this.b = bVar;
    }

    @Override // defpackage.gm5.b
    public void a(int i) {
        if (i != 0) {
            this.c.r.remove(this.f1008a.f2243a);
        }
        this.b.a(i);
    }
}
