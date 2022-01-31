package defpackage;

/* renamed from: rh2  reason: default package */
public final class rh2 implements yh2 {

    /* renamed from: a  reason: collision with root package name */
    public yh2[] f3080a;

    public rh2(yh2... yh2Arr) {
        this.f3080a = yh2Arr;
    }

    @Override // defpackage.yh2
    public final xh2 a(Class<?> cls) {
        yh2[] yh2Arr = this.f3080a;
        for (yh2 yh2 : yh2Arr) {
            if (yh2.b(cls)) {
                return yh2.a(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }

    @Override // defpackage.yh2
    public final boolean b(Class<?> cls) {
        for (yh2 yh2 : this.f3080a) {
            if (yh2.b(cls)) {
                return true;
            }
        }
        return false;
    }
}
