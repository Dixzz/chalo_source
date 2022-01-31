package defpackage;

import defpackage.mm5;

/* renamed from: nm5  reason: default package */
/* compiled from: AutomationEngine */
public class nm5 extends mx5<mm5.v> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ mm5 f2576a;

    public nm5(mm5 mm5) {
        this.f2576a = mm5;
    }

    @Override // defpackage.hx5
    public void b(Object obj) {
        mm5.v vVar = (mm5.v) obj;
        mm5 mm5 = this.f2576a;
        mm5.i.post(new rm5(mm5, vVar.f2407a, vVar.b, vVar.c));
    }
}
