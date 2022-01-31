package defpackage;

import defpackage.mm5;

/* renamed from: pm5  reason: default package */
/* compiled from: AutomationEngine */
public class pm5 implements qw5<cu5, mm5.v> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Integer f2831a;
    public final /* synthetic */ mm5.c b;

    public pm5(mm5.c cVar, Integer num) {
        this.b = cVar;
        this.f2831a = num;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.qw5
    public mm5.v apply(cu5 cu5) {
        return new mm5.v(mm5.this.w.e(this.f2831a.intValue(), this.b.f2401a.f3238a.b), cu5, 1.0d);
    }
}
