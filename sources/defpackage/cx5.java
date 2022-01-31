package defpackage;

import java.util.Collection;

/* renamed from: cx5  reason: default package */
/* compiled from: Observable */
public final class cx5 implements qw5<hx5<T>, nx5> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Collection f766a;

    public cx5(Collection collection) {
        this.f766a = collection;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.qw5
    public nx5 apply(Object obj) {
        hx5 hx5 = (hx5) obj;
        for (Object obj2 : this.f766a) {
            hx5.b(obj2);
        }
        hx5.a();
        return new nx5();
    }
}
