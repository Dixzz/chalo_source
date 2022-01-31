package defpackage;

/* renamed from: yw5  reason: default package */
/* compiled from: Observable */
public final class yw5 implements qw5<hx5<T>, nx5> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ pw5 f4093a;
    public final /* synthetic */ sw5 b;
    public final /* synthetic */ sw5 c;

    public yw5(pw5 pw5, sw5 sw5, sw5 sw52) {
        this.f4093a = pw5;
        this.b = sw5;
        this.c = sw52;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.qw5
    public nx5 apply(Object obj) {
        this.f4093a.c(this.b.g(new ww5(this, (hx5) obj)));
        return new nx5(new xw5(this));
    }
}
