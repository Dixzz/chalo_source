package defpackage;

import defpackage.mm5;

/* renamed from: lm5  reason: default package */
/* compiled from: AutomationEngine */
public class lm5 implements qw5<cu5, mm5.v> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2239a;
    public final /* synthetic */ mm5 b;

    public lm5(mm5 mm5, int i) {
        this.b = mm5;
        this.f2239a = i;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.qw5
    public mm5.v apply(cu5 cu5) {
        this.b.o.put(this.f2239a, Long.valueOf(System.currentTimeMillis()));
        return new mm5.v(this.b.w.d(this.f2239a), cu5, 1.0d);
    }
}
