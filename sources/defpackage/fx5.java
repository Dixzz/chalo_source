package defpackage;

import defpackage.sw5;

/* renamed from: fx5  reason: default package */
/* compiled from: Observable */
public class fx5 implements qw5<T, sw5<T>> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ sw5.f f1183a;

    public fx5(sw5 sw5, sw5.f fVar) {
        this.f1183a = fVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.qw5
    public Object apply(Object obj) {
        T t = this.f1183a.f3271a;
        if (t != null && obj.equals(t)) {
            return sw5.c();
        }
        this.f1183a.f3271a = obj;
        return sw5.e(obj);
    }
}
