package defpackage;

import defpackage.m36;

/* renamed from: d46  reason: default package */
/* compiled from: Socket */
public class d46 implements m36.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ u36 f787a;

    public d46(u36 u36, u36 u362) {
        this.f787a = u362;
    }

    @Override // defpackage.m36.a
    public void a(Object... objArr) {
        u36 u36 = this.f787a;
        for (int i = 0; i < u36.h; i++) {
            u36.s.poll();
        }
        u36.h = 0;
        if (u36.s.size() == 0) {
            u36.a("drain", new Object[0]);
        } else {
            u36.h();
        }
    }
}
