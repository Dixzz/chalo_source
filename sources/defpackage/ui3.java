package defpackage;

/* renamed from: ui3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class ui3 implements dj3 {

    /* renamed from: a  reason: collision with root package name */
    public dj3[] f3509a;

    public ui3(dj3... dj3Arr) {
        this.f3509a = dj3Arr;
    }

    @Override // defpackage.dj3
    public final boolean a(Class<?> cls) {
        for (dj3 dj3 : this.f3509a) {
            if (dj3.a(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.dj3
    public final ej3 b(Class<?> cls) {
        dj3[] dj3Arr = this.f3509a;
        for (dj3 dj3 : dj3Arr) {
            if (dj3.a(cls)) {
                return dj3.b(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
