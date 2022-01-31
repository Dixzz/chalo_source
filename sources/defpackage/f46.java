package defpackage;

import defpackage.m36;

/* renamed from: f46  reason: default package */
/* compiled from: Socket */
public class f46 implements m36.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean[] f1090a;
    public final /* synthetic */ Runnable[] b;
    public final /* synthetic */ i46[] c;

    public f46(u36 u36, boolean[] zArr, Runnable[] runnableArr, i46[] i46Arr) {
        this.f1090a = zArr;
        this.b = runnableArr;
        this.c = i46Arr;
    }

    @Override // defpackage.m36.a
    public void a(Object... objArr) {
        boolean[] zArr = this.f1090a;
        if (!zArr[0]) {
            zArr[0] = true;
            this.b[0].run();
            this.c[0].e();
            this.c[0] = null;
        }
    }
}
