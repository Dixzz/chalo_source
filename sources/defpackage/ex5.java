package defpackage;

/* renamed from: ex5  reason: default package */
/* compiled from: Observable */
public class ex5 implements qw5<T, sw5<T>> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ dk5 f1040a;

    public ex5(sw5 sw5, dk5 dk5) {
        this.f1040a = dk5;
    }

    @Override // defpackage.qw5
    public Object apply(Object obj) {
        if (this.f1040a.apply(obj)) {
            return sw5.e(obj);
        }
        return sw5.c();
    }
}
