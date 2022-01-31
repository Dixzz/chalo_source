package defpackage;

/* renamed from: w7  reason: default package */
/* compiled from: Pools */
public class w7<T> implements v7<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f3737a;
    public int b;

    public w7(int i) {
        if (i > 0) {
            this.f3737a = new Object[i];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    @Override // defpackage.v7
    public boolean a(T t) {
        int i;
        boolean z;
        int i2 = 0;
        while (true) {
            i = this.b;
            if (i2 >= i) {
                z = false;
                break;
            } else if (this.f3737a[i2] == t) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (!z) {
            Object[] objArr = this.f3737a;
            if (i >= objArr.length) {
                return false;
            }
            objArr[i] = t;
            this.b = i + 1;
            return true;
        }
        throw new IllegalStateException("Already in the pool!");
    }

    @Override // defpackage.v7
    public T b() {
        int i = this.b;
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        Object[] objArr = this.f3737a;
        T t = (T) objArr[i2];
        objArr[i2] = null;
        this.b = i - 1;
        return t;
    }
}
