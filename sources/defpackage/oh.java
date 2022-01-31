package defpackage;

import androidx.lifecycle.LiveData;

/* renamed from: oh  reason: default package */
/* compiled from: MutableLiveData */
public class oh<T> extends LiveData<T> {
    public oh(T t) {
        super(t);
    }

    @Override // androidx.lifecycle.LiveData
    public void j(T t) {
        super.j(t);
    }

    @Override // androidx.lifecycle.LiveData
    public void l(T t) {
        LiveData.a("setValue");
        this.g++;
        this.e = t;
        c(null);
    }

    public oh() {
    }
}
