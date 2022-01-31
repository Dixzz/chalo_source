package defpackage;

import androidx.lifecycle.LiveData;

/* renamed from: th1  reason: default package */
/* compiled from: ExtensionUtils.kt */
public final class th1 implements ph<T> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ph<T> f3355a;
    public final /* synthetic */ LiveData<T> b;

    public th1(ph<T> phVar, LiveData<T> liveData) {
        this.f3355a = phVar;
        this.b = liveData;
    }

    @Override // defpackage.ph
    public void a(T t) {
        this.f3355a.a(t);
        this.b.k(this);
    }
}
