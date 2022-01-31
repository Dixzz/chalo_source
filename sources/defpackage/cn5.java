package defpackage;

import defpackage.gm5;

/* renamed from: cn5  reason: default package */
/* compiled from: InAppAutomation */
public class cn5 implements gm5.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ln5 f585a;
    public final /* synthetic */ nn5 b;
    public final /* synthetic */ gm5.b c;
    public final /* synthetic */ dn5 d;

    public cn5(dn5 dn5, ln5 ln5, nn5 nn5, gm5.b bVar) {
        this.d = dn5;
        this.f585a = ln5;
        this.b = nn5;
        this.c = bVar;
    }

    @Override // defpackage.gm5.b
    public void a(int i) {
        if (i == 0) {
            this.d.q.put(this.f585a.f2243a, this.b);
        }
        this.c.a(i);
    }
}
