package defpackage;

/* renamed from: tl2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class tl2 implements am2 {

    /* renamed from: a  reason: collision with root package name */
    public final am2[] f3374a;

    public tl2(am2... am2Arr) {
        this.f3374a = am2Arr;
    }

    @Override // defpackage.am2
    public final boolean a(Class<?> cls) {
        am2[] am2Arr = this.f3374a;
        for (int i = 0; i < 2; i++) {
            if (am2Arr[i].a(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.am2
    public final zl2 b(Class<?> cls) {
        am2[] am2Arr = this.f3374a;
        for (int i = 0; i < 2; i++) {
            am2 am2 = am2Arr[i];
            if (am2.a(cls)) {
                return am2.b(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
